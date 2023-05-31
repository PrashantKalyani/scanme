package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Employee;
import com.desapex.spacemanager.domain.Workspace;
import com.desapex.spacemanager.domain.WorkspaceBooking;
import com.desapex.spacemanager.repository.EmployeeRepository;
import com.desapex.spacemanager.resource.dto.EmployeeDto;
import com.desapex.spacemanager.resource.dto.Employee_DBUtil;
import com.desapex.spacemanager.resource.transformer.DepartmentDtoTransformer;
import com.desapex.spacemanager.resource.transformer.EmployeeDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService {

    Connection connection;


    @Autowired

    private EmployeeRepository employeeRepository;
    private boolean status;
    @Autowired
    private EmployeeDtoTransformer employeeDtoTransformer;


    @Override
    public List<Employee> getEmployees(Long organisationId, Long officeId) {
        return employeeRepository.findAll()
                .stream()
                .filter(employee -> filterByOrganisation(employee, organisationId))
                .filter(employee -> filterByOffice(employee, officeId))
                .collect(Collectors.toList());
    }

    private boolean filterByOrganisation(Employee employee, Long organisationId) {
        if (organisationId == null) {
            return true;
        }
        return Objects.equals(employee.organisation.id, organisationId);
    }

    private boolean filterByOffice(Employee employee, Long officeId) {
        if (officeId == null) {
            return true;
        }
        return Objects.equals(employee.office.id, officeId);
    }

    public EmployeeService() throws SQLException {
        connection = Employee_DBUtil.getConnection();
    }


    @Override
    public String addEmployee(EmployeeDto employeeDTO) {
        String email = employeeDTO.getEmail();
        boolean isEmployeeExists = isEmployeeEmailExists(email);
        if (isEmployeeExists) {
            return "Employee with the same email already exists";
        }

        try {
            Employee employee = employeeDTO.toEmployee();
            employeeRepository.save(employee);
            return "Employee Registered Successfully";
        } catch (Exception e) {
            return "Error occurred during employee registration";
        }
    }

    @Override
    public boolean isEmployeeEmailExists(String email) {
        Employee existingEmployee = employeeRepository.findByEmail(email);
        return existingEmployee != null;
    }

    @Override
    public void deleteEmployeeByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email);
        if (employee != null) {
            employeeRepository.delete(employee);
        }
    }

    @Override
    public Map<String, Object> loginValidation(String username, String password) {
        int userId = -1;
        String userEmail = null;
        String userName = null;
        String job = null;
        int departmentId = -1;
        String departmentName = null;
        int departmentCredit = -1;
        List<WorkspaceBooking> workspaceBookings = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT e.*,d.name, d.credit FROM EMPLOYEE e INNER JOIN DEPARTMENT d ON e.department_id = d.id WHERE e.email = ?");
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                if (rs.getString(9).equals(password)) { // only check password
                    userId = rs.getInt(1); // get the user ID
                    userEmail = rs.getString(6); // get the user email
                    userName = rs.getString(4); // get the user name
                    job = rs.getString(11); //get the job
                    departmentId = rs.getInt(10); // get the department ID
                    departmentName = rs.getString(13);
                    departmentCredit = rs.getInt(14); // get the department name
                    String jobStatus = rs.getString("jobstatus");
                    status = jobStatus.equalsIgnoreCase("active");

                    break;
                }
            }



            if (userId != -1) {
                PreparedStatement bookingStatement = connection.prepareStatement(
                        "SELECT wb.id, wb.start_time, wb.workspace_id, wb.end_time, wb.type, w.qr_data " +
                                "FROM WORKSPACE_BOOKING wb " +
                                "INNER JOIN Workspace w ON wb.workspace_id = w.id " +
                                "WHERE wb.employee_id = ?");
                bookingStatement.setInt(1, userId);
                ResultSet bookingResultSet = bookingStatement.executeQuery();
                while (bookingResultSet.next()) {
                    // Retrieve workspace booking details
                    Long workspaceId = bookingResultSet.getLong("workspace_id");
                    Workspace workspace = new Workspace();
                    workspace.setId(workspaceId);

                    // Create a WorkspaceBooking object and set the retrieved values
                    WorkspaceBooking workspaceBooking = new WorkspaceBooking();
                    Long bookingId = bookingResultSet.getLong("id");
                    LocalDateTime startTime = bookingResultSet.getTimestamp("start_time").toLocalDateTime();
                    LocalDateTime endTime = bookingResultSet.getTimestamp("end_time").toLocalDateTime();
                    String bookingType = bookingResultSet.getString("type");
                    String qrData = bookingResultSet.getString("qr_data");

                    workspaceBooking.setId(bookingId);
                    workspaceBooking.setWorkspace(workspace);
                    workspaceBooking.setStartTime(startTime);
                    workspaceBooking.setEndTime(endTime);
                    workspaceBooking.setType(bookingType);
                    workspace.setQrData(qrData);

                    // Add the workspace booking to the list
                    workspaceBookings.add(workspaceBooking);
                }
            }



            Map<String, Object> result = new HashMap<>();
            result.put("userId", Optional.of(userId));
            result.put("userEmail", userEmail);
            result.put("userName", userName);
            result.put("job", job);
            result.put("status", Optional.of(status)); // Include the status boolean value
            result.put("departmentId", Optional.of(departmentId));
            result.put("departmentName", departmentName);
            result.put("departmentCredit", Optional.of(departmentCredit));
            result.put("workspaceBookings", workspaceBookings);

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        return employeeDtoTransformer.transform(employee);
    }

    @Override
    public void updateEmployeeStatus(Long employeeId, boolean newStatus) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setStatus(newStatus);
            employeeRepository.save(employee);
        } else {
            throw new IllegalArgumentException("Employee not found");
        }
    }

    @Override
    public boolean resetPassword(String username, String oldPassword, String newPassword) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE email = ?");
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                if (rs.getString(9).equals(oldPassword)) {
                    // Update the password
                    PreparedStatement updateStatement = connection.prepareStatement("UPDATE EMPLOYEE SET password = ? WHERE email = ?");
                    updateStatement.setString(1, newPassword);
                    updateStatement.setString(2, username);
                    updateStatement.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}










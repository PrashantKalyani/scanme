package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Employee;
import com.desapex.spacemanager.repository.EmployeeRepository;
import com.desapex.spacemanager.resource.transformer.EmployeeDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

//    public EmployeeService() throws SQLException {
//        connection = Employee_DBUtil.getConnection();
//    }


    @Override
    public boolean isEmployeeEmailExists(String email) {
        Employee existingEmployee = employeeRepository.findByEmail(email);
        return existingEmployee != null;
    }

    @Override
    public Map<String, Object> loginValidation(String username, String password) {
        int userId = -1;
        String userEmail = null;
        String userName = null;
        String job = null;
        int departmentId = -1;
        String departmentName = null;

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
                    String jobStatus = rs.getString("jobstatus");
                    status = jobStatus.equalsIgnoreCase("active");

                    break;
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
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String resetPassword(String email, String oldPassword, String newPassword) {
        // Find the employee by email
        Employee employee = employeeRepository.findByEmail(email);
        if (employee == null) {
            return "USER_NOT_FOUND";
        }

        // Check if old password matches
        if (!employee.getPassword().equals(oldPassword)) {
            return "WRONG_PASSWORD";
        }

        // Update password
        employee.setPassword(newPassword);
        employeeRepository.save(employee);

        return "SUCCESS";
    }
}










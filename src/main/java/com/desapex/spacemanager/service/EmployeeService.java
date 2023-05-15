package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Employee;
import com.desapex.spacemanager.repository.EmployeeRepository;
import com.desapex.spacemanager.resource.dto.EmployeeDto;
import com.desapex.spacemanager.resource.dto.Employee_DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService {

    Connection connection;


    @Autowired

    private EmployeeRepository employeeRepository;

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

    public EmployeeService() throws SQLException
    {
        connection = Employee_DBUtil.getConnection();
    }

    @Override
    public Map<String, Object> loginValidation(String username, String password) {
        int userId = -1; // initialize to -1 if user not found
        String userEmail = null;
        String userName = null;
        String job = null;
        int departmentId = -1; // initialize to -1 if department not found
        String departmentName = null;
        int departmentCredit = -1;

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
                    departmentName = rs.getString(12);
                    departmentCredit = rs.getInt(13); // get the department name
                    break;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Map<String, Object> result = new HashMap<>();
        result.put("userId", userId);
        result.put("userEmail", userEmail);
        result.put("userName", userName);
        result.put("job", job);
        result.put("departmentId", departmentId);
        result.put("departmentName", departmentName);
        result.put("departmentCredit", departmentCredit);
        return result;
    }

    @Override
    public String addEmployee(EmployeeDto employeeDTO) {
        String email = employeeDTO.getEmail();
        boolean isEmployeeExists = isEmployeeEmailExists(email);
        if (isEmployeeExists) {
            return "Employee with the same email already exists";
        }

        try {
            Employee employee = new Employee(
                    employeeDTO.getId(),
                    employeeDTO.getOrganisation(),
                    employeeDTO.getOffice(),
                    employeeDTO.getFirst_name(),
                    employeeDTO.getLast_name(),
                    employeeDTO.getUser(),
                    employeeDTO.getPassword(),
                    employeeDTO.getEmail(),
                    employeeDTO.getPhone(),
                    employeeDTO.getDepartment(),
                    employeeDTO.getJobrole());

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
}

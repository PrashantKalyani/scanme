package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Employee;
import com.desapex.spacemanager.repository.EmployeeRepository;
import com.desapex.spacemanager.resource.dto.Employee_DBUtil;
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

    public EmployeeService() throws SQLException {
        connection = Employee_DBUtil.getConnection();
    }


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
        String sign = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT e.*,d.name, d.credit FROM EMPLOYEE e INNER JOIN DEPARTMENT d ON e.department_id = d.id WHERE e.email = ?");
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                if (rs.getString(9).equals(password)) {
                    userId = rs.getInt(1);
                    userEmail = rs.getString(6);
                    userName = rs.getString(4);
                    job = rs.getString(11);
                    departmentId = rs.getInt(10);
                    departmentName = rs.getString(13);
                    sign = rs.getString("sign");
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
            result.put("status", Optional.of(status));
            result.put("departmentId", Optional.of(departmentId));
            result.put("departmentName", departmentName);
            result.put("sign", sign);
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String resetPassword(String email, String oldPassword, String newPassword) {
        Employee employee = employeeRepository.findByEmail(email);
        if (employee == null) {
            return "USER_NOT_FOUND";
        }

        if (!employee.getPassword().equals(oldPassword)) {
            return "WRONG_PASSWORD";
        }

        employee.setPassword(newPassword);
        employeeRepository.save(employee);

        return "SUCCESS";
    }

    @Override
    public List<String> getEmailsByUsername(String username) {
        Employee employee = employeeRepository.findByEmail(username);
        if (employee == null) {
            throw new RuntimeException("User not found.");
        }

        Long departmentId = employee.getDepartment().getId();

        return employeeRepository.findByDepartmentId(departmentId)
                .stream()
                .map(Employee::getEmail)
                .collect(Collectors.toList());
    }

    @Override
    public void updateSign(String email, byte[] sign) {
        Employee employee = employeeRepository.findByEmail(email);
        if (employee == null) {
            throw new RuntimeException("User not found.");
        }

        employee.setSign(sign);
        employeeRepository.save(employee);
    }

    @Override
    public byte[] getSignByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email);
        if (employee == null) {
            throw new RuntimeException("User not found.");
        }

        return employee.getSign();
    }
}










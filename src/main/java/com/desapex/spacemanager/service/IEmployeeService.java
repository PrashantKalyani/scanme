package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Employee;
import com.desapex.spacemanager.resource.dto.EmployeeDto;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    public List<Employee> getEmployees(Long organisationId, Long officeId);
    public Map<String, Object> loginValidation(String username, String password);
    public String addEmployee(EmployeeDto employeeDTO);

    public boolean isEmployeeEmailExists(String email);

    public  void deleteEmployeeByEmail(String email);

    EmployeeDto getEmployeeById(Long employeeId);

    void updateEmployeeStatus(Long employeeId, boolean newStatus);

    boolean resetPassword(String username, String oldPassword, String newPassword);
}

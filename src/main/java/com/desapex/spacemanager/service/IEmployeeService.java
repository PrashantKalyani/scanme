package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Employee;
import com.desapex.spacemanager.resource.dto.EmployeeDto;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    public List<Employee> getEmployees(Long organisationId, Long officeId);
    public Map<String, Object> loginValidation(String username, String password);


    public boolean isEmployeeEmailExists(String email);
    String resetPassword(String email, String oldPassword, String newPassword);
}

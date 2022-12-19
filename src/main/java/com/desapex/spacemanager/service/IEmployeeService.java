package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Employee;
import java.util.List;

public interface IEmployeeService {

    public List<Employee> getEmployees(Long organisationId, Long officeId);

}

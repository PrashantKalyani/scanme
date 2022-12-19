package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Employee;
import com.desapex.spacemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService {

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

}

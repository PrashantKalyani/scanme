package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Department;
import com.desapex.spacemanager.resource.dto.DepartmentDto;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IDepartmentService {
    String addCredits(String departmentName, Long credits);

    public List<Department> getDepartments(Long officeId);

    Department getDepartmentByName(String departmentName);

    void addDepartment(Department department);

    void updateDepartment(Department department);

    Long getCredits(String departmentName);
}

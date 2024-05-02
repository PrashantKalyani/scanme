package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Department;
import com.desapex.spacemanager.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public String addCredits(String departmentName, Long credits) {
        Department department = departmentRepository.findByName(departmentName);
        if (department == null) {
            // Department does not exist in the database
            return "Department not found";
        }
        Long currentCredits = department.getCredit();
        department.setCredit(currentCredits + credits);
        departmentRepository.save(department);
        return "Credits added successfully";
    }

    @Override
    public List<Department> getDepartments(Long officeId) {
        return null;
    }


    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByName(departmentName);
    }


    @Override
    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentRepository.save(department);
    }
    @Override
    public Long getCredits(String departmentName) {
        Department department = departmentRepository.findByName(departmentName);
        if (department == null) {
            // Department does not exist in the database
            return null;
        }
        return department.getCredit();
    }







}

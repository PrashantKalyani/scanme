package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.domain.Department;
import com.desapex.spacemanager.resource.dto.DepartmentDto;
import com.desapex.spacemanager.resource.transformer.DepartmentDtoTransformer;
import com.desapex.spacemanager.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/department")

public class DepartmentResource {

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private DepartmentDtoTransformer departmentDtoTransformer;
    private Long officeId;

    @GetMapping(path = "/details")
    public List<DepartmentDto> getDepartmentDetails(@RequestParam(name = "officeId", required = false) Long officeId) {
        this.officeId = officeId;
        List<Department> departments = departmentService.getDepartments(officeId);
        return departments.stream()
                .map(department -> departmentDtoTransformer.transform(department))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/credit/{departmentName}")
    public Long getCredit(@PathVariable String departmentName) {
        Department department = departmentService.getDepartmentByName(departmentName);

        if (department == null) {
            // Department does not exist in the database
            return null;
        } else {
            // Department exists, return its credits
            return department.getCredit();
        }
    }



    @PostMapping(path = "/credit")
    public Long saveCredit(@RequestBody DepartmentDto departmentDto) {
        String departmentName = departmentDto.getName();
        Long credits = departmentDto.getCredit();

        Department department = departmentService.getDepartmentByName(departmentName);

        if (department == null) {
            // Department does not exist in the database, create it
            department = new Department();
            department.setName(departmentName);
            department.setCredit(credits);
            departmentService.addDepartment(department);
        } else {
            // Department exists, update its credits
            Long totalCredits = department.getCredit() + credits;
            department.setCredit(totalCredits);
            departmentService.updateDepartment(department);
        }

        // Retrieve the updated department credits from the database
        Department updatedDepartment = departmentService.getDepartmentByName(departmentName);

        return updatedDepartment.getCredit();
    }






}

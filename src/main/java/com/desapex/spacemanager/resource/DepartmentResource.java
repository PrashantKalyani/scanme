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
}

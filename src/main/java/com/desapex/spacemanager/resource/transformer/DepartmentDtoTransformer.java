package com.desapex.spacemanager.resource.transformer;

import com.desapex.spacemanager.domain.Department;
import com.desapex.spacemanager.resource.dto.DepartmentDto;
import org.springframework.stereotype.Component;

@Component
public class DepartmentDtoTransformer {

    public DepartmentDto transform(Department department) {
        DepartmentDto dto = new DepartmentDto();
        dto.id = department.id;
        dto.name = department.name;
        dto.credit = department.credit;
        return dto;
    }

}

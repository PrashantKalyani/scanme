package com.desapex.spacemanager.resource.transformer;

import com.desapex.spacemanager.domain.Employee;
import com.desapex.spacemanager.resource.dto.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDtoTransformer {

    public EmployeeDto transform(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.id = employee.id;
        dto.first_name = employee.first_name;
        dto.last_name = employee.last_name;
        return dto;
    }

}

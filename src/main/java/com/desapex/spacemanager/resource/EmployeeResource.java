package com.desapex.spacemanager.resource;

import com.desapex.spacemanager.resource.dto.EmployeeDto;
import com.desapex.spacemanager.resource.transformer.EmployeeDtoTransformer;
import com.desapex.spacemanager.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("employee")
public class EmployeeResource {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private EmployeeDtoTransformer employeeDtoTransformer;

    @GetMapping
    public List<EmployeeDto> getEmployees(@RequestParam(name = "organisationId", required = false) Long organisationId,
                                          @RequestParam(name = "officeId", required = false) Long officeId) {
        return employeeService.getEmployees(organisationId, officeId)
                .stream()
                .map(office -> employeeDtoTransformer.transform(office))
                .collect(Collectors.toList());
    }

}

package com.desapex.spacemanager.resource.dto;

import com.desapex.spacemanager.domain.Department;
import com.desapex.spacemanager.domain.Employee;
import com.desapex.spacemanager.domain.Office;
import com.desapex.spacemanager.domain.Organisation;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDto {

    public Long id;
    public Organisation organisation;
    public Office office;
    public String first_name;
    public String last_name;
    public String user;
    public String password;
    public String email;
    public String phone;
    public Department department_id;
    public String jobrole;

}

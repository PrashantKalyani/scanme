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
    private boolean jobstatus;


    public Employee toEmployee() {
        Employee employee = new Employee();
        employee.setId(this.getId());
        employee.setOrganisation(this.getOrganisation());
        employee.setOffice(this.getOffice());
        employee.setFirst_name(this.getFirst_name());
        employee.setLast_name(this.getLast_name());
        employee.setUser(this.getUser());
        employee.setPassword(this.getPassword());
        employee.setEmail(this.getEmail());
        employee.setPhone(this.getPhone());
        employee.setDepartment_id(this.getDepartment_id());
        employee.setJobrole(this.getJobrole());
        employee.setStatus(this.jobstatus);
        return employee;
    }
}

package com.desapex.spacemanager.resource.dto;

import com.desapex.spacemanager.domain.Department;
import com.desapex.spacemanager.domain.Office;
import com.desapex.spacemanager.domain.Organisation;

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

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, Organisation organisation, Office office,  String first_name, String last_name, String user, String password , String email , String phone , Department department_id , String jobrole) {
        this.id = id;
        this.organisation = organisation;
        this.office = office;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user = user;
        this.password = password ;
        this.email = email;
        this.phone = phone;
        this.department_id = department_id;
        this.jobrole = jobrole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Department getDepartment() {
        return department_id;
    }

    public void setDepartment(Department department_id) {
        this.department_id = department_id;
    }

    public String getJobrole() {
        return jobrole;
    }

    public void setJobrole(String jobrole) {
        this.jobrole = jobrole;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "id=" + id +
                ", organisation=" + organisation +
                ", office=" + office +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", department='" + department_id + '\'' +
                ", jobrole='" + jobrole + '\'' +
                '}';
    }
}

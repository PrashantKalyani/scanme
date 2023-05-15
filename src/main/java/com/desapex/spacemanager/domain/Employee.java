package com.desapex.spacemanager.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Employee")
public class Employee {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public Long id;

    @ManyToOne(targetEntity = Organisation.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "organisation_id", referencedColumnName = "id")
    public Organisation organisation;

    @ManyToOne(targetEntity = Office.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "office_id", referencedColumnName = "id")
    public Office office;

    @Column(name = "first_name", nullable = false)
    public String first_name;

    @Column(name = "last_name", nullable = false)
    public String last_name;

    @Column(name = "user", nullable = false)
    public String user;

    @Column(name = "password" , nullable = false)
    public String password;

    @Column(name = "email", nullable = false)
    public String email;

    @Column(name = "phone", nullable = false)
    public String phone;

    @ManyToOne(targetEntity = Department.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    public Department department_id;

    @Column(name = "job" , nullable = false)
    public String jobrole;

    public Department getDepartment() {
        return department_id;
    }

    public List<WorkspaceBooking> getWorkspaceBookings() {
        List<WorkspaceBooking> workspaceBookings = new ArrayList<>();
        for (WorkspaceBooking booking : workspaceBookings) {
            if (booking.employee.equals(this.id)) {
                workspaceBookings.add(booking);
            }
        }
        return workspaceBookings;
    }

    public Employee() {
    }

    public Employee(Long id, Organisation organisation, Office office,  String first_name, String last_name, String user, String password , String email , String phone , Department department_id , String jobrole) {
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



    public String getJobrole() {
        return jobrole;
    }

    public void setJobrole(String jobrole) {
        this.jobrole = jobrole;
    }

    @Override
    public String toString() {
        return "Employee{" +
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

package com.desapex.spacemanager.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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

    public List<WorkspaceBooking> getWorkspaceBookings() {
        List<WorkspaceBooking> workspaceBookings = new ArrayList<>();
        for (WorkspaceBooking booking : workspaceBookings) {
            if (booking.employee.equals(this.id)) {
                workspaceBookings.add(booking);
            }
        }
        return workspaceBookings;
    }


    public Department getDepartment() {
        return department_id;
    }
}
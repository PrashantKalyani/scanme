package com.desapex.spacemanager.domain;

import  jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Parkingspace_Booking")
public class ParkingspaceBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long id;

    @ManyToOne(targetEntity = Parkingspace.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "parkingspace_id", referencedColumnName = "id")
    public Parkingspace parkingspace;

    @ManyToOne(targetEntity = Employee.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    public Employee employee;

    @Column(name = "date", nullable = false)
    public LocalDate date;

    @Column(name = "startTime", nullable = false)
    public LocalTime startTime;

    @Column(name = "endTime", nullable = false)
    public LocalTime endTime;

}

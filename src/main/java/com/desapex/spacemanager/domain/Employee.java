package com.desapex.spacemanager.domain;

import jakarta.persistence.*;

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


}

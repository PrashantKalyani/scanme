package com.desapex.spacemanager.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Organisation")
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "name", nullable = false)
    public String name;

    @OneToMany(targetEntity = Office.class, mappedBy = "organisation")
    public List<Office> offices;

}

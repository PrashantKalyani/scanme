package com.desapex.spacemanager.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long id;

    @ManyToOne(targetEntity = Organisation.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "organisation_id", referencedColumnName = "id")
    public Organisation organisation;

    @Column(name = "name", nullable = false)
    public String name;


    public Office() {
    }

    public Office(int id) {
        this.id = (long) id;
    }
}

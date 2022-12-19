package com.desapex.spacemanager.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Workspace_Floor")
public class WorkspaceFloor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public Long id;

    @ManyToOne(targetEntity = Office.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "office_id", referencedColumnName = "id")
    public Office office;

    @Column(name = "name", nullable = false)
    public String name;

}

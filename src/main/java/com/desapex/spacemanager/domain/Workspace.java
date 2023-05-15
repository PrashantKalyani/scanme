package com.desapex.spacemanager.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Workspace")
public class Workspace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public Long id;

    @ManyToOne(targetEntity = WorkspaceFloor.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "workspaceFloorId", referencedColumnName = "id")
    public WorkspaceFloor floor;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    public WorkspaceType workspaceType;

    @Column(name = "max_occupancy", nullable = false)
    public Long maxOccupancy;

    @Column(name = "media", nullable = false)
    public String media;

    @Column(name = "cooling", nullable = false)
    public String cooling;

    @OneToMany(targetEntity = WorkspaceBooking.class, mappedBy = "workspace", fetch = FetchType.EAGER)
    public List<WorkspaceBooking> bookings;

    public WorkspaceType getType() {
        return workspaceType;
    }

    public void setWorkspaceType(WorkspaceType workspaceType) {
        this.workspaceType = workspaceType;
    }
}

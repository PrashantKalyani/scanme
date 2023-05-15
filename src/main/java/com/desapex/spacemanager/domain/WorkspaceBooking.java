package com.desapex.spacemanager.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Workspace_Booking")
public class WorkspaceBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long id;

    @ManyToOne(targetEntity = Workspace.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "workspace_id", referencedColumnName = "id")
    public Workspace workspace;

    @ManyToOne(targetEntity = Employee.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    public Employee employee;

    @Column(name = "startTime", nullable = false)
    public LocalDateTime startTime;

    @Column(name = "endTime", nullable = false)
    public LocalDateTime endTime;

    @Column(name = "type")
    public String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}

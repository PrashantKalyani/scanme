package com.desapex.spacemanager.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Request")
@Setter
@Getter
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "asset_name", nullable = false)
    public String assetName;

    @Column(name = "sentby", nullable = false)
    private String sentby;

    @Column(name = "receivedby", nullable = false)
    private String receivedby;

    @Column(name = "task_id", nullable = false)
    private Long taskid;

    @Column(name = "Date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "read_or_unread", nullable = false)
    private boolean readorunread;

    @Column(name = "reference_id", nullable = false)
    private Long referenceid;

    @Column(name = "asset_data", nullable = false)
    private Long assetdata;
}

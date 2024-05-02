package com.desapex.spacemanager.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "ups")
@Setter
@Getter
public class Ups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ups_id", nullable = false)
    public Long upsId;

    @Column(name = "tech_name", nullable = false)
    public String techName;

    @Column(name = "time_done")
    private LocalDateTime timeDone;

    @Column(name = "time_eta", nullable = false)
    private LocalDateTime timeEta;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "dept", nullable = false)
    private String dept;

    @Column(name = "i_r_ph", nullable = false)
    private Double redI;

    @Column(name = "i_y_ph", nullable = false)
    private Double yellowI;

    @Column(name = "i_b_ph", nullable = false)
    private Double blueI;

    @Column(name = "o_r_ph", nullable = false)
    private Double redO;

    @Column(name = "o_y_ph", nullable = false)
    private Double yellowO;

    @Column(name = "o_b_ph", nullable = false)
    private Double blueO;

    @Column(name = "battery_v", nullable = false)
    private Double batteryV;

    @Column(name = "loads", nullable = false)
    private Double loads;

    @Column(name = "kva", nullable = false)
    private Double kva;

    @Column(name = "sign", nullable = false)
    private String sign;
}

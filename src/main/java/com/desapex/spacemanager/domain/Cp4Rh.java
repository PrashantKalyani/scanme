package com.desapex.spacemanager.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "cp4_rh")
@Setter
@Getter
public class Cp4Rh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tech_name", nullable = false)
    public String techName;

    @Column(name = "time_done")
    private LocalDateTime timeDone;

    @Column(name = "time_eta", nullable = false)
    private LocalDateTime  timeEta;

    @Column(name = "shift", nullable = false)
    private String shift;

    @Column(name = "temp", nullable = false)
    private Double temp;

    @Column(name = "rh", nullable = false)
    private Double rh;

    @Column(name = "remarks", nullable = false)
    private String remarks;

    @Column(name = "sign", nullable = false)
    private String sign;

}

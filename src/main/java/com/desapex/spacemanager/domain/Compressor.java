package com.desapex.spacemanager.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter

@Table(name = "compressor")
public class Compressor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "equip_name")
    private String equipName;

    @Column(name = "tech_name")
    private String techName;

    @Column(name = "time_done")
    private LocalDateTime timeDone;

    @Column(name = "time_eta")
    private LocalDateTime timeEta;

    @Column(name = "location")
    private String location;

    @Column(name = "item_no")
    private Double itemNo;

    @Column(name = "energy_consumption")
    private Double energyConsumption;

    @Column(name = "speed")
    private Double speed;

    @Column(name = "running_hours")
    private String runningHours;

    @Column(name = "limit_p1_p2")
    private String limitP1P2;

    @Column(name = "c_out_pressure")
    private Double cOutPressure;

    @Column(name = "dp_air_filter")
    private Double dpAirFilter;

    @Column(name = "dp_oil_seperator")
    private Double dpOilSeperator;

    @Column(name = "oil_injection_pressure")
    private Double oilInjectionPressure;

    @Column(name = "c_out_temp")
    private Double cOutTemp;

    @Column(name = "element_out_temp")
    private Double elementOutTemp;

    @Column(name = "cooling_medium")
    private String coolingMedium;

    @Column(name = "oil_seperator")
    private String oilSeperator;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "sign")
    private String sign;
}

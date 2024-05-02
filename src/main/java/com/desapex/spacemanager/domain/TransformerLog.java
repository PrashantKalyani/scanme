package com.desapex.spacemanager.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "transformer_log")
public class TransformerLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "transformer_name", nullable = false)
    public String transformerName;

    @Column(name = "time_done", nullable = false)
    public LocalDateTime timeDone;

    @Column(name = "time_eta", nullable = false)
    public LocalDateTime timeEta;

    @Column(name = "location", nullable = false)
    public String location;

    @Column(name = "dept", nullable = false)
    public String dept;

    @Column(name = "channel_temp", nullable = false)
    public Double channelTemp;

    @Column(name = "voltage", nullable = false)
    public Double voltage;

    @Column(name = "ampere", nullable = false)
    public Double ampere;

    @Column(name = "power_in_kw", nullable = false)
    public Double powerInKw;

    @Column(name = "power_import_in_kw", nullable = false)
    public Double powerImportInKw;

    @Column(name = "power_export_in_kw", nullable = false)
    public Double powerExportInKw;

    @Column(name = "frequency", nullable = false)
    public Double frequency;

    @Column(name = "sign", nullable = false)
    public String sign;
}

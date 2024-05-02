package com.desapex.spacemanager.domain;



import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "checklist")
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long id;

    @Column(name = "maintenance_id")
    public Long maintenanceId;

    @Column(name = "time", nullable = false)
    public LocalDateTime time;

    @Column(name = "comment1")
    public String comment1;

    @Column(name = "status1")
    public String status1;

    @Column(name = "before1")
    public byte[] before1;

    @Column(name = "after1")
    public byte[] after1;

    @Column(name = "comment2")
    public String comment2;

    @Column(name = "status2")
    public String status2;

    @Column(name = "before2")
    public byte[] before2;

    @Column(name = "after2")
    public byte[] after2;

    @Column(name = "comment3")
    public String comment3;

    @Column(name = "status3")
    public String status3;

    @Column(name = "before3")
    public byte[] before3;

    @Column(name = "after3")
    public byte[] after3;

    @Column(name = "comment4")
    public String comment4;

    @Column(name = "status4")
    public String status4;

    @Column(name = "before4")
    public byte[] before4;

    @Column(name = "after4")
    public byte[] after4;

    @Column(name = "comment5")
    public String comment5;

    @Column(name = "status5")
    public String status5;

    @Column(name = "before5")
    public byte[] before5;

    @Column(name = "after5")
    public byte[] after5;

    @Column(name = "comment6")
    public String comment6;

    @Column(name = "status6")
    public String status6;

    @Column(name = "before6")
    public byte[] before6;

    @Column(name = "after6")
    public byte[] after6;

    @Column(name = "comment7")
    public String comment7;

    @Column(name = "status7")
    public String status7;

    @Column(name = "before7")
    public byte[] before7;

    @Column(name = "after7")
    public byte[] after7;

    @Column(name = "comment8")
    public String comment8;

    @Column(name = "status8")
    public String status8;

    @Column(name = "before8")
    public byte[] before8;

    @Column(name = "after8")
    public byte[] after8;

    @Column(name = "comment9")
    public String comment9;

    @Column(name = "status9")
    public String status9;

    @Column(name = "before9")
    public byte[] before9;

    @Column(name = "after9")
    public byte[] after9;

    @Column(name = "comment10")
    public String comment10;

    @Column(name = "status10")
    public String status10;

    @Column(name = "before10")
    public byte[] before10;

    @Column(name = "after10")
    public byte[] after10;

    @Column(name = "comment11")
    public String comment11;

    @Column(name = "status11")
    public String status11;

    @Column(name = "before11")
    public byte[] before11;

    @Column(name = "after11")
    public byte[] after11;

    @Column(name = "comment12")
    public String comment12;

    @Column(name = "status12")
    public String status12;

    @Column(name = "before12")
    public byte[] before12;

    @Column(name = "after12")
    public byte[] after12;

    @Column(name = "comment13")
    public String comment13;

    @Column(name = "status13")
    public String status13;

    @Column(name = "before13")
    public byte[] before13;

    @Column(name = "after13")
    public byte[] after13;

    @Column(name = "comment14")
    public String comment14;

    @Column(name = "status14")
    public String status14;

    @Column(name = "before14")
    public byte[] before14;

    @Column(name = "after14")
    public byte[] after14;

    @Column(name = "comment15")
    public String comment15;

    @Column(name = "status15")
    public String status15;

    @Column(name = "before15")
    public byte[] before15;

    @Column(name = "after15")
    public byte[] after15;

    @Column(name = "tech1")
    public String tech1;

    @Column(name = "tech2")
    public String tech2;

    @Column(name = "tech3")
    public String tech3;

    @Column(name = "sp")
    public byte[] sp;

    @Column(name = "fm")
    public byte[] fm;

    @Column(name = "gm")
    public byte[] gm;
}

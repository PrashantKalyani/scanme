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

    @Column(name = "comment16")
    public String comment16;

    @Column(name = "status16")
    public String status16;

    @Column(name = "before16")
    public byte[] before16;

    @Column(name = "after16")
    public byte[] after16;

    @Column(name = "comment17")
    public String comment17;

    @Column(name = "status17")
    public String status17;

    @Column(name = "before17")
    public byte[] before17;

    @Column(name = "after17")
    public byte[] after17;

    @Column(name = "comment18")
    public String comment18;

    @Column(name = "status18")
    public String status18;

    @Column(name = "before18")
    public byte[] before18;

    @Column(name = "after18")
    public byte[] after18;

    @Column(name = "comment19")
    public String comment19;

    @Column(name = "status19")
    public String status19;

    @Column(name = "before19")
    public byte[] before19;

    @Column(name = "after19")
    public byte[] after19;

    @Column(name = "comment20")
    public String comment20;

    @Column(name = "status20")
    public String status20;

    @Column(name = "before20")
    public byte[] before20;

    @Column(name = "after20")
    public byte[] after20;

    @Column(name = "comment21")
    public String comment21;

    @Column(name = "status21")
    public String status21;

    @Column(name = "before21")
    public byte[] before21;

    @Column(name = "after21")
    public byte[] after21;

    @Column(name = "comment22")
    public String comment22;

    @Column(name = "status22")
    public String status22;

    @Column(name = "before22")
    public byte[] before22;

    @Column(name = "after22")
    public byte[] after22;

    @Column(name = "comment23")
    public String comment23;

    @Column(name = "status23")
    public String status23;

    @Column(name = "before23")
    public byte[] before23;

    @Column(name = "after23")
    public byte[] after23;

    @Column(name = "comment24")
    public String comment24;

    @Column(name = "status24")
    public String status24;

    @Column(name = "before24")
    public byte[] before24;

    @Column(name = "after24")
    public byte[] after24;

    @Column(name = "comment25")
    public String comment25;

    @Column(name = "status25")
    public String status25;

    @Column(name = "before25")
    public byte[] before25;

    @Column(name = "after25")
    public byte[] after25;

    @Column(name = "comment26")
    public String comment26;

    @Column(name = "status26")
    public String status26;

    @Column(name = "before26")
    public byte[] before26;

    @Column(name = "after26")
    public byte[] after26;

    @Column(name = "comment27")
    public String comment27;

    @Column(name = "status27")
    public String status27;

    @Column(name = "before27")
    public byte[] before27;

    @Column(name = "after27")
    public byte[] after27;

    @Column(name = "comment28")
    public String comment28;

    @Column(name = "status28")
    public String status28;

    @Column(name = "before28")
    public byte[] before28;

    @Column(name = "after28")
    public byte[] after28;

    @Column(name = "comment29")
    public String comment29;

    @Column(name = "status29")
    public String status29;

    @Column(name = "before29")
    public byte[] before29;

    @Column(name = "after29")
    public byte[] after29;

    @Column(name = "comment30")
    public String comment30;

    @Column(name = "status30")
    public String status30;

    @Column(name = "before30")
    public byte[] before30;

    @Column(name = "after30")
    public byte[] after30;

    @Column(name = "tech1")
    public String tech1;

    @Column(name = "tech2")
    public String tech2;

    @Column(name = "tech3")
    public String tech3;

    @Column(name = "sp")
    public byte[] sp;

    @Column(name = "sp_name")
    public String namesp;

    @Column(name = "fm")
    public byte[] fm;

    @Column(name = "fm_name")
    public String namefm;

    @Column(name = "gm")
    public byte[] gm;

    @Column(name = "gm_name")
    public String namegm;

    @Column(name = "attached")
    public byte[] attached;
}

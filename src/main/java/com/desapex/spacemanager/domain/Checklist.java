package com.desapex.spacemanager.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

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

    @Column(name = "comment31")
    public String comment31;
    @Column(name = "status31")
    public String status31;
    @Column(name = "before31")
    public byte[] before31;
    @Column(name = "after31")
    public byte[] after31;

    @Column(name = "comment32")
    public String comment32;
    @Column(name = "status32")
    public String status32;
    @Column(name = "before32")
    public byte[] before32;
    @Column(name = "after32")
    public byte[] after32;

    @Column(name = "comment33")
    public String comment33;
    @Column(name = "status33")
    public String status33;
    @Column(name = "before33")
    public byte[] before33;
    @Column(name = "after33")
    public byte[] after33;

    @Column(name = "comment34")
    public String comment34;
    @Column(name = "status34")
    public String status34;
    @Column(name = "before34")
    public byte[] before34;
    @Column(name = "after34")
    public byte[] after34;

    @Column(name = "comment35")
    public String comment35;
    @Column(name = "status35")
    public String status35;
    @Column(name = "before35")
    public byte[] before35;
    @Column(name = "after35")
    public byte[] after35;

    @Column(name = "comment36")
    public String comment36;
    @Column(name = "status36")
    public String status36;
    @Column(name = "before36")
    public byte[] before36;
    @Column(name = "after36")
    public byte[] after36;

    @Column(name = "comment37")
    public String comment37;
    @Column(name = "status37")
    public String status37;
    @Column(name = "before37")
    public byte[] before37;
    @Column(name = "after37")
    public byte[] after37;

    @Column(name = "comment38")
    public String comment38;
    @Column(name = "status38")
    public String status38;
    @Column(name = "before38")
    public byte[] before38;
    @Column(name = "after38")
    public byte[] after38;

    @Column(name = "comment39")
    public String comment39;
    @Column(name = "status39")
    public String status39;
    @Column(name = "before39")
    public byte[] before39;
    @Column(name = "after39")
    public byte[] after39;

    @Column(name = "comment40")
    public String comment40;
    @Column(name = "status40")
    public String status40;
    @Column(name = "before40")
    public byte[] before40;
    @Column(name = "after40")
    public byte[] after40;

    @Column(name = "comment41")
    public String comment41;
    @Column(name = "status41")
    public String status41;
    @Column(name = "before41")
    public byte[] before41;
    @Column(name = "after41")
    public byte[] after41;

    @Column(name = "comment42")
    public String comment42;
    @Column(name = "status42")
    public String status42;
    @Column(name = "before42")
    public byte[] before42;
    @Column(name = "after42")
    public byte[] after42;

    @Column(name = "comment43")
    public String comment43;
    @Column(name = "status43")
    public String status43;
    @Column(name = "before43")
    public byte[] before43;
    @Column(name = "after43")
    public byte[] after43;

    @Column(name = "comment44")
    public String comment44;
    @Column(name = "status44")
    public String status44;
    @Column(name = "before44")
    public byte[] before44;
    @Column(name = "after44")
    public byte[] after44;

    @Column(name = "comment45")
    public String comment45;
    @Column(name = "status45")
    public String status45;
    @Column(name = "before45")
    public byte[] before45;
    @Column(name = "after45")
    public byte[] after45;

    @Column(name = "comment46")
    public String comment46;
    @Column(name = "status46")
    public String status46;
    @Column(name = "before46")
    public byte[] before46;
    @Column(name = "after46")
    public byte[] after46;

    @Column(name = "comment47")
    public String comment47;
    @Column(name = "status47")
    public String status47;
    @Column(name = "before47")
    public byte[] before47;
    @Column(name = "after47")
    public byte[] after47;

    @Column(name = "comment48")
    public String comment48;
    @Column(name = "status48")
    public String status48;
    @Column(name = "before48")
    public byte[] before48;
    @Column(name = "after48")
    public byte[] after48;

    @Column(name = "comment49")
    public String comment49;
    @Column(name = "status49")
    public String status49;
    @Column(name = "before49")
    public byte[] before49;
    @Column(name = "after49")
    public byte[] after49;

    @Column(name = "comment50")
    public String comment50;
    @Column(name = "status50")
    public String status50;
    @Column(name = "before50")
    public byte[] before50;
    @Column(name = "after50")
    public byte[] after50;

    @Column(name = "comment51")
    public String comment51;
    @Column(name = "status51")
    public String status51;
    @Column(name = "before51")
    public byte[] before51;
    @Column(name = "after51")
    public byte[] after51;

    @Column(name = "comment52")
    public String comment52;
    @Column(name = "status52")
    public String status52;
    @Column(name = "before52")
    public byte[] before52;
    @Column(name = "after52")
    public byte[] after52;

    @Column(name = "comment53")
    public String comment53;
    @Column(name = "status53")
    public String status53;
    @Column(name = "before53")
    public byte[] before53;
    @Column(name = "after53")
    public byte[] after53;

    @Column(name = "comment54")
    public String comment54;
    @Column(name = "status54")
    public String status54;
    @Column(name = "before54")
    public byte[] before54;
    @Column(name = "after54")
    public byte[] after54;

    @Column(name = "comment55")
    public String comment55;
    @Column(name = "status55")
    public String status55;
    @Column(name = "before55")
    public byte[] before55;
    @Column(name = "after55")
    public byte[] after55;

    @Column(name = "comment56")
    public String comment56;
    @Column(name = "status56")
    public String status56;
    @Column(name = "before56")
    public byte[] before56;
    @Column(name = "after56")
    public byte[] after56;

    @Column(name = "comment57")
    public String comment57;
    @Column(name = "status57")
    public String status57;
    @Column(name = "before57")
    public byte[] before57;
    @Column(name = "after57")
    public byte[] after57;

    @Column(name = "comment58")
    public String comment58;
    @Column(name = "status58")
    public String status58;
    @Column(name = "before58")
    public byte[] before58;
    @Column(name = "after58")
    public byte[] after58;

    @Column(name = "comment59")
    public String comment59;
    @Column(name = "status59")
    public String status59;
    @Column(name = "before59")
    public byte[] before59;
    @Column(name = "after59")
    public byte[] after59;

    @Column(name = "comment60")
    public String comment60;
    @Column(name = "status60")
    public String status60;
    @Column(name = "before60")
    public byte[] before60;
    @Column(name = "after60")
    public byte[] after60;

    @Column(name = "comment61")
    public String comment61;
    @Column(name = "status61")
    public String status61;
    @Column(name = "before61")
    public byte[] before61;
    @Column(name = "after61")
    public byte[] after61;

    @Column(name = "comment62")
    public String comment62;
    @Column(name = "status62")
    public String status62;
    @Column(name = "before62")
    public byte[] before62;
    @Column(name = "after62")
    public byte[] after62;

    @Column(name = "comment63")
    public String comment63;
    @Column(name = "status63")
    public String status63;
    @Column(name = "before63")
    public byte[] before63;
    @Column(name = "after63")
    public byte[] after63;

    @Column(name = "comment64")
    public String comment64;
    @Column(name = "status64")
    public String status64;
    @Column(name = "before64")
    public byte[] before64;
    @Column(name = "after64")
    public byte[] after64;

    @Column(name = "comment65")
    public String comment65;
    @Column(name = "status65")
    public String status65;
    @Column(name = "before65")
    public byte[] before65;
    @Column(name = "after65")
    public byte[] after65;

    @Column(name = "comment66")
    public String comment66;
    @Column(name = "status66")
    public String status66;
    @Column(name = "before66")
    public byte[] before66;
    @Column(name = "after66")
    public byte[] after66;

    @Column(name = "comment67")
    public String comment67;
    @Column(name = "status67")
    public String status67;
    @Column(name = "before67")
    public byte[] before67;
    @Column(name = "after67")
    public byte[] after67;

    @Column(name = "comment68")
    public String comment68;
    @Column(name = "status68")
    public String status68;
    @Column(name = "before68")
    public byte[] before68;
    @Column(name = "after68")
    public byte[] after68;

    @Column(name = "comment69")
    public String comment69;
    @Column(name = "status69")
    public String status69;
    @Column(name = "before69")
    public byte[] before69;
    @Column(name = "after69")
    public byte[] after69;

    @Column(name = "comment70")
    public String comment70;
    @Column(name = "status70")
    public String status70;
    @Column(name = "before70")
    public byte[] before70;
    @Column(name = "after70")
    public byte[] after70;

    @Column(name = "comment71")
    public String comment71;
    @Column(name = "status71")
    public String status71;
    @Column(name = "before71")
    public byte[] before71;
    @Column(name = "after71")
    public byte[] after71;

    @Column(name = "comment72")
    public String comment72;
    @Column(name = "status72")
    public String status72;
    @Column(name = "before72")
    public byte[] before72;
    @Column(name = "after72")
    public byte[] after72;

    @Column(name = "comment73")
    public String comment73;
    @Column(name = "status73")
    public String status73;
    @Column(name = "before73")
    public byte[] before73;
    @Column(name = "after73")
    public byte[] after73;

    @Column(name = "comment74")
    public String comment74;
    @Column(name = "status74")
    public String status74;
    @Column(name = "before74")
    public byte[] before74;
    @Column(name = "after74")
    public byte[] after74;

    @Column(name = "comment75")
    public String comment75;
    @Column(name = "status75")
    public String status75;
    @Column(name = "before75")
    public byte[] before75;
    @Column(name = "after75")
    public byte[] after75;

    @Column(name = "comment76")
    public String comment76;
    @Column(name = "status76")
    public String status76;
    @Column(name = "before76")
    public byte[] before76;
    @Column(name = "after76")
    public byte[] after76;

    @Column(name = "comment77")
    public String comment77;
    @Column(name = "status77")
    public String status77;
    @Column(name = "before77")
    public byte[] before77;
    @Column(name = "after77")
    public byte[] after77;

    @Column(name = "comment78")
    public String comment78;
    @Column(name = "status78")
    public String status78;
    @Column(name = "before78")
    public byte[] before78;
    @Column(name = "after78")
    public byte[] after78;

    @Column(name = "comment79")
    public String comment79;
    @Column(name = "status79")
    public String status79;
    @Column(name = "before79")
    public byte[] before79;
    @Column(name = "after79")
    public byte[] after79;

    @Column(name = "comment80")
    public String comment80;
    @Column(name = "status80")
    public String status80;
    @Column(name = "before80")
    public byte[] before80;
    @Column(name = "after80")
    public byte[] after80;

    @Column(name = "comment81")
    public String comment81;
    @Column(name = "status81")
    public String status81;
    @Column(name = "before81")
    public byte[] before81;
    @Column(name = "after81")
    public byte[] after81;

    @Column(name = "comment82")
    public String comment82;
    @Column(name = "status82")
    public String status82;
    @Column(name = "before82")
    public byte[] before82;
    @Column(name = "after82")
    public byte[] after82;

    @Column(name = "comment83")
    public String comment83;
    @Column(name = "status83")
    public String status83;
    @Column(name = "before83")
    public byte[] before83;
    @Column(name = "after83")
    public byte[] after83;

    @Column(name = "comment84")
    public String comment84;
    @Column(name = "status84")
    public String status84;
    @Column(name = "before84")
    public byte[] before84;
    @Column(name = "after84")
    public byte[] after84;

    @Column(name = "comment85")
    public String comment85;
    @Column(name = "status85")
    public String status85;
    @Column(name = "before85")
    public byte[] before85;
    @Column(name = "after85")
    public byte[] after85;

    @Column(name = "comment86")
    public String comment86;
    @Column(name = "status86")
    public String status86;
    @Column(name = "before86")
    public byte[] before86;
    @Column(name = "after86")
    public byte[] after86;

    @Column(name = "comment87")
    public String comment87;
    @Column(name = "status87")
    public String status87;
    @Column(name = "before87")
    public byte[] before87;
    @Column(name = "after87")
    public byte[] after87;

    @Column(name = "comment88")
    public String comment88;
    @Column(name = "status88")
    public String status88;
    @Column(name = "before88")
    public byte[] before88;
    @Column(name = "after88")
    public byte[] after88;

    @Column(name = "comment89")
    public String comment89;
    @Column(name = "status89")
    public String status89;
    @Column(name = "before89")
    public byte[] before89;
    @Column(name = "after89")
    public byte[] after89;

    @Column(name = "comment90")
    public String comment90;
    @Column(name = "status90")
    public String status90;
    @Column(name = "before90")
    public byte[] before90;
    @Column(name = "after90")
    public byte[] after90;

    @Column(name = "comment91")
    public String comment91;
    @Column(name = "status91")
    public String status91;
    @Column(name = "before91")
    public byte[] before91;
    @Column(name = "after91")
    public byte[] after91;

    @Column(name = "comment92")
    public String comment92;
    @Column(name = "status92")
    public String status92;
    @Column(name = "before92")
    public byte[] before92;
    @Column(name = "after92")
    public byte[] after92;

    @Column(name = "comment93")
    public String comment93;
    @Column(name = "status93")
    public String status93;
    @Column(name = "before93")
    public byte[] before93;
    @Column(name = "after93")
    public byte[] after93;

    @Column(name = "comment94")
    public String comment94;
    @Column(name = "status94")
    public String status94;
    @Column(name = "before94")
    public byte[] before94;
    @Column(name = "after94")
    public byte[] after94;

    @Column(name = "comment95")
    public String comment95;
    @Column(name = "status95")
    public String status95;
    @Column(name = "before95")
    public byte[] before95;
    @Column(name = "after95")
    public byte[] after95;

    @Column(name = "comment96")
    public String comment96;
    @Column(name = "status96")
    public String status96;
    @Column(name = "before96")
    public byte[] before96;
    @Column(name = "after96")
    public byte[] after96;

    @Column(name = "comment97")
    public String comment97;
    @Column(name = "status97")
    public String status97;
    @Column(name = "before97")
    public byte[] before97;
    @Column(name = "after97")
    public byte[] after97;

    @Column(name = "comment98")
    public String comment98;
    @Column(name = "status98")
    public String status98;
    @Column(name = "before98")
    public byte[] before98;
    @Column(name = "after98")
    public byte[] after98;

    @Column(name = "comment99")
    public String comment99;
    @Column(name = "status99")
    public String status99;
    @Column(name = "before99")
    public byte[] before99;
    @Column(name = "after99")
    public byte[] after99;

    @Column(name = "comment100")
    public String comment100;
    @Column(name = "status100")
    public String status100;
    @Column(name = "before100")
    public byte[] before100;
    @Column(name = "after100")
    public byte[] after100;

    @Column(name = "comment101")
    public String comment101;
    @Column(name = "status101")
    public String status101;
    @Column(name = "before101")
    public byte[] before101;
    @Column(name = "after101")
    public byte[] after101;

    @Column(name = "comment102")
    public String comment102;
    @Column(name = "status102")
    public String status102;
    @Column(name = "before102")
    public byte[] before102;
    @Column(name = "after102")
    public byte[] after102;

    @Column(name = "comment103")
    public String comment103;
    @Column(name = "status103")
    public String status103;
    @Column(name = "before103")
    public byte[] before103;
    @Column(name = "after103")
    public byte[] after103;

    @Column(name = "comment104")
    public String comment104;
    @Column(name = "status104")
    public String status104;
    @Column(name = "before104")
    public byte[] before104;
    @Column(name = "after104")
    public byte[] after104;

    @Column(name = "comment105")
    public String comment105;
    @Column(name = "status105")
    public String status105;
    @Column(name = "before105")
    public byte[] before105;
    @Column(name = "after105")
    public byte[] after105;

    @Column(name = "comment106")
    public String comment106;
    @Column(name = "status106")
    public String status106;
    @Column(name = "before106")
    public byte[] before106;
    @Column(name = "after106")
    public byte[] after106;

    @Column(name = "comment107")
    public String comment107;
    @Column(name = "status107")
    public String status107;
    @Column(name = "before107")
    public byte[] before107;
    @Column(name = "after107")
    public byte[] after107;

    @Column(name = "comment108")
    public String comment108;
    @Column(name = "status108")
    public String status108;
    @Column(name = "before108")
    public byte[] before108;
    @Column(name = "after108")
    public byte[] after108;

    @Column(name = "comment109")
    public String comment109;
    @Column(name = "status109")
    public String status109;
    @Column(name = "before109")
    public byte[] before109;
    @Column(name = "after109")
    public byte[] after109;

    @Column(name = "comment110")
    public String comment110;
    @Column(name = "status110")
    public String status110;
    @Column(name = "before110")
    public byte[] before110;
    @Column(name = "after110")
    public byte[] after110;

    @Column(name = "comment111")
    public String comment111;
    @Column(name = "status111")
    public String status111;
    @Column(name = "before111")
    public byte[] before111;
    @Column(name = "after111")
    public byte[] after111;

    @Column(name = "comment112")
    public String comment112;
    @Column(name = "status112")
    public String status112;
    @Column(name = "before112")
    public byte[] before112;
    @Column(name = "after112")
    public byte[] after112;

    @Column(name = "comment113")
    public String comment113;
    @Column(name = "status113")
    public String status113;
    @Column(name = "before113")
    public byte[] before113;
    @Column(name = "after113")
    public byte[] after113;

    @Column(name = "comment114")
    public String comment114;
    @Column(name = "status114")
    public String status114;
    @Column(name = "before114")
    public byte[] before114;
    @Column(name = "after114")
    public byte[] after114;

    @Column(name = "comment115")
    public String comment115;
    @Column(name = "status115")
    public String status115;
    @Column(name = "before115")
    public byte[] before115;
    @Column(name = "after115")
    public byte[] after115;

    @Column(name = "comment116")
    public String comment116;
    @Column(name = "status116")
    public String status116;
    @Column(name = "before116")
    public byte[] before116;
    @Column(name = "after116")
    public byte[] after116;

    @Column(name = "comment117")
    public String comment117;
    @Column(name = "status117")
    public String status117;
    @Column(name = "before117")
    public byte[] before117;
    @Column(name = "after117")
    public byte[] after117;

    @Column(name = "comment118")
    public String comment118;
    @Column(name = "status118")
    public String status118;
    @Column(name = "before118")
    public byte[] before118;
    @Column(name = "after118")
    public byte[] after118;

    @Column(name = "comment119")
    public String comment119;
    @Column(name = "status119")
    public String status119;
    @Column(name = "before119")
    public byte[] before119;
    @Column(name = "after119")
    public byte[] after119;

    @Column(name = "comment120")
    public String comment120;
    @Column(name = "status120")
    public String status120;
    @Column(name = "before120")
    public byte[] before120;
    @Column(name = "after120")
    public byte[] after120;

    @Column(name = "comment121")
    public String comment121;
    @Column(name = "status121")
    public String status121;
    @Column(name = "before121")
    public byte[] before121;
    @Column(name = "after121")
    public byte[] after121;

    @Column(name = "comment122")
    public String comment122;
    @Column(name = "status122")
    public String status122;
    @Column(name = "before122")
    public byte[] before122;
    @Column(name = "after122")
    public byte[] after122;

    @Column(name = "comment123")
    public String comment123;
    @Column(name = "status123")
    public String status123;
    @Column(name = "before123")
    public byte[] before123;
    @Column(name = "after123")
    public byte[] after123;

    @Column(name = "comment124")
    public String comment124;
    @Column(name = "status124")
    public String status124;
    @Column(name = "before124")
    public byte[] before124;
    @Column(name = "after124")
    public byte[] after124;

    @Column(name = "comment125")
    public String comment125;
    @Column(name = "status125")
    public String status125;
    @Column(name = "before125")
    public byte[] before125;
    @Column(name = "after125")
    public byte[] after125;

    @Column(name = "comment126")
    public String comment126;
    @Column(name = "status126")
    public String status126;
    @Column(name = "before126")
    public byte[] before126;
    @Column(name = "after126")
    public byte[] after126;

    @Column(name = "comment127")
    public String comment127;
    @Column(name = "status127")
    public String status127;
    @Column(name = "before127")
    public byte[] before127;
    @Column(name = "after127")
    public byte[] after127;

    @Column(name = "comment128")
    public String comment128;
    @Column(name = "status128")
    public String status128;
    @Column(name = "before128")
    public byte[] before128;
    @Column(name = "after128")
    public byte[] after128;

    @Column(name = "comment129")
    public String comment129;
    @Column(name = "status129")
    public String status129;
    @Column(name = "before129")
    public byte[] before129;
    @Column(name = "after129")
    public byte[] after129;

    @Column(name = "comment130")
    public String comment130;
    @Column(name = "status130")
    public String status130;
    @Column(name = "before130")
    public byte[] before130;
    @Column(name = "after130")
    public byte[] after130;

    @Column(name = "comment131")
    public String comment131;
    @Column(name = "status131")
    public String status131;
    @Column(name = "before131")
    public byte[] before131;
    @Column(name = "after131")
    public byte[] after131;

    @Column(name = "comment132")
    public String comment132;
    @Column(name = "status132")
    public String status132;
    @Column(name = "before132")
    public byte[] before132;
    @Column(name = "after132")
    public byte[] after132;

    @Column(name = "comment133")
    public String comment133;
    @Column(name = "status133")
    public String status133;
    @Column(name = "before133")
    public byte[] before133;
    @Column(name = "after133")
    public byte[] after133;

    @Column(name = "comment134")
    public String comment134;
    @Column(name = "status134")
    public String status134;
    @Column(name = "before134")
    public byte[] before134;
    @Column(name = "after134")
    public byte[] after134;

    @Column(name = "comment135")
    public String comment135;
    @Column(name = "status135")
    public String status135;
    @Column(name = "before135")
    public byte[] before135;
    @Column(name = "after135")
    public byte[] after135;

    @Column(name = "comment136")
    public String comment136;
    @Column(name = "status136")
    public String status136;
    @Column(name = "before136")
    public byte[] before136;
    @Column(name = "after136")
    public byte[] after136;

    @Column(name = "comment137")
    public String comment137;
    @Column(name = "status137")
    public String status137;
    @Column(name = "before137")
    public byte[] before137;
    @Column(name = "after137")
    public byte[] after137;

    @Column(name = "comment138")
    public String comment138;
    @Column(name = "status138")
    public String status138;
    @Column(name = "before138")
    public byte[] before138;
    @Column(name = "after138")
    public byte[] after138;

    @Column(name = "comment139")
    public String comment139;
    @Column(name = "status139")
    public String status139;
    @Column(name = "before139")
    public byte[] before139;
    @Column(name = "after139")
    public byte[] after139;

    @Column(name = "comment140")
    public String comment140;
    @Column(name = "status140")
    public String status140;
    @Column(name = "before140")
    public byte[] before140;
    @Column(name = "after140")
    public byte[] after140;

    @Column(name = "comment141")
    public String comment141;
    @Column(name = "status141")
    public String status141;
    @Column(name = "before141")
    public byte[] before141;
    @Column(name = "after141")
    public byte[] after141;

    @Column(name = "comment142")
    public String comment142;
    @Column(name = "status142")
    public String status142;
    @Column(name = "before142")
    public byte[] before142;
    @Column(name = "after142")
    public byte[] after142;

    @Column(name = "comment143")
    public String comment143;
    @Column(name = "status143")
    public String status143;
    @Column(name = "before143")
    public byte[] before143;
    @Column(name = "after143")
    public byte[] after143;

    @Column(name = "comment144")
    public String comment144;
    @Column(name = "status144")
    public String status144;
    @Column(name = "before144")
    public byte[] before144;
    @Column(name = "after144")
    public byte[] after144;

    @Column(name = "comment145")
    public String comment145;
    @Column(name = "status145")
    public String status145;
    @Column(name = "before145")
    public byte[] before145;
    @Column(name = "after145")
    public byte[] after145;

    @Column(name = "comment146")
    public String comment146;
    @Column(name = "status146")
    public String status146;
    @Column(name = "before146")
    public byte[] before146;
    @Column(name = "after146")
    public byte[] after146;

    @Column(name = "comment147")
    public String comment147;
    @Column(name = "status147")
    public String status147;
    @Column(name = "before147")
    public byte[] before147;
    @Column(name = "after147")
    public byte[] after147;

    @Column(name = "comment148")
    public String comment148;
    @Column(name = "status148")
    public String status148;
    @Column(name = "before148")
    public byte[] before148;
    @Column(name = "after148")
    public byte[] after148;

    @Column(name = "comment149")
    public String comment149;
    @Column(name = "status149")
    public String status149;
    @Column(name = "before149")
    public byte[] before149;
    @Column(name = "after149")
    public byte[] after149;

    @Column(name = "comment150")
    public String comment150;
    @Column(name = "status150")
    public String status150;
    @Column(name = "before150")
    public byte[] before150;
    @Column(name = "after150")
    public byte[] after150;


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

package com.desapex.spacemanager.domain;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "Parkingspace")
public class Parkingspace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public Long id;

    @ManyToOne(targetEntity = ParkingspaceFloor.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "parkingspace_floor_id", referencedColumnName = "id")
    public ParkingspaceFloor floor;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    public ParkingspaceType parkingspaceType;



    @OneToMany(targetEntity = ParkingspaceBooking.class, mappedBy = "parkingspace", fetch = FetchType.EAGER)
    public List<ParkingspaceBooking> bookings;


}

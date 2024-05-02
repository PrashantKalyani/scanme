package com.desapex.spacemanager.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reference_number")
public class ReferenceNumber {
    @Id
    @Column(name = "Reference", nullable = false)
    public Long reference;

    @Column(name = "Equipment", nullable = false)
    public String equipment;
}

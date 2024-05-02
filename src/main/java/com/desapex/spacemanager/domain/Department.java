package com.desapex.spacemanager.domain;

import jakarta.persistence.*;
import lombok.*;

@Data

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long id;

    @ManyToOne(targetEntity = Office.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "office_id", referencedColumnName = "id")
    public Office office;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "credit", nullable = false)
    public Long credit;


    public Long getCreditValue() {

        return credit;
    }

    public void setCreditValue(Long creditValue) {

        this.credit = creditValue;
    }


    public Department() {

    }

    public Department(int id) {
        this.id = (long) id;
    }

}

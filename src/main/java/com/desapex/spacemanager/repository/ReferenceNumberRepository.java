package com.desapex.spacemanager.repository;

import com.desapex.spacemanager.domain.ReferenceNumber;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository // Add Repository annotation
@Transactional // Add Transactional annotation if you need transaction management
public class ReferenceNumberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<ReferenceNumber> findByEquipment(String equipmentName) {
        try {
            ReferenceNumber referenceNumber = entityManager.createQuery(
                            "SELECT rn FROM ReferenceNumber rn WHERE rn.equipment = :equipmentName", ReferenceNumber.class)
                    .setParameter("equipmentName", equipmentName)
                    .getSingleResult();
            return Optional.ofNullable(referenceNumber);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}


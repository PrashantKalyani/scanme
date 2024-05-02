package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.ReferenceNumber;
import com.desapex.spacemanager.repository.ReferenceNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReferenceNumberService {

    private final ReferenceNumberRepository referenceNumberRepository;

    @Autowired
    public ReferenceNumberService(ReferenceNumberRepository referenceNumberRepository) {
        this.referenceNumberRepository = referenceNumberRepository;
    }

    public Long findReferenceNumberByEquipmentName(String equipmentName) {
        Optional<ReferenceNumber> optionalReferenceNumber = referenceNumberRepository.findByEquipment(equipmentName);
        return optionalReferenceNumber.map(ReferenceNumber::getReference).orElse(null);
    }
}

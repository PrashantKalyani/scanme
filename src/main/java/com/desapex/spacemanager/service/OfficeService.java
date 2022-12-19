package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Office;
import com.desapex.spacemanager.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OfficeService implements IOfficeService {

    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public List<Office> getOffices(Long organisationId) {
        return officeRepository.findAll()
                .stream()
                .filter(office -> Objects.equals(office.organisation.id, organisationId))
                .collect(Collectors.toList());
    }

}

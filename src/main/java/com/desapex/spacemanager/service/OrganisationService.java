package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Organisation;
import com.desapex.spacemanager.repository.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationService implements IOrganisationService {

    @Autowired
    private OrganisationRepository organisationRepository;

    @Override
    public List<Organisation> getOrganisations() {
        return organisationRepository.findAll();
    }

}

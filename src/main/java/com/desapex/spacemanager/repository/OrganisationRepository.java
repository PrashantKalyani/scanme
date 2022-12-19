package com.desapex.spacemanager.repository;

import com.desapex.spacemanager.domain.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
}

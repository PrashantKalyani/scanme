package com.desapex.spacemanager.repository;

import com.desapex.spacemanager.domain.Ups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpsRepository extends JpaRepository<Ups, Long> {
}

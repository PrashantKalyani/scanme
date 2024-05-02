package com.desapex.spacemanager.repository;
import com.desapex.spacemanager.domain.Cp4Rh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cp4RhRepository extends JpaRepository<Cp4Rh, Long> {
}

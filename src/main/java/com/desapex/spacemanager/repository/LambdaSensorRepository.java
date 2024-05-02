package com.desapex.spacemanager.repository;

import com.desapex.spacemanager.domain.LambdaSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LambdaSensorRepository extends JpaRepository<LambdaSensor, Long> {
}

package com.desapex.spacemanager.repository;

import com.desapex.spacemanager.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@EnableJpaRepositories
@Repository

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByName(String name);
}

package com.desapex.spacemanager.repository;

import com.desapex.spacemanager.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);

    @Modifying
    @Query("UPDATE Employee e SET e.status = :status WHERE e.id = :id")
    void updateStatusById(@Param("id") Long id, @Param("status") boolean status);
}

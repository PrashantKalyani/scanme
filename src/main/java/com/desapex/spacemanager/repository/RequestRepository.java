package com.desapex.spacemanager.repository;

import com.desapex.spacemanager.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findByReceivedby(String receivedBy);

}

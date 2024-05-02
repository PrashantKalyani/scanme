package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Cp4Rh;

import com.desapex.spacemanager.repository.Cp4RhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class Cp4RhService {

    @Autowired
    private Cp4RhRepository repository;

    public Cp4Rh saveCp4Rh(Cp4Rh cp4Rh) {
        cp4Rh.setTimeDone(Timestamp.from(Instant.now()).toLocalDateTime());
        return repository.save(cp4Rh);
    }

    public List<Cp4Rh> getAllCp4Rh() {

        return repository.findAll();
    }

}

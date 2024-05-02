package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Pf51;
import com.desapex.spacemanager.repository.Pf51Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class Pf51Service {
    private final Pf51Repository pf51Repository;

    @Autowired
    public Pf51Service(Pf51Repository pf51Repository) {
        this.pf51Repository = pf51Repository;
    }

    public Pf51 save(Pf51 pf51) {
        pf51.setTimeDone(Timestamp.from(Instant.now()).toLocalDateTime());
        return pf51Repository.save(pf51);
    }

    public List<Pf51> getAll() {
        return pf51Repository.findAll();
    }

    // You can add more methods for specific operations if needed
}

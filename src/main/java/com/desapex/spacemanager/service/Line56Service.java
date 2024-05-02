package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Line56;
import com.desapex.spacemanager.repository.Line56Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class Line56Service {
    private final Line56Repository line56Repository;

    @Autowired
    public Line56Service(Line56Repository line56Repository) {
        this.line56Repository = line56Repository;
    }

    public Line56 saveLine56(Line56 line56) {
        line56.setTimeDone(Timestamp.from(Instant.now()).toLocalDateTime());
        return line56Repository.save(line56);
    }

    public List<Line56> getAllLine56() {
        return line56Repository.findAll();
    }
}

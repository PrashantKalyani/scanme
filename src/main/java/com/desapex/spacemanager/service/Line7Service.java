package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Line7;
import com.desapex.spacemanager.repository.Line7Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class Line7Service {

    @Autowired
    private Line7Repository line7Repository;

    public Line7 saveLine7(Line7 line7) {
        line7.setTimeDone(Timestamp.from(Instant.now()).toLocalDateTime());
        return line7Repository.save(line7);
    }

    public List<Line7> getAllLine7() {
        return line7Repository.findAll();
    }

}

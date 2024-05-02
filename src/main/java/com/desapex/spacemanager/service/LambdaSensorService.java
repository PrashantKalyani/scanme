package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.LambdaSensor;
import com.desapex.spacemanager.repository.LambdaSensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class LambdaSensorService {

    private final LambdaSensorRepository lambdaSensorRepository;

    @Autowired
    public LambdaSensorService(LambdaSensorRepository lambdaSensorRepository) {
        this.lambdaSensorRepository = lambdaSensorRepository;
    }

    public LambdaSensor saveLambdaSensor(LambdaSensor lambdaSensor) {
        lambdaSensor.setTimeDone(Timestamp.from(Instant.now()).toLocalDateTime());
        return lambdaSensorRepository.save(lambdaSensor);
    }

    public List<LambdaSensor> getAllLambdaSensors() {
        return lambdaSensorRepository.findAll();
    }
}

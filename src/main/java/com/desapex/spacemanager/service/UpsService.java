package com.desapex.spacemanager.service;

// UpsService.java
import com.desapex.spacemanager.domain.Ups;
import com.desapex.spacemanager.repository.UpsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UpsService {
    @Autowired
    private UpsRepository upsRepository;

    public List<Ups> getAllUps() {
        return upsRepository.findAll();
    }

    public Ups createUps(Ups ups) {
        return upsRepository.save(ups);
    }
}

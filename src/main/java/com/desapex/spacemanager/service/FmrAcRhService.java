package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.FmrAcRh;
import com.desapex.spacemanager.repository.FmrAcRhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class FmrAcRhService {

    @Autowired
    private FmrAcRhRepository fmrAcRhRepository;

    public FmrAcRh saveFmrAcRh(FmrAcRh fmrAcRh) {
        fmrAcRh.setTimeDone(Timestamp.from(Instant.now()).toLocalDateTime());
        return fmrAcRhRepository.save(fmrAcRh);
    }

    public List<FmrAcRh> getAllFmrAcRh() {
        return fmrAcRhRepository.findAll();
    }

}

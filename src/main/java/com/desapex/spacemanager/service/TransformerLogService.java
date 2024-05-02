package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Cp4Rh;
import com.desapex.spacemanager.domain.TransformerLog;
import com.desapex.spacemanager.repository.Cp4RhRepository;
import com.desapex.spacemanager.repository.TransformerLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class TransformerLogService {

    @Autowired
    private TransformerLogRepository repository;
//    @Autowired
//    public TransformerLogService(TransformerLogRepository transformerLogRepository) {
//        this.transformerLogRepository = transformerLogRepository;
//    }

//    public void saveTransformerLog(TransformerLog transformerLog) {
//        transformerLog.setTimeDone(Timestamp.from(Instant.now()).toLocalDateTime());
//        transformerLogRepository.save(transformerLog);
//    }

    public TransformerLog saveTransformerLog(TransformerLog transformerLog) {
        transformerLog.setTimeDone(Timestamp.from(Instant.now()).toLocalDateTime());
        return repository.save(transformerLog);
    }

    public List<TransformerLog> getAllTransformerLog() {

        return repository.findAll();
    }
}

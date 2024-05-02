package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.TransformerLog;
import com.desapex.spacemanager.repository.TransformerLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransformerLogService {

    private final TransformerLogRepository transformerLogRepository;

    @Autowired
    public TransformerLogService(TransformerLogRepository transformerLogRepository) {
        this.transformerLogRepository = transformerLogRepository;
    }

    public void saveTransformerLog(TransformerLog transformerLog) {
        transformerLogRepository.save(transformerLog);
    }
}

package com.desapex.spacemanager.service;

import com.desapex.spacemanager.domain.Compressor;
import com.desapex.spacemanager.repository.CompressorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class CompressorService {

    @Autowired
    private CompressorRepository compressorRepository;

    public List<Compressor> getAllCompressors() {
        return compressorRepository.findAll();
    }

    public Compressor saveCompressor(Compressor compressor) {
        compressor.setTimeDone(Timestamp.from(Instant.now()).toLocalDateTime());
        return compressorRepository.save(compressor);
    }

}

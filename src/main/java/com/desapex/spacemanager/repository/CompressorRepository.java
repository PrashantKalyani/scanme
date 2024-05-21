package com.desapex.spacemanager.repository;


import com.desapex.spacemanager.domain.Compressor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompressorRepository extends JpaRepository<Compressor, Long> {
}
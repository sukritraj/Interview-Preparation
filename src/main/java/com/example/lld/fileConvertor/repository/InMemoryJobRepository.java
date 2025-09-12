package com.example.lld.fileConvertor.repository;

import com.example.lld.fileConvertor.model.ConversionJob;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryJobRepository {
    private final Map<UUID, ConversionJob> jobs = new ConcurrentHashMap<>();


    public ConversionJob save(ConversionJob job) {
        jobs.put(job.getId(), job);
        return job;
    }


    public Optional<ConversionJob> findById(UUID id) {
        return Optional.ofNullable(jobs.get(id));
    }


    public void update(ConversionJob job) {
        jobs.put(job.getId(), job);
    }
}

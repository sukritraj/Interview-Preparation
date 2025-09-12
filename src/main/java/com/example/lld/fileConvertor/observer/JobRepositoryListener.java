package com.example.lld.fileConvertor.observer;

import com.example.lld.fileConvertor.model.ConversionJob;
import com.example.lld.fileConvertor.repository.InMemoryJobRepository;

public class JobRepositoryListener implements JobListener {
    private final InMemoryJobRepository repo;


    public JobRepositoryListener(InMemoryJobRepository repo) {
        this.repo = repo;
    }


    @Override
    public void onCompleted(ConversionJob job) {
        repo.update(job);
    }
}

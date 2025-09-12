package com.example.lld.fileConvertor.service;

import com.example.lld.fileConvertor.converter.Converter;
import com.example.lld.fileConvertor.converter.ConverterRegistry;
import com.example.lld.fileConvertor.converter.PdfToTextConverter;
import com.example.lld.fileConvertor.model.ConversionJob;
import com.example.lld.fileConvertor.observer.JobListener;
import com.example.lld.fileConvertor.repository.InMemoryJobRepository;
import com.example.lld.fileConvertor.worker.ConversionTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConversionService {
    private final InMemoryJobRepository repo;
    private final ConverterRegistry registry;
    private final ExecutorService executor;
    private final List<JobListener> listeners = new ArrayList<>();


    public ConversionService(InMemoryJobRepository repo) {
        this.repo = repo;
        this.registry = new ConverterRegistry();
        this.registry.register(new PdfToTextConverter());
        this.executor = Executors.newFixedThreadPool(4);
    }


    public void addListener(JobListener l) { listeners.add(l); }


    public ConversionJob submit(String sourceFormat, String targetFormat, String inputPath) {
        Optional<Converter> conv = registry.get(sourceFormat, targetFormat);
        if (conv.isEmpty()) {
            throw new IllegalArgumentException("Unsupported conversion: " + sourceFormat + " -> " + targetFormat);
        }


        ConversionJob job = new ConversionJob(sourceFormat, targetFormat, inputPath);
        repo.save(job);


        ConversionTask task = new ConversionTask(job, conv.get(), List.copyOf(listeners), repo);
        executor.submit(task);


        return job;
    }


    public ConversionJob getJob(UUID id) {
        return repo.findById(id).orElse(null);
    }


    public void shutdown() {
        executor.shutdown();
    }
}

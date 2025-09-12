package com.example.lld.fileConvertor.worker;

import com.example.lld.fileConvertor.converter.Converter;
import com.example.lld.fileConvertor.model.ConversionJob;
import com.example.lld.fileConvertor.observer.JobListener;
import com.example.lld.fileConvertor.repository.InMemoryJobRepository;

import java.io.*;
import java.util.List;

public class ConversionTask implements Runnable {
    private final ConversionJob job;
    private final Converter converter;
    private final List<JobListener> listeners;
    private final InMemoryJobRepository repo;


    public ConversionTask(ConversionJob job, Converter converter, List<JobListener> listeners, InMemoryJobRepository repo) {
        this.job = job;
        this.converter = converter;
        this.listeners = listeners;
        this.repo = repo;
    }


    @Override
    public void run() {
        job.markRunning();
        repo.update(job);


        File inputFile = new File(job.getInputPath());
        String outFileName = System.getProperty("java.io.tmpdir") + File.separator + "converted-" + job.getId() + "." + job.getTargetFormat();
        File outFile = new File(outFileName);


        try (InputStream in = new BufferedInputStream(new FileInputStream(inputFile));
             OutputStream out = new BufferedOutputStream(new FileOutputStream(outFile))) {


            converter.convert(in, out);


            job.markSuccess(outFile.getAbsolutePath());
            repo.update(job);
            notifyListeners();
        } catch (Exception e) {
            job.markFailed(e.getMessage());
            repo.update(job);
            notifyListeners();
        }
    }


    private void notifyListeners() {
        for (JobListener l : listeners) {
            try { l.onCompleted(job); } catch (Exception ignore) { }
        }
    }
}

package com.example.lld.fileConvertor;

import com.example.lld.fileConvertor.model.ConversionJob;
import com.example.lld.fileConvertor.model.Status;
import com.example.lld.fileConvertor.observer.JobRepositoryListener;
import com.example.lld.fileConvertor.repository.InMemoryJobRepository;
import com.example.lld.fileConvertor.service.ConversionService;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.UUID;

public class FileConvertorApp {
    public static void main(String[] args) throws Exception {
        InMemoryJobRepository repo = new InMemoryJobRepository();
        ConversionService conversionService = new ConversionService(repo);
        conversionService.addListener(new JobRepositoryListener(repo));


        String samplePdfPath;
        if (args.length > 0) {
            samplePdfPath = args[0];
        } else {
            File f = new File("sample.pdf");
            if (!f.exists()) {
                System.err.println("Please put a sample.pdf into the project root or pass a path as the first arg.");
                return;
            }
            samplePdfPath = f.getAbsolutePath();
        }


        String sourceFormat = "pdf";
        String targetFormat = "txt";


        ConversionJob job = conversionService.submit(sourceFormat, targetFormat, samplePdfPath);
        UUID jobId = job.getId();
        System.out.println("Submitted jobId=" + jobId + " (immediate response). Job status: " + job.getStatus());


        Instant start = Instant.now();
        while (true) {
            ConversionJob current = conversionService.getJob(jobId);
            System.out.println("[" + Duration.between(start, Instant.now()).toSeconds() + "s] status=" + current.getStatus());


            if (current.getStatus() == Status.SUCCESS) {
                System.out.println("Conversion finished! Output at: " + current.getOutputPath());
                break;
            } else if (current.getStatus() == Status.FAILED) {
                System.out.println("Conversion failed: " + current.getErrorMessage());
                break;
            }


            Thread.sleep(1000);
        }


        conversionService.shutdown();
        System.out.println("Driver finished.");
    }
}

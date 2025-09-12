package com.example.lld.fileConvertor.observer;

import com.example.lld.fileConvertor.model.ConversionJob;

public interface JobListener {
    void onCompleted(ConversionJob job);
}

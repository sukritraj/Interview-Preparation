package com.example.lld.fileConvertor.converter;

import java.io.InputStream;
import java.io.OutputStream;

public interface Converter {
    boolean canHandle(String sourceFormat, String targetFormat);
    void convert(InputStream in, OutputStream out) throws Exception;
}

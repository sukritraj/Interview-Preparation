package com.example.lld.fileConvertor.converter;

import java.io.InputStream;
import java.io.OutputStream;

public class PdfToTextConverter implements Converter {
    @Override
    public boolean canHandle(String sourceFormat, String targetFormat) {
        return "pdf".equalsIgnoreCase(sourceFormat) && "txt".equalsIgnoreCase(targetFormat);
    }


    @Override
    public void convert(InputStream in, OutputStream out) throws Exception {
        /**
         * logic of conversion
         */
        System.out.println("Successfully Converted");
    }
}

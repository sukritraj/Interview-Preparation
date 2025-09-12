package com.example.lld.fileConvertor.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConverterRegistry {
    private final List<Converter> converters = new ArrayList<>();


    public void register(Converter c) {
        converters.add(c);
    }


    public Optional<Converter> get(String src, String tgt) {
        return converters.stream().filter(c -> c.canHandle(src, tgt)).findFirst();
    }
}

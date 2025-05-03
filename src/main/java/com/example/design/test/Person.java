package com.example.design.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    int id;
    String name;

    public void setName(String name) {
        this.name = name.toUpperCase();
    }
}

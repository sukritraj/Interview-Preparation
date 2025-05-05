package com.example.lld.hospitalManagement.strategy;

import com.example.lld.hospitalManagement.models.Doctor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RatingBasedStrategy implements DoctorSelectionStrategy{
    @Override
    public List<Doctor> select(List<Doctor> doctors) {
        return doctors.stream()
                .sorted(Comparator.comparingDouble(Doctor::getRating).reversed())
                .collect(Collectors.toList());
    }
}

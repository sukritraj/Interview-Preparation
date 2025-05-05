package com.example.lld.hospitalManagement.strategy;

import com.example.lld.hospitalManagement.models.Doctor;
import com.example.lld.hospitalManagement.models.Slot;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SlotStartTimeStrategy implements DoctorSelectionStrategy{
    @Override
    public List<Doctor> select(List<Doctor> doctors) {
        return doctors.stream()
                .sorted(Comparator.comparing(d -> d.getAvailableSlots().stream()
                        .map(Slot::getStartTime)
                        .min(Comparator.naturalOrder()).orElse(null)))
                .collect(Collectors.toList());
    }
}

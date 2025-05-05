package com.example.lld.hospitalManagement.strategy;

import com.example.lld.hospitalManagement.models.Doctor;

import java.util.List;

public interface DoctorSelectionStrategy {
    List<Doctor> select(List<Doctor> doctors);
}

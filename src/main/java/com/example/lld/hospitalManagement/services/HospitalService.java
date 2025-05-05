package com.example.lld.hospitalManagement.services;

import com.example.lld.hospitalManagement.models.*;
import com.example.lld.hospitalManagement.strategy.DoctorSelectionStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HospitalService {
    private final Map<String, Doctor> doctors = new HashMap<>();
    private final Map<String, Patient> patients = new HashMap<>();

    public void registerDoctor(String id, String name, String specialty) {
        doctors.put(id, new Doctor(id, name, specialty));
    }

    public void addDoctorSlot(String doctorId, Slot slot) {
        Doctor doctor = doctors.get(doctorId);
        if (doctor != null) doctor.addAvailableSlot(slot);
    }

    public void registerPatient(String id, String name) {
        patients.put(id, new Patient(id, name));
    }

    public List<Doctor> findDoctorsBySpecialty(String specialty) {
        return doctors.values().stream().filter(d -> d.getSpecialty().equals(specialty)).collect(Collectors.toList());
    }

    public List<Doctor> listDoctors(DoctorSelectionStrategy strategy, String specialty) {
        return strategy.select(findDoctorsBySpecialty(specialty));
    }

    public boolean bookAppointment(String patientId, String doctorId, Slot slot) {
        Patient patient = patients.get(patientId);
        Doctor doctor = doctors.get(doctorId);

        if (patient == null || doctor == null) return false;

        boolean alreadyBooked = patient.getAppointments().stream()
                .anyMatch(a -> a.getSlot().getStartTime().equals(slot.getStartTime()));
        if (alreadyBooked) return false;

        if (!doctor.getAvailableSlots().contains(slot)) return false;

        Appointment appointment = new Appointment(doctor, patient, slot);
        doctor.addAppointment(appointment);
        patient.addAppointment(appointment);
        doctor.getAvailableSlots().remove(slot);
        return true;
    }

    public void cancelAppointment(String patientId, Slot slot) {
        Patient patient = patients.get(patientId);
        if (patient == null) return;
        patient.getAppointments().removeIf(app -> app.getSlot().getStartTime().equals(slot.getStartTime()));
    }

    public List<Appointment> listFutureAppointments(User user) {
        List<Appointment> all = user instanceof Doctor ?
                ((Doctor) user).getAppointments() : ((Patient) user).getAppointments();
        return all.stream().filter(a -> a.getSlot().getStartTime().isAfter(java.time.LocalDateTime.now())).collect(Collectors.toList());
    }

    public List<Appointment> listPastAppointments(User user) {
        List<Appointment> all = user instanceof Doctor ?
                ((Doctor) user).getAppointments() : ((Patient) user).getAppointments();
        return all.stream().filter(a -> a.getSlot().getStartTime().isBefore(java.time.LocalDateTime.now())).collect(Collectors.toList());
    }
}
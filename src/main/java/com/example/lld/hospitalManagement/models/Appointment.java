package com.example.lld.hospitalManagement.models;

public class Appointment {
    private final Doctor doctor;
    private final Patient patient;
    private final Slot slot;

    public Appointment(Doctor doctor, Patient patient, Slot slot) {
        this.doctor = doctor;
        this.patient = patient;
        this.slot = slot;
    }

    public Doctor getDoctor() { return doctor; }
    public Patient getPatient() { return patient; }
    public Slot getSlot() { return slot; }
}

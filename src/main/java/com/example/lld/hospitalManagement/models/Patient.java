package com.example.lld.hospitalManagement.models;

import java.util.ArrayList;
import java.util.List;

public class Patient extends User{
    private final List<Appointment> appointments = new ArrayList<>();

    public Patient(String id, String name) {
        super(id, name);
    }

    public List<Appointment> getAppointments() { return appointments; }
    public void addAppointment(Appointment appointment) { appointments.add(appointment); }
    public void cancelAppointment(Appointment appointment) { appointments.remove(appointment); }
}

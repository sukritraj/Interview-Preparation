package com.example.lld.hospitalManagement.models;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends User{
    private final String specialty;
    private final List<Slot> availableSlots = new ArrayList<>();
    private final List<Appointment> appointments = new ArrayList<>();
    private double rating;

    public Doctor(String id, String name, String specialty) {
        super(id, name);
        this.specialty = specialty;
    }
    public String getSpecialty() { return specialty; }
    public List<Slot> getAvailableSlots() { return availableSlots; }
    public void addAvailableSlot(Slot slot) { availableSlots.add(slot); }
    public List<Appointment> getAppointments() { return appointments; }
    public void addAppointment(Appointment appointment) { appointments.add(appointment); }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
}

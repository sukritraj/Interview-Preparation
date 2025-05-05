package com.example.lld.hospitalManagement;

import com.example.lld.hospitalManagement.models.Doctor;
import com.example.lld.hospitalManagement.models.Slot;
import com.example.lld.hospitalManagement.services.HospitalService;
import com.example.lld.hospitalManagement.strategy.SlotStartTimeStrategy;

import java.time.LocalDateTime;
import java.util.List;

public class DriverApp {
    public static void main(String[] args) {
        HospitalService hospitalService = new HospitalService();

        hospitalService.registerDoctor("D1", "Dr. Smith", "Cardiology");
        hospitalService.registerDoctor("D2", "Dr. Adams", "Cardiology");
        hospitalService.registerDoctor("D3", "Dr. Clara", "Neurology");

        hospitalService.addDoctorSlot("D1", new Slot(LocalDateTime.of(2025, 5, 5, 10, 0)));
        hospitalService.addDoctorSlot("D2", new Slot(LocalDateTime.of(2025, 5, 5, 9, 0)));

        hospitalService.registerPatient("P1", "Alice");
        hospitalService.registerPatient("P2", "Bob");

        Slot slot = new Slot(LocalDateTime.of(2025, 5, 5, 9, 0));
        boolean booked = hospitalService.bookAppointment("P1", "D2", slot);
        System.out.println("Appointment Booked: " + booked);

        List<Doctor> topDoctors = hospitalService.listDoctors(new SlotStartTimeStrategy(), "Cardiology");
        System.out.println("Doctors sorted by earliest slot:");
        topDoctors.forEach(d -> System.out.println(d.getName()));
    }
}

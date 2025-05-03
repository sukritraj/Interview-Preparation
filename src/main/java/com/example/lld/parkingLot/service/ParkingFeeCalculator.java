package com.example.lld.parkingLot.service;

import com.example.lld.parkingLot.entity.ParkingTicket;
import com.example.lld.parkingLot.enums.VehicleType;

import java.time.Duration;
import java.util.Map;

public class ParkingFeeCalculator {
    private static final Map<VehicleType, Double> hourlyRates = Map.of(
            VehicleType.BIKE, 10.0,
            VehicleType.CAR, 20.0,
            VehicleType.TRUCK, 50.0
    );

    public double calculateFee(ParkingTicket ticket) {
        Duration duration = ticket.getParkingDuration();
        double hours = Math.ceil(duration.toMinutes() / 60.0);
        return hours * hourlyRates.get(ticket.getVehicle().getType());
    }
}

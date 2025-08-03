package com.example.lld.elevator.service;

import com.example.lld.elevator.model.Elevator;
import com.example.lld.elevator.model.Request;
import com.example.lld.elevator.scheduler.DefaultScheduler;
import com.example.lld.elevator.scheduler.Scheduler;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private final List<Elevator> elevators;
    private final Scheduler scheduler;

    public ElevatorSystem(int numElevators) {
        this.elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator(i));
        }
        this.scheduler = new DefaultScheduler();
    }

    public void handleRequest(Request request) {
        Elevator elevator = scheduler.assignElevator(request, elevators);
        if (elevator != null) {
            elevator.addRequest(request.getFloor());
        }
    }

    public void step() {
        for (Elevator e : elevators) {
            e.step();
        }
    }

    public void status() {
        for (Elevator e : elevators) {
            System.out.println(e);
        }
    }
}


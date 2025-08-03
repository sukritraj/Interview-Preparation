package com.example.lld.elevator.scheduler;

import com.example.lld.elevator.model.Elevator;
import com.example.lld.elevator.model.Request;

import java.util.List;

public class DefaultScheduler implements Scheduler {
    @Override
    public Elevator assignElevator(Request request, List<Elevator> elevators) {
        // Simple rule: pick closest idle or least loaded elevator
        Elevator best = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator e : elevators) {
            int distance = Math.abs(e.getCurrentFloor() - request.getFloor());
            if (e.isIdle() && distance < minDistance) {
                minDistance = distance;
                best = e;
            }
        }

        if (best == null && !elevators.isEmpty()) {
            best = elevators.get(0); // fallback
        }

        return best;
    }
}
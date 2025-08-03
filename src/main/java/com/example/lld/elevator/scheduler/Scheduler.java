package com.example.lld.elevator.scheduler;

import com.example.lld.elevator.model.Elevator;
import com.example.lld.elevator.model.Request;

import java.util.List;

public interface Scheduler {
    Elevator assignElevator(Request request, List<Elevator> elevators);
}

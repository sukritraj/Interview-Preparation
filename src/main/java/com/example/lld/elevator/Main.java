package com.example.lld.elevator;

import com.example.lld.elevator.model.Direction;
import com.example.lld.elevator.model.Request;
import com.example.lld.elevator.model.RequestType;
import com.example.lld.elevator.service.ElevatorSystem;

public class Main {
    public static void main(String[] args) {
        ElevatorSystem system = new ElevatorSystem(3);

        system.handleRequest(new Request(5, Direction.UP, RequestType.EXTERNAL));
        system.handleRequest(new Request(2, Direction.DOWN, RequestType.EXTERNAL));
        system.handleRequest(new Request(10, Direction.UP, RequestType.EXTERNAL));

        for (int i = 0; i < 15; i++) {
            System.out.println("== Time Tick: " + i + " ==");
            system.step();
            system.status();
            System.out.println();
        }
    }
}

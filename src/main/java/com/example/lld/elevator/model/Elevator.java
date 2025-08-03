package com.example.lld.elevator.model;

import java.util.PriorityQueue;
import java.util.Queue;

public class Elevator {
    private final int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState state;
    private final Queue<Integer> requestQueue;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.state = ElevatorState.IDLE;
        this.requestQueue = new PriorityQueue<>();
    }

    public void addRequest(int floor) {
        requestQueue.offer(floor);
    }

    public void step() {
        if (requestQueue.isEmpty()) {
            this.state = ElevatorState.IDLE;
            this.direction = Direction.IDLE;
            return;
        }

        int dest = requestQueue.peek();
        if (dest > currentFloor) {
            currentFloor++;
            direction = Direction.UP;
        } else if (dest < currentFloor) {
            currentFloor--;
            direction = Direction.DOWN;
        } else {
            requestQueue.poll(); // Reached destination
        }

        this.state = ElevatorState.MOVING;
    }

    public int getId() { return id; }
    public int getCurrentFloor() { return currentFloor; }
    public Direction getDirection() { return direction; }
    public ElevatorState getState() { return state; }
    public boolean isIdle() { return requestQueue.isEmpty(); }

    @Override
    public String toString() {
        return "Elevator " + id + " [Floor=" + currentFloor + ", Direction=" + direction + "]";
    }
}


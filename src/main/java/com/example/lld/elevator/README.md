👨‍💼 Interviewer:
You are asked to design a Multi-Elevator System for a building. The elevator system should support:

1. Multiple elevators.
2. Requests from users to go to a specific floor.
3. Internal elevator requests (inside the cabin).
4. Efficient elevator scheduling.
5. Basic fault tolerance (e.g., if an elevator is stuck).

👨‍💻 Candidate — Step-by-Step Design
✅ Step 1: Requirements Clarification

. Number of elevators: Variable, e.g., 3–10
. Floors: Configurable, e.g., 0–20
. Users can:
  . Press a call button at a floor (UP/DOWN)
  . Select a floor from inside the elevator
. System should assign the best elevator
. Elevator moves floor by floor
. Should handle concurrent requests

✅ Step 2: Identify Core Entities

| Class            | Responsibility                                   |
| ---------------- | ------------------------------------------------ |
| `ElevatorSystem` | Central controller for all elevators             |
| `Elevator`       | Represents each elevator                         |
| `Request`        | Models a floor or internal cabin request         |
| `RequestType`    | Enum for INTERNAL / EXTERNAL                     |
| `Direction`      | Enum for UP / DOWN / IDLE                        |
| `ElevatorState`  | Enum for MOVING / IDLE / MAINTENANCE             |
| `Scheduler`      | Assigns elevators to requests (Strategy Pattern) |

✅ Step 3: Design Patterns Used
. Strategy Pattern → To allow pluggable elevator scheduling algorithms.
. Singleton Pattern → For centralized ElevatorSystem.
. Command Pattern (lightweight) → Represent and queue requests.
. Observer Pattern (optional) → Notify UI of elevator state change.

✅ Step 4: Project Structure
elevator-system/
├── model/
│   ├── Elevator.java
│   ├── Direction.java
│   ├── ElevatorState.java
│   ├── Request.java
│   ├── RequestType.java
├── scheduler/
│   ├── Scheduler.java
│   ├── DefaultScheduler.java
├── service/
│   ├── ElevatorSystem.java
├── Main.java

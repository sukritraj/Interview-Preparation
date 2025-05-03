1. Functional Requirements
   1. Vehicle Parking & Un parking
      . Vehicles should be parked in the nearest available spot based on priority.
      . Vehicles can be un parked when they leave the parking lot.
   2. Priority-Based Parking
      . The system should allocate the nearest spot based on priority (e.g., closest to entry gate,EV Charging Priority,VIP Parking,Handicapped Parking (Future Extensibility)).
      . Some spots should be reserved for specific vehicle types.
   3. Multiple Entry & Exit Gates
      . Vehicles can enter through multiple gates.
      . Parking allocation should consider the nearest spot to the entry gate.
   4. Parking Spot Reservation
      . Some parking spots should be reserved for specific vehicle types.
   5. Real-Time Availability Check
      . The system should provide real-time information about the availability of parking spots.
   6. Vehicle Types & Extensibility
      . The system should support different vehicle types (car, bike, truck).
      . It should be easily extendable to add new vehicle types.
   7. Ticket Generation
      . After parking, a ticket should be generated with details like vehicle number, entry time, and spot number.
   8. Payment Processing
      . Payment should be automated when the vehicle exits.
      . The system should support multiple payment methods (Credit Card, UPI, Cash, Wallet).
      . The system should be extensible to accommodate new payment methods.

2. Non-Functional Requirements
   1. Scalability – The system should support a large number of vehicles and parking spots.
   2. Extensibility – New vehicle types, parking priorities, and pricing models should be easy to add.
   3. Performance – Parking, un parking, and payment processing should be optimized.
   4. Maintainability – The code should be modular and follow design patterns for easy updates.
   5. Security – Payment transactions should be secured.
   

3. Class Structure & Design Patterns Used

| Class Name                                 | Description                                     |
|--------------------------------------------|-------------------------------------------------|
| ParkingLot                                 | Manages all parking operations.                 |
| ParkingSpot                                | Represents a parking spot.                      |
| Vehicle                                    | Represents different vehicle types.             |
| Ticket                                     | Represents a parking ticket.                    |
| Payment                                    | Handles payments based on the ticket.           |
| PaymentStrategy                            | Interface for different payment methods.        |
| CreditCardPayment, UPIPayment,CashPayment  | Implementations of different payment methods.   |

4. Design Patterns Used

| Pattern               | Used For                                                        |
|-----------------------|-----------------------------------------------------------------|
| Strategy Pattern      | Defines different payment strategies (Credit Card, UPI, Cash).  |
| Factory Pattern       | Used for creating different payment methods dynamically.        |
| Singleton Pattern     | Ensures only one instance of ParkingLot.                        |

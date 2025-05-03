Step 1: Functional and Non-Functional Requirements
1. Functional Requirements
   1. User Management
      . Sign up, log in, log out
      . Manage user profiles
      . Delivery partners, restaurants, and customers
   2. Restaurant Management
      . Add/Remove restaurants
      . Menu management (add/remove/update food items)
      . Search and filter restaurants
   3. Order Management
      . Users can add/remove items from the cart
      . Place an order
      . Track order status (Confirmed, Preparing, Picked Up, Delivered)
   4. Delivery Partner Management
      . Assign a delivery partner to an order
      . Update real-time location
      . Mark order as delivered
   5. Payment Management
      . Multiple payment options (Credit/Debit Card, UPI, Wallets)
      . Refunds and cancellations
   6. Notification System
      . Order confirmation, preparation, pickup, and delivery notifications
      . Promotional messages and offers

2. Non-Functional Requirements
   1. Scalability → Should handle high concurrent users
   2. Reliability → Ensure no order is lost during processing
   3. Performance → Low-latency order placement and tracking
   4. Security → Secure payment transactions and user authentication
   5. Extensibility → Ability to add new payment methods, delivery options
   6. Availability → 24x7 availability of the system


Step 2: Design Patterns Used
1. Singleton Pattern → Used for NotificationService and PaymentGateway to ensure a single instance is used across the system.
2. Factory Pattern → Used in PaymentService to allow multiple payment options.
3. Observer Pattern → Used for NotificationService to notify users of order status updates.
4. Strategy Pattern → Used in DeliveryAssignment to implement different assignment strategies.
5. Builder Pattern → Used in OrderBuilder to create complex orders with multiple items.
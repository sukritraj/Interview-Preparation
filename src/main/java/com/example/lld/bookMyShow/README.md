Requirements and Low-Level Design (LLD) for BookMyShow (Movie Booking System)

Requirements:
1. Users should be able to search for movies based on location, language, and genre.
2. Users should be able to view the available shows for a selected movie at different theatres.
3. Users should be able to select seats, make a booking, and process payments.
4. Admins should be able to add movies, theatres, screens, and shows.
5. Real-time seat availability should be maintained.
6. Payment status should be tracked and linked to bookings.
7. Notifications or confirmations should be sent to users upon successful booking.
8. The system should be scalable to handle large numbers of users and bookings.

Design Approach:
1. Use Object-Oriented Programming principles and design patterns for modularity and reusability.
2. Use the Factory pattern for creating objects such as Movies, Theatres, and Shows.
3. Use Singleton pattern for services like BookingService and PaymentService to ensure single points of control.
4. Use Observer pattern for notification or confirmation messages.

+------------------+
|      User        |
+------------------+
| - userId         |
| - name           |
| - email          |
+------------------+
| + getUserId()    |
| + getName()      |
| + getEmail()     |
+------------------+

+------------------+
|      Movie       |
+------------------+
| - movieId        |
| - title          |
| - genre          |
| - duration       |
+------------------+
| + getMovieId()   |
| + getTitle()     |
| + getGenre()     |
| + getDuration()  |
+------------------+

+------------------+
|     Theatre      |
+------------------+
| - theatreId      |
| - name           |
| - location       |
| - screens        |
+------------------+
| + getTheatreId() |
| + getName()      |
| + getLocation()  |
| + getScreens()   |
| + addScreen()    |
+------------------+

+------------------+
|      Screen      |
+------------------+
| - screenId       |
| - name           |
| - seats          |
+------------------+
| + getScreenId()  |
| + getName()      |
| + getSeats()     |
| + addSeat()      |
+------------------+

+------------------+
|      Seat        |
+------------------+
| - seatId         |
| - status         |
+------------------+
| + getSeatId()    |
| + getStatus()    |
| + bookSeat()     |
| + blockSeat()    |
| + releaseSeat()  |
+------------------+

+------------------+
|      Show        |
+------------------+
| - showId         |
| - movie          |
| - screen         |
| - startTime      |
| - endTime        |
| - price          |
+------------------+
| + getShowId()    |
| + getMovie()     |
| + getScreen()    |
| + getStartTime() |
| + getEndTime()   |
| + getPrice()     |
+------------------+

+------------------+
|     Booking      |
+------------------+
| - bookingId      |
| - user           |
| - show           |
| - bookedSeats    |
| - payment        |
+------------------+
| + getBookingId() |
| + getUser()      |
| + getShow()      |
| + getBookedSeats()|
| + getPayment()   |
+------------------+

+------------------+
|     Payment      |
+------------------+
| - paymentId      |
| - amount         |
| - status         |
+------------------+
| + processPayment()|
| + getPaymentId()  |
| + getStatus()     |
+------------------+

+--------------------------+
|    BookingService (S)    |
+--------------------------+
| - instance               |
| - bookings               |
+--------------------------+
| + getInstance()          |
| + createBooking()        |
+--------------------------+
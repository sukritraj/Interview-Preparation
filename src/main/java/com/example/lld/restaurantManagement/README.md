# Design Restaurant Management System: ClearFood

## Overview
- Restaurants can serve in multiple areas (identified by Pincode).
- **Location**: At a time, users can order from one restaurant, and the quantity of food can be more than one.
- **Rating**: Users should be able to rate any restaurant with or without a comment. The rating of a restaurant is the average rating given by all customers.

## Functional Requirements
1. **Register Restaurant**:  
   `register_restaurant(restaurant_name, list of serviceable pin-codes, food item name, food item price, initial quantity)`  
   Registers a restaurant with its details.

2. **Update Quantity**:  
   `update_quantity(restaurant_name, quantity_to_add)`  
   Restaurant owners should be able to increase the quantity of the food item.

3. **Rate Restaurant**:  
   `rate_restaurant(restaurant_name, rating, comment)`  
   Users should be able to rate (1-Lowest to 5-Highest) any restaurant with or without a comment.

4. **Show Restaurant**:  
   `show_restaurant(rating/price)`  
   Users should be able to get a list of all serviceable restaurants, food item names, and prices in descending order, based on rating or price.

5. **Place Order**:  
   `place_order(restaurant_name, quantity)`  
   A restaurant is serviceable when it delivers to the user's pincode and has a non-zero quantity of the food item. Users can place an order from any restaurant with any allowed quantity.

6. **Order History**:  
   `order_history(username)`  
   Fetches the order history of a user.

## Notes
- Use an in-memory database.
- No UI is required for the application.
- A driver class can be used to simulate all operations.

---

## Expectations
- **Code Completion**: Working executable code.
- **Feature Coverage**: All functional requirements should be implemented.
- **Design Principles**: Follow clean and extensible design principles.
- **Sample Flow**: Demonstrate the flow of operations.

---

## Sample Flow

### User Registration
register_user("Pralove", "M", "phoneNumber-1", "HSR")
register_user("Nitesh", "M", "phoneNumber-2", "BTM")
register_user("Vatsal", "M", "phoneNumber-3", "BTM")
login_user("phoneNumber-1")

### Restaurant Registration
register_restaurant("Food Court-1", "BTM/HSR", "NI Thali", 100, 5)
register_restaurant("Food Court-2", "BTM/pincode-2", "Burger", 120, 3)
login_user("phoneNumber-2")
register_restaurant("Food Court-3", "HSR", "SI Thali", 150, 1)
login_user("phoneNumber-3")

### Fetch Restaurant List
show_restaurant("Price")  
Output: Food Court-2, Burger | Food Court-1, NI Thali

### Order Placement
place_order("Food Court-1", 2)  
Output: Order Placed Successfully.

place_order("Food Court-2", 7)  
Output: Cannot place order

### Add Review
create_review("Food Court-2", 3, "Good Food")
create_review("Food Court-1", 5, "Nice Food")

show_restaurant("rating")  
Output: Food Court-1, NI Thali | Food Court-2, Burger

### Update Quantity
login_user("phoneNumber-1")  
update_quantity("Food Court-2", 5) 
Output: Food Court-2, BTM, Burger - 8

### Update Location
update_location("Food Court-2", "BTM/HSR")  
Output: Food Court-2, BTM/HSR, Burger - 8
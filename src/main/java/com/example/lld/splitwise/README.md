# 🧾 Splitwise - Low Level Design in Java

A Java-based implementation of **Splitwise** that allows users to track shared expenses and balances. Designed using *
*SOLID principles**, **OOP**, and **design patterns** to ensure modularity and future extensibility (e.g., switching to
database or building a REST API).

---

## 📌 Functional Requirements

- Users can be added to the system.
- A user can add an expense involving one or more users.
- Supported split types:
    - Equal
    - Exact
    - Percentage
- The system maintains who owes whom and how much.
- View all balances.

---

## ⚙️ Non-Functional Requirements

- ✅ **Extensible**: Easy to add more split types (e.g., shares, custom logic).
- ✅ **Scalable**: Currently uses in-memory storage, easily replaceable with DB.
- ✅ **Modular**: Clean separation of concerns.
- ✅ **Testable**: Each class can be independently tested.
- ✅ **Design Patterns Used**:
    - Strategy Pattern — for Split logic
    - Factory Pattern — to create Expenses
    - Repository Pattern — to isolate storage logic
    - Singleton — optional for shared BalanceSheet if needed

---

## 🏗️ Project Structure
splitwise/
├── driver/ # Main application runner
├── model/ # Domain entities (User, Expense, Split, etc.)
├── repository/ # In-memory storage (replaceable with DB)
├── strategy/ # Split calculation logic (Strategy Pattern)
├── factory/ # Expense factory
├── service/ # Business logic (ExpenseService, BalanceSheet)


---

## 🧱 Tech Stack

- Language: **Java 17+**
- Architecture: **Object-Oriented Programming**
- Build Tool: **Maven / Gradle** (your choice)
- Testing: Easy to plug in JUnit

---

## 🧠 Design Patterns Used

| Pattern      | Purpose                                            |
|--------------|----------------------------------------------------|
| Strategy     | Abstracts different split types                    |
| Factory      | Creates Expense objects based on type             |
| Repository   | Abstracts data layer for users and expenses       |
| Singleton    | Optional for shared BalanceSheet instance         |

---

## 🔧 How to Run

1. Clone this repo.
2. Compile using:
   ```bash
   javac splitwise/driver/SplitwiseApp.java
   java splitwise.driver.SplitwiseApp



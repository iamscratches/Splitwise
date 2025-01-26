# Splitwise - Expense Sharing System

## Overview
This project is a Java-based implementation of a **Splitwise-like expense sharing system**, designed using **SOLID principles** to ensure modularity, scalability, and maintainability. It enables users to manage expenses efficiently, calculate balances dynamically, and track outstanding dues.

---

## Features

### 1. Expense Management
- Add expenses for groups or individuals.
- Support for flexible split types:
  - **Equal Split**: Expenses are divided equally among participants.
  - **Exact Split**: Participants pay specific amounts.
  - **Percentage Split**: Expenses are divided based on percentages.

### 2. User Balances
- Track "who owes whom" and their outstanding balances.
- Dynamic balance updates for every transaction.

### 3. Extensible Design
- New split types can be easily added by implementing the `SplitStrategy` interface.

### 4. Adherence to SOLID Principles
- **SRP**: Each class handles a single responsibility (e.g., `User`, `Expense`, `Split`).
- **OCP**: System supports adding new split types without modifying existing code.
- **LSP**: Subclasses like `EqualSplit`, `ExactSplit`, and `PercentageSplit` can replace the base `Split` class.
- **ISP**: Interfaces like `SplitStrategy` focus on specific splitting logic.
- **DIP**: High-level components depend on abstractions (`SplitStrategy`) rather than concrete implementations.

---

## Class Structure

### Core Classes
1. **User**:
   - Represents a user with attributes like `userId`, `name`, and `email`.
2. **Split**:
   - Abstract class representing a generic split.
   - Subclasses:
     - `EqualSplit`
     - `ExactSplit`
     - `PercentageSplit`
3. **Expense**:
   - Represents an expense with attributes like `amount`, `paidBy`, and `splits`.
4. **ExpenseManager**:
   - Manages users, expenses, and balances.

### Interfaces
1. **SplitStrategy**:
   - Interface for implementing custom splitting logic.

---

## How to Run

### Prerequisites
1. Install Java 8 or higher.
2. Set up any Java IDE (e.g., IntelliJ IDEA, Eclipse) or use the terminal.

### Steps
1. Clone the repository.
   ```bash
   git clone https://github.com/your-repo/splitwise-java.git
   ```
2. Open the project in your preferred Java IDE.
3. Run the `SplitwiseApp` class to start the application.

---

## Sample Input and Output

### Input:
- **Scenario**:
  1. Add three users: Alice, Bob, and Charlie.
  2. Add expenses:
     - Alice pays $300, split equally between Bob and Charlie.
     - Bob pays $300, split exactly ($100 to Alice, $200 to Charlie).
     - Charlie pays $300, split by percentage (40% to Alice, 60% to Bob).

### Output:
```plaintext
Alice owes Bob: -50.0
Alice owes Charlie: -30.0
Bob owes Alice: 50.0
Bob owes Charlie: -20.0
Charlie owes Alice: 30.0
Charlie owes Bob: 20.0
```

### Explanation:
- After three transactions, the balances are calculated dynamically:
  1. **Transaction 1**:
     - Alice paid $300, equally split between Bob and Charlie.
     - Bob and Charlie each owe Alice $150.
  2. **Transaction 2**:
     - Bob paid $300, split exactly as $100 to Alice and $200 to Charlie.
     - Balances adjust accordingly.
  3. **Transaction 3**:
     - Charlie paid $300, split by percentage (40% to Alice, 60% to Bob).
     - Final balances reflect these splits.

---

## Future Enhancements
1. **Group Support**:
   - Manage expenses within groups and split balances at the group level.
2. **Mobile App Integration**:
   - Build a user-friendly interface for adding expenses and viewing balances.
3. **Dynamic Pricing**:
   - Add support for advanced features like recurring expenses or notifications.

---

## Conclusion
The **Splitwise - Expense Sharing System** is a robust solution for managing shared expenses efficiently. By leveraging **SOLID principles** and a modular design, it ensures scalability and maintainability, making it easy to extend for future requirements.

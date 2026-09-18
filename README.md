# Bank Management System

A Java-based **Bank Management System** developed as a command-line application. The project provides basic banking operations such as creating accounts, viewing account details, depositing and withdrawing money, checking balances, and maintaining transaction history.
The project is designed using **Object-Oriented Programming (OOP)** concepts in Java. Different responsibilities are divided into separate classes to make the application easier to understand, maintain, and extend.

---
**Java Project Submission**

* **University:** VIT Bhopal University
* **Professor:** Rizwan Urrahman
* **Student:** Ahmad Salem Khan
* **Registration Number:** 25BAI11418
* **Date:** September 18, 2026

---

## Project Overview

The Bank Management System simulates basic operations performed in a banking environment. Users can interact with the application through a simple menu-driven command-line interface.

The application allows users to:

* Create multiple bank accounts
* Store customer and account information
* View individual account details
* Deposit money into an account
* Withdraw money from an account
* Check the current account balance
* View transaction history
* View all accounts maintained by the bank
* Perform basic validation for banking operations

The project demonstrates how Java classes and objects can be used to represent real-world entities such as a **Bank, Account, and Transaction**.

---

## Objectives

The main objectives of this project are:

1. To develop a basic banking application using Java.
2. To understand and implement Object-Oriented Programming concepts.
3. To divide a larger program into multiple classes.
4. To implement account management functionality.
5. To maintain transaction records for deposits and withdrawals.
6. To provide a simple and user-friendly command-line interface.
7. To practice Java Collections such as `ArrayList`.
8. To implement basic banking operations using Java.

---

## Features

### 1. Create Account

Users can create a new bank account by entering:

* Customer name
* Account number
* Initial deposit

The system checks whether the account number already exists before creating a new account.

### 2. View Account

Users can enter an account number to view the account information.

The system displays:

* Customer name
* Account number
* Current balance

### 3. Deposit Money

Users can deposit money into an existing account.

After a successful deposit:

* The account balance is updated.
* The deposit is recorded as a transaction.
* The updated balance is displayed.

### 4. Withdraw Money

Users can withdraw money from an existing account.

The system checks whether sufficient balance is available before completing the withdrawal.

After a successful withdrawal:

* The account balance is updated.
* The withdrawal is recorded as a transaction.
* The updated balance is displayed.

### 5. Check Balance

Users can enter their account number to check the current available balance.

### 6. Transaction History

The application maintains records of successful deposits and withdrawals.

Each transaction contains:

* Transaction type
* Transaction amount
* Date and time of the transaction

### 7. View All Accounts

The bank can display all accounts currently created in the system.

This feature uses Java's `ArrayList` to store and manage multiple account objects.

### 8. Input Validation

The application performs basic validation for banking operations, such as checking account existence, duplicate account numbers, valid deposit amounts, and sufficient balance during withdrawals.

---

## Technologies Used

| Technology                  | Purpose                             |
| --------------------------- | ----------------------------------- |
| Java                        | Main programming language           |
| Object-Oriented Programming | Application design                  |
| ArrayList                   | Storing accounts and transactions   |
| Scanner                     | Reading user input                  |
| LocalDateTime               | Recording transaction date and time |
| Command Line Interface      | User interaction                    |
| Git & GitHub                | Version control and project hosting |

---

## Requirements

The project requires:

* Java JDK 8 or later
* Command Prompt or Terminal
* Git (optional for GitHub)

Java version can be checked using:

```bash
java -version
```

The Java compiler can be checked using:

```bash
javac -version
```

---

## Project Structure

```text
Bank-Management-System/
│
├── src/
│   ├── Main.java
│   ├── Account.java
│   ├── Transaction.java
│   └── Bank.java
│
├── README.md
└── .gitignore
```

---

## Description of Source Files

### Main.java

`Main.java` is the entry point of the application.

It is responsible for:

* Starting the program
* Displaying the main menu
* Reading user input
* Calling banking operations
* Managing the program loop
* Exiting the application

The `main()` method creates a `Bank` object and uses it to manage accounts.

---

### Account.java

`Account.java` represents an individual bank account.

It stores:

* Account number
* Customer name
* Account balance
* Transaction list

The class provides methods for:

* Depositing money
* Withdrawing money
* Displaying account details
* Displaying transaction history
* Getting account information

The account fields are declared as `private`, demonstrating **encapsulation**.

---

### Transaction.java

`Transaction.java` represents an individual banking transaction.

A transaction contains:

* Transaction type
* Transaction amount
* Transaction date and time

Transactions are created when a deposit or withdrawal is successfully performed.

---

### Bank.java

`Bank.java` represents the bank that manages multiple accounts.

It uses an `ArrayList` to store account objects.

The class provides methods to:

* Add accounts
* Find an account using the account number
* Display all accounts
* Get the total number of accounts

---

## Object-Oriented Programming Concepts

This project demonstrates several important OOP concepts.

### 1. Classes and Objects

The project uses separate classes to represent different entities:

```text
Bank
Account
Transaction
```

Objects are created from these classes during program execution.

For example:

```java
Account account = new Account(number, name, initialDeposit);
```

---

### 2. Encapsulation

Account information is kept private inside the `Account` class.

For example:

```java
private String accountNumber;
private String customerName;
private double balance;
```

Access to these variables is controlled through methods such as:

```java
getBalance()
getAccountNumber()
getCustomerName()
```

This helps protect the account data from direct modification.

---

### 3. Constructors

Constructors are used to initialize objects when they are created.

For example:

```java
public Account(String accountNumber, String customerName, double balance)
```

The constructor initializes the account information when a new account object is created.

---

### 4. Methods

Methods are used to perform specific operations.

Examples include:

```text
deposit()
withdraw()
findAccount()
displayAccount()
displayTransactions()
```

Dividing functionality into methods makes the program easier to understand and maintain.

---

### 5. ArrayList

The project uses Java's `ArrayList` to store multiple accounts and transactions.

For example:

```java
private List<Account> accounts;
```

and:

```java
private List<Transaction> transactions;
```

This allows the application to manage multiple objects dynamically.

---

## Application Workflow

The general workflow of the application is:

```text
Start
  |
  v
Display Main Menu
  |
  v
Select Operation
  |
  +----> Create Account
  |
  +----> View Account
  |
  +----> Deposit Money
  |
  +----> Withdraw Money
  |
  +----> Check Balance
  |
  +----> Transaction History
  |
  +----> View All Accounts
  |
  +----> Exit
  |
  v
End
```

The program continues displaying the menu until the user selects the **Exit** option.

---

## Data Flow

The basic data flow of the application is:

```text
User Input
    |
    v
Main.java
    |
    v
Bank.java
    |
    v
Account.java
    |
    v
Transaction.java
```

For example, when a user deposits money:

```text
User enters deposit amount
          |
          v
     Main.java
          |
          v
     Bank finds Account
          |
          v
   Account.deposit()
          |
          v
    Balance updated
          |
          v
 Transaction created
```

---

## Main Menu

When the application starts, the following menu is displayed:

```text
======================================
       BANK MANAGEMENT SYSTEM
======================================

------------- MAIN MENU -------------
1. Create Account
2. View Account
3. Deposit Money
4. Withdraw Money
5. Check Balance
6. Transaction History
7. View All Accounts
8. Exit
--------------------------------------
Enter your choice:
```

---

## Example Usage

### Creating an Account

```text
Enter your choice: 1

--------- CREATE ACCOUNT ---------

Enter customer name: Rahul
Enter account number: 101
Enter initial deposit: 5000

Account created successfully!
```

### Depositing Money

```text
Enter your choice: 3

Enter account number: 101
Enter amount to deposit: 2000

Deposit successful!
Current Balance: 7000.00
```

### Withdrawing Money

```text
Enter your choice: 4

Enter account number: 101
Enter amount to withdraw: 1000

Withdrawal successful!
Current Balance: 6000.00
```

### Checking Balance

```text
Enter your choice: 5

Enter account number: 101
Current Balance: 6000.00
```

### Viewing Transaction History

```text
Enter your choice: 6

Enter account number: 101

--------- TRANSACTION HISTORY ---------

DEPOSIT | Amount: 2000.0 | Date: 18-09-2026 00:35:21
WITHDRAW | Amount: 1000.0 | Date: 18-09-2026 00:36:10
```

---

## Future Enhancements

The project can be extended with additional features such as:

* File-based data storage
* Database integration using MySQL
* User login and authentication
* PIN/password protection
* Account deletion
* Account updating
* Money transfer between accounts
* Mini statement generation
* Interest calculation
* Loan management
* Admin panel
* Graphical User Interface (GUI)
* Web-based interface
* Improved input handling

---

## Educational Purpose

This project was developed as an academic project to demonstrate practical implementation of Java programming and Object-Oriented Programming concepts.

The project provides practical experience with:

* Java programming
* Classes and objects
* Encapsulation
* Constructors
* Methods
* Collections
* User input
* Conditional statements
* Loops
* Basic validation
* Modular program design
* GitHub project management

---

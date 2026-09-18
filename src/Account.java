package src;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String accountNumber;
    private String customerName;
    private double balance;
    private List<Transaction> transactions;

    // Constructor
    public Account(String accountNumber, String customerName, double balance) {

        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty.");
        }

        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty.");
        }

        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }

        this.accountNumber = accountNumber.trim();
        this.customerName = customerName.trim();
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    // Deposit money
    public boolean deposit(double amount) {

        if (amount <= 0) {
            return false;
        }

        balance += amount;
        transactions.add(new Transaction("DEPOSIT", amount));
        return true;
    }

    // Withdraw money
    public boolean withdraw(double amount) {

        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        transactions.add(new Transaction("WITHDRAW", amount));
        return true;
    }

    // Display account details
    public void displayAccount() {

        System.out.println("\n--------- ACCOUNT DETAILS ---------");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.printf("Balance       : %.2f%n", balance);
    }

    // Display transaction history
    public void displayTransactions() {

        System.out.println("\n--------- TRANSACTION HISTORY ---------");

        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }

        for (Transaction t : transactions) {
            t.displayTransaction();
        }
    }

    // Check balance
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }
}
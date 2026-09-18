package src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String type;
    private double amount;
    private LocalDateTime dateTime;

    // Constructor
    public Transaction(String type, double amount) {

        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Transaction type cannot be empty.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Transaction amount must be greater than zero.");
        }

        this.type = type.trim();
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    // Display transaction
    public void displayTransaction() {

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println(
                type + " | Amount: " + amount +
                " | Date: " + dateTime.format(format)
        );
    }

    // Getters
    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
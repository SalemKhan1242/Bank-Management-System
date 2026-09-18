package src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Bank bank = new Bank();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("======================================");
        System.out.println("       BANK MANAGEMENT SYSTEM");
        System.out.println("======================================");

        do {
            System.out.println("\n------------- MAIN MENU -------------");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Transaction History");
            System.out.println("7. View All Accounts");
            System.out.println("8. Exit");
            System.out.println("--------------------------------------");

            choice = readInt(scanner, "Enter your choice: ");

            switch (choice) {

                case 1:
                    createAccount(scanner);
                    break;

                case 2:
                    viewAccount(scanner);
                    break;

                case 3:
                    depositMoney(scanner);
                    break;

                case 4:
                    withdrawMoney(scanner);
                    break;

                case 5:
                    checkBalance(scanner);
                    break;

                case 6:
                    transactionHistory(scanner);
                    break;

                case 7:
                    bank.displayAllAccounts();
                    break;

                case 8:
                    System.out.println("\nThank you for using Bank Management System!");
                    break;

                default:
                    System.out.println(
                        "\nInvalid choice. Please enter a number from 1 to 8."
                    );
            }

        } while (choice != 8);

        scanner.close();
    }

    // ---------- Safe input helpers ----------

    // Reads an integer, reprompting on invalid (non-numeric) input.
    static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = scanner.nextInt();
                scanner.nextLine(); // consume leftover newline
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.nextLine(); // discard the bad token
            }
        }
    }

    // Reads a double, reprompting on invalid (non-numeric) input.
    static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = scanner.nextDouble();
                scanner.nextLine(); // consume leftover newline
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid amount (e.g. 100.50).");
                scanner.nextLine(); // discard the bad token
            }
        }
    }

    // Looks up an account by number, printing a message and returning null if not found.
    static Account findAccountOrPrompt(Scanner scanner) {

        if (bank.getAccountCount() == 0) {
            System.out.println("\nPlease create an account first.");
            return null;
        }

        System.out.print("Enter account number: ");
        String accNum = scanner.nextLine().trim();

        Account account = bank.findAccount(accNum);

        if (account == null) {
            System.out.println("No account found with number " + accNum + ".");
        }

        return account;
    }

    // ---------- Account operations ----------

    // Create a new bank account
    static void createAccount(Scanner scanner) {

        System.out.println("\n--------- CREATE ACCOUNT ---------");

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter account number: ");
        String accNum = scanner.nextLine().trim();

        double initialDeposit = readDouble(scanner, "Enter initial deposit: ");

        try {
            Account account = new Account(accNum, name, initialDeposit);
            bank.addAccount(account);
            System.out.println("\nAccount created successfully!");
            account.displayAccount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Display account details
    static void viewAccount(Scanner scanner) {

        Account account = findAccountOrPrompt(scanner);

        if (account != null) {
            account.displayAccount();
        }
    }

    // Deposit money
    static void depositMoney(Scanner scanner) {

        Account account = findAccountOrPrompt(scanner);

        if (account == null) {
            return;
        }

        double amount = readDouble(scanner, "Enter amount to deposit: ");

        if (!account.deposit(amount)) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }

        System.out.println("Deposit successful!");
        System.out.printf("Deposited       : %.2f%n", amount);
        System.out.printf("Current Balance : %.2f%n", account.getBalance());
    }

    // Withdraw money
    static void withdrawMoney(Scanner scanner) {

        Account account = findAccountOrPrompt(scanner);

        if (account == null) {
            return;
        }

        double amount = readDouble(scanner, "Enter amount to withdraw: ");

        if (amount > account.getBalance()) {
            System.out.println("Insufficient balance.");
            return;
        }

        if (!account.withdraw(amount)) {
            System.out.println("Withdrawal amount must be greater than zero.");
            return;
        }

        System.out.println("Withdrawal successful!");
        System.out.printf("Withdrawn       : %.2f%n", amount);
        System.out.printf("Current Balance : %.2f%n", account.getBalance());
    }

    // Check account balance
    static void checkBalance(Scanner scanner) {

        Account account = findAccountOrPrompt(scanner);

        if (account == null) {
            return;
        }

        System.out.println("\n--------- BALANCE ---------");
        System.out.println("Account Number  : " + account.getAccountNumber());
        System.out.printf("Current Balance : %.2f%n", account.getBalance());
    }

    // Show transaction history
    static void transactionHistory(Scanner scanner) {

        Account account = findAccountOrPrompt(scanner);

        if (account != null) {
            account.displayTransactions();
        }
    }
}
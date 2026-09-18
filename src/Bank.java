package src;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts;

    // Constructor
    public Bank() {
        accounts = new ArrayList<>();
    }

    // Add a new account
    public void addAccount(Account account) {

        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null.");
        }

        if (findAccount(account.getAccountNumber()) != null) {
            throw new IllegalArgumentException(
                "An account with number " + account.getAccountNumber() + " already exists."
            );
        }

        accounts.add(account);
    }

    // Find account using account number
    public Account findAccount(String accountNumber) {

        if (accountNumber == null) {
            return null;
        }

        String target = accountNumber.trim();

        for (Account account : accounts) {

            if (account.getAccountNumber().equals(target)) {
                return account;
            }
        }

        return null;
    }

    // Display all accounts
    public void displayAllAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("\nNo accounts found.");
            return;
        }

        System.out.println("\n--------- ALL ACCOUNTS ---------");

        for (Account account : accounts) {
            account.displayAccount();
        }
    }

    // Get total number of accounts
    public int getAccountCount() {
        return accounts.size();
    }
}
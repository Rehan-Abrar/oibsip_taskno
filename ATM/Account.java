package ATM;

import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transactions;

    public Account(double initialBalance) {
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
        System.out.println("Successfully deposited $" + amount);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount));
            System.out.println("Successfully withdrew $" + amount);
        }
    }

    public void transfer(double amount, Account recipient) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            recipient.deposit(amount);
            transactions.add(new Transaction("Transfer to recipient", amount));
            System.out.println("Successfully transferred $" + amount);
        }
    }

    public void showTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transaction History:");
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    public double getBalance() {
        return balance;
    }
}

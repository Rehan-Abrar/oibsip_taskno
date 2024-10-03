package ATM;

import java.util.Scanner;

public class ATM {
    private User user;
    private Scanner scanner;

    public ATM(User user) {
        this.user = user;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    user.getAccount().showTransactionHistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        user.getAccount().withdraw(amount);
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        user.getAccount().deposit(amount);
    }

    private void transfer() {
        System.out.print("Enter recipient's account ID: ");
        String recipientId = scanner.next();

        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();

        user.getAccount().transfer(amount, new Account(500.0)); 
    }
}

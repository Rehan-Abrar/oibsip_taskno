package ATM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User user = new User("12345", "0000", new Account(1000.0)); 

        System.out.println("Welcome to the ATM!");
        System.out.print("Enter User ID: ");
        String enteredId = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine();

        if (user.validateCredentials(enteredId, enteredPin)) {
            ATM atm = new ATM(user);
            atm.showMenu();
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }
}

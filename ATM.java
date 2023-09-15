import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.event.SwingPropertyChangeSupport;

class Transaction {
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return type + ": Rs" + amount;
    }
}

public class ATM {
    private double balance;
    private Scanner scanner;
    private List<Transaction> transactionHistory;

    public ATM() {
        balance = 1000.0; // Initial balance (you can set any value)
        scanner = new Scanner(System.in);
        transactionHistory = new ArrayList<>();
    }

    public void displayMenu() {
        System.out.println("***Welcome to My ATM***");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Transaction History");
        System.out.println("5. Exit");

    }

    public void checkBalance() {
        System.out.println("Your balance is: Rs." + balance);
    }

    public void depositMoney() {
        System.out.print("Enter the amount to deposit: Rs.");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction("Deposit", amount));
            System.out.println("Rs." + amount + " has been deposited.");
            System.out.println("........................................");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: Rs.");

        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdraw", amount));
            System.out.println("Rs." + amount + " has been withdrawn.");
            System.out.println("......................................");
        } else if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
            System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        int choice;

        do {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            choice = atm.scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    atm.depositMoney();
                    break;
                case 3:
                    atm.withdrawMoney();
                    break;
                case 4:
                    atm.displayTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for using My ATM. Goodbye!");
                    System.out.println("......................................");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        atm.scanner.close();

    }

}

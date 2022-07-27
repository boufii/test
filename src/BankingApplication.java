
import java.util.List;
import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {

        BankAccount obj1 =new BankAccount("yassine","SSE7");
        obj1.showMenu();

    }
}
class BankAccount {
    BankAccount(String cname, String cid) {
        customerid = cid;
        customerName = cname;
    }

    int balance;
    int previousTransaction;
    String customerName;
    String customerid;

    void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited : " + previousTransaction);
        } else {
            if (previousTransaction < 0) {
                System.out.println("withdraw : " + Math.abs(previousTransaction));
            }
            System.out.println(" No transaction occured ");
        }
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome " + customerName);
        System.out.println("Your ID is " + customerid);
        System.out.println("\n");
        System.out.println("A. Check balance");
        System.out.println("B. Deposite ");
        System.out.println("C. withdraw ");
        System.out.println("D. previous transaction ");
        System.out.println("E. Exit ");
        do {
            System.out.println("Choose  an option");
            option = scanner.next().charAt(0);
            System.out.println("\n");
            switch (option) {
                case 'A':
                    System.out.println("\n");
                    System.out.println("Balance " + balance);
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("Enter an amount to deposite");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw :");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;
                case 'D':
                    getPreviousTransaction();
                    System.out.println("\n");
                default:
                    System.out.println("invalide option!, Please enter again");
            }
    }
        while (option != 'E');
        System.out.println("Thankyou for using our services!");
}
}
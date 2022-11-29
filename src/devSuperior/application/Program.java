package devSuperior.application;

import devSuperior.entities.Account;
import devSuperior.exceptions.BusinessException;

import javax.crypto.spec.PSource;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data: ");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Holder: ");
        sc.nextLine();
        String holder  = sc.nextLine();
        System.out.print("Initial balance: ");
        double balance = sc.nextDouble();
        System.out.print("Limit: ");
        double limit = sc.nextDouble();

        Account acc = new Account(number, holder, balance, limit);

        System.out.println();
        System.out.print("Enter amount for withdraw: ");
        double amount = sc.nextDouble();

        try {
            acc.withdraw(amount);
            System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));
        }
        catch (BusinessException e){
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}

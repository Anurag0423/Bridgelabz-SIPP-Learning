import java.util.Scanner;

public class BankAccount {
   
    static String bankName = "ABC Bank";
    private static int totalAccounts = 0;

    
    private final String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("\n--- Account Details ---");
            System.out.println("Bank Name      : " + bankName);
            System.out.println("Account Holder : " + accountHolderName);
            System.out.println("Account Number : " + accountNumber);
            System.out.println("Balance        : ₹" + balance);
        } else {
            System.out.println("Not a valid BankAccount object.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount acc = new BankAccount(name, accNum, balance);

        acc.displayDetails();

        System.out.println("\nTotal Accounts Created: " + BankAccount.getTotalAccounts());

        sc.close();
    }
}

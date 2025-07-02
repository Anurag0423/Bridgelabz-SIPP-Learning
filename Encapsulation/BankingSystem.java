import java.util.ArrayList;

// Interface for loan-related functionality
interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}

// Abstract BankAccount class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        setBalance(balance); // use setter for validation
    }

    // Getters
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    // Setter for balance with validation
    public void setBalance(double balance) {
        if (balance >= 0)
            this.balance = balance;
        else
            System.out.println("Balance cannot be negative.");
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount);
        } else {
            System.out.println("Invalid or insufficient funds.");
        }
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateInterest();

    // Display basic account details
    public void displayAccountInfo() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + holderName);
        System.out.println("Balance        : ₹" + balance);
    }
}

// SavingsAccount class
class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04; // 4% interest
    }

    @Override
    public boolean applyForLoan(double amount) {
        if (amount <= calculateLoanEligibility()) {
            System.out.println("Loan of ₹" + amount + " approved for Savings Account.");
            return true;
        } else {
            System.out.println("Loan denied. Exceeds eligibility.");
            return false;
        }
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 2; // Loan eligibility = 2x balance
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.01; // 1% interest
    }

    @Override
    public boolean applyForLoan(double amount) {
        if (amount <= calculateLoanEligibility()) {
            System.out.println("Loan of ₹" + amount + " approved for Current Account.");
            return true;
        } else {
            System.out.println("Loan denied. Exceeds eligibility.");
            return false;
        }
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 1.5; // Loan eligibility = 1.5x balance
    }
}

// Main class to test the system
public class BankingSystem {
    // Process account polymorphically
    public static void processAccount(BankAccount account) {
        account.displayAccountInfo();

        // Show interest
        double interest = account.calculateInterest();
        System.out.println("Calculated Interest : ₹" + interest);

        // Loan processing if applicable
        if (account instanceof Loanable) {
            Loanable loanable = (Loanable) account;
            double eligibility = loanable.calculateLoanEligibility();
            System.out.println("Loan Eligibility    : ₹" + eligibility);
            loanable.applyForLoan(eligibility * 0.75); // apply for 75% of eligible amount
        }

        System.out.println("--------------------------------------------");
    }

    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("SAV123", "Alice", 50000));
        accounts.add(new CurrentAccount("CUR456", "Bob", 100000));

        for (BankAccount account : accounts) {
            processAccount(account); // polymorphism in action
        }
    }
}

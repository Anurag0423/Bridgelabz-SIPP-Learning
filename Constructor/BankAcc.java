public class BankAccountManagement {

    // Base class: BankAccount
    static class BankAccount {
        public String accountNumber;       // public
        protected String accountHolder;    // protected
        private double balance;            // private

        // Constructor
        public BankAccount(String accountNumber, String accountHolder, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = balance;
        }

        // Getter for balance
        public double getBalance() {
            return balance;
        }

        // Setter for balance
        public void setBalance(double balance) {
            if (balance >= 0) {
                this.balance = balance;
            } else {
                System.out.println("Invalid balance. Cannot be negative.");
            }
        }

        // Display account info
        public void displayAccountInfo() {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolder);
            System.out.println("Balance: ₹" + balance);
        }
    }

    // Subclass: SavingsAccount
    static class SavingsAccount extends BankAccount {

        private double interestRate;

        public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
            super(accountNumber, accountHolder, balance);
            this.interestRate = interestRate;
        }

        // Display savings account details
        public void displaySavingsAccountInfo() {
            System.out.println("Savings Account Details:");
            System.out.println("Account Number (public): " + accountNumber);
            System.out.println("Account Holder (protected): " + accountHolder);
            System.out.println("Balance (via getter): ₹" + getBalance());
            System.out.println("Interest Rate: " + interestRate + "%");
        }
    }

    // Main method
    public static void main(String[] args) {
        // Creating a BankAccount object
        BankAccount acc1 = new BankAccount("1234567890", "Anurag Bhardwaj", 10000);
        System.out.println("Bank Account Info:");
        acc1.displayAccountInfo();

        System.out.println("\nUpdating balance...");
        acc1.setBalance(12000);
        acc1.displayAccountInfo();

        System.out.println("\n--------------------------------\n");

        // Creating a SavingsAccount object
        SavingsAccount savings = new SavingsAccount("9876543210", "Riya Sharma", 15000, 4.5);
        savings.displaySavingsAccountInfo();
    }
}

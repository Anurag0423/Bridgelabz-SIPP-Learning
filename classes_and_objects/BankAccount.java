package classes_and_objects;

public class BankAccount {
	//Attributes
	String accountHolder;
	String accountNumber;
	double balance;
	
	//Constructor
	public BankAccount(String accountHolder, String accountNumber, double balance) {
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	// Method to deposit
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("₹" + amount + "deposited successfully");
		}else {
			System.out.println("Invalid deposit amount");
		}
	}
	
	// Method to withdraw
	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("₹" + amount + " withdrawn successfully.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance for withdrawal.");
        } else {
            System.out.println("Invalid withdrawal amount.");
		}
	}
	
	// Method to display current balance
	public void displayBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        displayBalance();
        System.out.println("----------------------------");
    }

    // Main method to test
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Tanvi Mehra", "SB123456", 10000.0);

        account1.displayAccountDetails();
        account1.deposit(2500.0);
        account1.withdraw(3000.0);
        account1.withdraw(15000.0); // Attempting an overdraw
        account1.displayBalance();
    }
}

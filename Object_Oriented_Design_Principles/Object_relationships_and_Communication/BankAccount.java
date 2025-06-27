import java.util.ArrayList;

// Account class
class Account {
    private static int nextAccountNumber = 1001;
    private int accountNumber;
    private double balance;
    private Bank bank;

    public Account(Bank bank) {
        this.accountNumber = nextAccountNumber++;
        this.balance = 0.0;
        this.bank = bank;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public Bank getBank() {
        return bank;
    }

    public void displayAccount() {
        System.out.println("Account No: " + accountNumber + ", Bank: " + bank.getBankName() + ", Balance: " + balance);
    }
}

// Customer class
class Customer {
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Customer: " + name);
        for (Account account : accounts) {
            account.displayAccount();
        }
    }
}

// Bank class
class Bank {
    private String bankName;
    private ArrayList<Customer> customers;

    public Bank(String bankName) {
        this.bankName = bankName;
        customers = new ArrayList<>();
    }

    public String getBankName() {
        return bankName;
    }

    public void openAccount(Customer customer) {
        Account newAccount = new Account(this);
        customer.addAccount(newAccount);
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println("Account opened for " + customer.getName() + " in " + bankName + ", Account No: " + newAccount.getAccountNumber());
    }

    public void displayCustomers() {
        System.out.println("Bank: " + bankName + " - Customers:");
        for (Customer c : customers) {
            System.out.println("- " + c.getName());
        }
    }
}

// Main class
public class BankAssociationDemo {
    public static void main(String[] args) {
        // Create banks
        Bank sbi = new Bank("SBI");
        Bank hdfc = new Bank("HDFC");

        // Create customers
        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        // Open accounts
        sbi.openAccount(alice);
        sbi.openAccount(bob);
        hdfc.openAccount(alice); // Alice also opens account in HDFC

        System.out.println();
        alice.viewBalance();
        System.out.println();
        bob.viewBalance();
        System.out.println();

        sbi.displayCustomers();
        hdfc.displayCustomers();
    }
}

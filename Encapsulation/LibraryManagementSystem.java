import java.util.ArrayList;

// Interface for reservable items
interface Reservable {
    boolean reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract class LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private String borrower;  // Sensitive info
    private boolean isAvailable;

    // Constructor
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Getters
    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    // Encapsulation for sensitive data
    public String getMaskedBorrower() {
        if (borrower == null || borrower.length() < 2)
            return "Not Assigned";
        return borrower.charAt(0) + "****";
    }

    protected void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    protected void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    // Abstract method
    public abstract int getLoanDuration(); // in days

    // Common method
    public void getItemDetails() {
        System.out.println("Item ID    : " + itemId);
        System.out.println("Title      : " + title);
        System.out.println("Author     : " + author);
        System.out.println("Available  : " + isAvailable);
        System.out.println("Loan Period: " + getLoanDuration() + " days");
        System.out.println("Borrower   : " + getMaskedBorrower());
    }
}

// Subclass: Book
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21; // 3 weeks
    }

    @Override
    public boolean reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            setAvailable(false);
            System.out.println("Book reserved for " + borrowerName);
            return true;
        }
        System.out.println("Book not available.");
        return false;
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Subclass: Magazine
class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 1 week
    }

    @Override
    public boolean reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            setAvailable(false);
            System.out.println("Magazine reserved for " + borrowerName);
            return true;
        }
        System.out.println("Magazine not available.");
        return false;
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Subclass: DVD
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days
    }

    @Override
    public boolean reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            setAvailable(false);
            System.out.println("DVD reserved for " + borrowerName);
            return true;
        }
        System.out.println("DVD not available.");
        return false;
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Main class
public class LibrarySystem {
    public static void processItem(LibraryItem item) {
        item.getItemDetails();
        System.out.println("---------------------------------------");
    }

    public static void main(String[] args) {
        ArrayList<LibraryItem> items = new ArrayList<>();

        items.add(new Book("B101", "Java Programming", "Herbert Schildt"));
        items.add(new Magazine("M202", "National Geographic", "Various Authors"));
        items.add(new DVD("D303", "Inception", "Christopher Nolan"));

        // Reserve some items using interface polymorphism
        for (LibraryItem item : items) {
            if (item instanceof Reservable) {
                Reservable r = (Reservable) item;
                r.reserveItem("Rahul");
            }
        }

        System.out.println("\n--- Library Item Details ---");
        for (LibraryItem item : items) {
            processItem(item);  // Polymorphism in action
        }
    }
}

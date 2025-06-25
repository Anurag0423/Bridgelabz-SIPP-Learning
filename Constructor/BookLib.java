public class Book {
    // Attributes
    private String title;
    private String author;
    private double price;
    private boolean available;

    // Default Constructor
    public Book() {
        this.title = "Untitled";
        this.author = "Unknown";
        this.price = 0.0;
        this.available = true;
    }

    // Parameterized Constructor
    public Book(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    // Method to borrow a book
    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("You have successfully borrowed the book: " + title);
        } else {
            System.out.println("Sorry, the book \"" + title + "\" is currently not available.");
        }
    }

    // Method to display book info
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
        System.out.println("Available: " + (available ? "Yes" : "No"));
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Create a book instance
        Book book1 = new Book("Atomic Habits", "James Clear", 499.0, true);
        
        System.out.println("Book Info:");
        book1.displayInfo();

        System.out.println("\nTrying to borrow the book...");
        book1.borrowBook();

        System.out.println("\nTrying to borrow the book again...");
        book1.borrowBook();

        System.out.println("\nUpdated Book Info:");
        book1.displayInfo();
    }
}

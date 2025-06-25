
public class Book {
    public String ISBN;         // Public: accessible from anywhere
    protected String title;     // Protected: accessible in subclass
    private String author;      // Private: accessible only within the class

    // Constructor
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Setter for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Display book details
    public void displayBookInfo() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Subclass: EBook
class EBook extends Book {

    private double fileSizeMB;

    public EBook(String ISBN, String title, String author, double fileSizeMB) {
        super(ISBN, title, author);
        this.fileSizeMB = fileSizeMB;
    }

    public void displayEBookInfo() {
        System.out.println("E-Book Details:");
        System.out.println("ISBN (public): " + ISBN);        // Access public
        System.out.println("Title (protected): " + title);   // Access protected
        // Cannot directly access `author` here, it's private
        System.out.println("Author (via getter): " + getAuthor()); // Access via public method
        System.out.println("File Size: " + fileSizeMB + " MB");
    }

    // Main method for testing
    public static void main(String[] args) {
        // Base class object
        Book b1 = new Book("978-1234567890", "The Java Handbook", "John Doe");
        System.out.println("Book Info:");
        b1.displayBookInfo();

        System.out.println("\nUpdating author...");
        b1.setAuthor("Jane Smith");
        b1.displayBookInfo();

        System.out.println("\n--------------------------------\n");

        // Subclass object
        EBook ebook1 = new EBook("978-0987654321", "Advanced Java", "Alice Walker", 5.2);
        ebook1.displayEBookInfo();
    }
}

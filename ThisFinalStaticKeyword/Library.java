public class Book {
    // Static variable and method
    static String libraryName = "Central City Library";

    public static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    // Instance variables
    private String title;
    private String author;
    private final String isbn; // Final - can't be changed once assigned

    // Constructor using 'this'
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Method to display book details using instanceof
    public void displayDetails() {
        if (this instanceof Book) {
            System.out.println("\n--- Book Details ---");
            System.out.println("Library       : " + libraryName);
            System.out.println("Title         : " + title);
            System.out.println("Author        : " + author);
            System.out.println("ISBN (Final)  : " + isbn);
        } else {
            System.out.println("Not a valid Book object.");
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Display the library name using static method
        Book.displayLibraryName();

        // Create Book objects
        Book b1 = new Book("Java Programming", "James Gosling", "ISBN1001");
        Book b2 = new Book("Clean Code", "Robert C. Martin", "ISBN1002");

        // Display book details
        b1.displayDetails();
        b2.displayDetails();
    }
}

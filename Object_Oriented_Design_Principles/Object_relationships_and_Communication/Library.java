import java.util.ArrayList;

// Book class
class Book {
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Display book details
    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

// Library class (Aggregation)
class Library {
    private String name;
    private ArrayList<Book> books;

    // Constructor
    public Library(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    // Add book to library
    public void addBook(Book book) {
        books.add(book);
    }

    // Display all books in library
    public void displayLibraryBooks() {
        System.out.println("Library: " + name);
        for (Book b : books) {
            b.displayBook();
        }
    }
}

// Main class to test aggregation
public class LibraryDemo {
    public static void main(String[] args) {
		// Create books
        Book book1 = new Book("Wings of Fire", "A.P.J. Abdul Kalam", "India");
        Book book2 = new Book("1984", "George Orwell", "UK");
        Book book3 = new Book("The Guide", "R.K. Narayan", "India");

        // Create libraries
        Library library1 = new Library("City Library");
        Library library2 = new Library("University Library");

        // Add books to libraries
        library1.addBook(book1);
        library1.addBook(book2);

        library2.addBook(book2); // Shared book
        library2.addBook(book3);

        // Display books in each library
        library1.displayLibraryBooks();
        System.out.println();
        library2.displayLibraryBooks();
    }
}

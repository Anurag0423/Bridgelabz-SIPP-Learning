import java.util.*;

public class BookDemo {
    
    // Book class
    static class Book {
        // Attributes
        private String title;
        private String author;
        private double price;

        // Default Constructor
        public Book() {
            this.title = "Unknown";
            this.author = "Unknown";
            this.price = 0.0;
        }

        // Parameterized Constructor
        public Book(String title, String author, double price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }

        // Getters
        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public double getPrice() {
            return price;
        }

        // Setters
        public void setTitle(String title) {
            this.title = title;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        // Display method
        public void displayInfo() {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Price: ₹" + price);
        }
    }

    // Main method
    public static void main(String[] args) {
        // Using default constructor
        Book defaultBook = new Book();
        System.out.println("Default Book Info:");
        defaultBook.displayInfo();

        System.out.println();

        // Using parameterized constructor
        Book javaBook = new Book("Effective Java", "Joshua Bloch", 699.00);
        System.out.println("Java Book Info:");
        javaBook.displayInfo();
    }
}

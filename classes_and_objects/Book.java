package classes_and_objects;

public class Book {
	String title;
	String author;
	double price;
	
	public Book(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public void displayDetails() {
        System.out.println("Book Details:");
		System.out.println("Book title: " + title);
		System.out.println("Author: " + author);
		System.out.println("Price: " + price);
	}
	
	public static void main(String... args) {
		Book book1 = new Book("The Alchemist", "Paulo Coelho", 399.99);
		book1.displayDetails();
	}
}

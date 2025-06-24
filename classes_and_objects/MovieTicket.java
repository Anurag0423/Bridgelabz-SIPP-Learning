package classes_and_objects;

public class MovieTicket {
	//Attributes
	String movieName;
	String seatNumber;
	double price;
	
	//Constructor
	public MovieTicket() {
		movieName = "";
		seatNumber = "";
		price = 0.0;
	}
	
	// Method to book a ticket
    public void bookTicket(String movieName, String seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket booked successfully!");
    }
 // Method to display ticket details
    public void displayTicket() {
        System.out.println("Movie Ticket Details:");
        System.out.println("Movie Name : " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price      : ₹" + price);
        System.out.println("----------------------------");
    }

    // Main method to test
    public static void main(String[] args) {
        // Create a ticket object
        MovieTicket ticket1 = new MovieTicket();

        // Book the ticket
        ticket1.bookTicket("Inception", "B12", 250.00);

        // Display ticket details
        ticket1.displayTicket();

        // Create and book another ticket
        MovieTicket ticket2 = new MovieTicket();
        ticket2.bookTicket("Interstellar", "A8", 300.00);
        ticket2.displayTicket();
    }

}

public class CarRental {

    // Attributes
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double totalCost;

    // Default constructor
    public CarRental() {
        this.customerName = "Unknown Customer";
        this.carModel = "Standard";
        this.rentalDays = 0;
        this.totalCost = 0.0;
    }

    // Parameterized constructor
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.totalCost = calculateTotalCost();
    }

    // Method to calculate total cost based on car model and days
    private double calculateTotalCost() {
        double ratePerDay;
        switch (carModel.toLowerCase()) {
            case "suv":
                ratePerDay = 3000;
                break;
            case "sedan":
                ratePerDay = 2000;
                break;
            case "hatchback":
                ratePerDay = 1500;
                break;
            default:
                ratePerDay = 1000; // standard / economy
        }
        return ratePerDay * rentalDays;
    }

    // Getters
    public String getCustomerName() {
        return customerName;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public double getTotalCost() {
        return totalCost;
    }

    // Display rental details
    public void displayDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model:     " + carModel);
        System.out.println("Rental Days:   " + rentalDays);
        System.out.println("Total Cost: ₹" + totalCost);
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        // Default booking
        CarRental defaultRental = new CarRental();
        System.out.println("Default Rental:");
        defaultRental.displayDetails();

        System.out.println();

        // Custom booking
        CarRental customRental = new CarRental("Anurag Bhardwaj", "SUV", 4);
        System.out.println("Custom Rental:");
        customRental.displayDetails();
    }
}

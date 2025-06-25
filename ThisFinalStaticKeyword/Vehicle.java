public class Vehicle {
    // 1. Static: common registration fee for all vehicles
    static double registrationFee = 1500.0;

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to ₹" + registrationFee);
    }

    // 2. Final: registration number cannot be changed
    private final String registrationNumber;

    // Instance variables
    private String ownerName;
    private String vehicleType;

    // 3. Constructor using 'this'
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // 4. Display method using instanceof
    public void displayDetails() {
        if (this instanceof Vehicle) {
            System.out.println("\n--- Vehicle Registration Details ---");
            System.out.println("Owner Name         : " + ownerName);
            System.out.println("Vehicle Type       : " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee   : ₹" + registrationFee);
        } else {
            System.out.println("Invalid Vehicle object.");
        }
    }

    // Main method to test the Vehicle class
    public static void main(String[] args) {
        // Update registration fee
        Vehicle.updateRegistrationFee(2000.0);

        // Create Vehicle objects
        Vehicle v1 = new Vehicle("Anurag Bhardwaj", "Car", "UP32AB1234");
        Vehicle v2 = new Vehicle("Riya Sharma", "Bike", "UP32XY5678");

        // Display vehicle details
        v1.displayDetails();
        v2.displayDetails();
    }
}

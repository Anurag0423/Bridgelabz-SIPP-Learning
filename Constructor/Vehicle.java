public class Vehicle {

    // Instance Variables
    private String ownerName;
    private String vehicleType;

    // Class Variable (Shared across all vehicles)
    private static double registrationFee = 2500.0;

    // Constructor
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance Method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: ₹" + registrationFee);
    }

    // Class Method to update the registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to: ₹" + registrationFee);
    }

    // Main method to test functionality
    public static void main(String[] args) {
        // Creating vehicle objects
        Vehicle v1 = new Vehicle("Anurag Bhardwaj", "Car");
        Vehicle v2 = new Vehicle("Ravi Sharma", "Bike");

        // Displaying initial vehicle details
        System.out.println("Vehicle 1:");
        v1.displayVehicleDetails();
        System.out.println();

        System.out.println("Vehicle 2:");
        v2.displayVehicleDetails();
        System.out.println();

        // Updating registration fee
        System.out.println("Updating registration fee...\n");
        Vehicle.updateRegistrationFee(3000.0);
        System.out.println();

        // Displaying updated vehicle details
        System.out.println("Vehicle 1 after update:");
        v1.displayVehicleDetails();
        System.out.println();

        System.out.println("Vehicle 2 after update:");
        v2.displayVehicleDetails();
    }
}

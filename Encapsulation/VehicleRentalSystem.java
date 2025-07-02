import java.util.ArrayList;

// Interface for insurable vehicles
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        setInsurancePolicyNumber(insurancePolicyNumber);
    }

    // Getters
    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    // Insurance policy is sensitive
    public String getMaskedInsurancePolicyNumber() {
        if (insurancePolicyNumber.length() >= 4) {
            return "****" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
        } else {
            return "****";
        }
    }

    // Setter with validation
    public void setInsurancePolicyNumber(String insurancePolicyNumber) {
        if (insurancePolicyNumber != null && !insurancePolicyNumber.trim().isEmpty()) {
            this.insurancePolicyNumber = insurancePolicyNumber;
        } else {
            this.insurancePolicyNumber = "UNKNOWN";
        }
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    // Display basic vehicle info
    public void displayInfo(int days) {
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Vehicle Type   : " + type);
        System.out.println("Rental Rate    : ₹" + rentalRate + " per day");
        System.out.println("Days Rented    : " + days);
        System.out.println("Rental Cost    : ₹" + calculateRentalCost(days));
    }
}

// Subclass: Car
class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days; // simple flat rate
    }

    @Override
    public double calculateInsurance() {
        return 5000.0; // fixed insurance for car
    }

    @Override
    public String getInsuranceDetails() {
        return "Car insurance - ₹5000, Policy: " + getMaskedInsurancePolicyNumber();
    }
}

// Subclass: Bike
class Bike extends Vehicle implements Insurable {
    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.9; // 10% discount
    }

    @Override
    public double calculateInsurance() {
        return 1000.0; // fixed insurance for bike
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike insurance - ₹1000, Policy: " + getMaskedInsurancePolicyNumber();
    }
}

// Subclass: Truck
class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        double baseCost = getRentalRate() * days;
        double loadingFee = 1500; // extra loading fee
        return baseCost + loadingFee;
    }

    @Override
    public double calculateInsurance() {
        return 8000.0;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck insurance - ₹8000, Policy: " + getMaskedInsurancePolicyNumber();
    }
}

// Main class
public class VehicleRentalSystem {
    // Utility method to process any vehicle polymorphically
    public static void processVehicle(Vehicle vehicle, int days) {
        vehicle.displayInfo(days);

        if (vehicle instanceof Insurable) {
            Insurable insurable = (Insurable) vehicle;
            System.out.println("Insurance Cost : ₹" + insurable.calculateInsurance());
            System.out.println("Insurance Info : " + insurable.getInsuranceDetails());
        } else {
            System.out.println("Insurance Info : Not Insurable");
        }

        System.out.println("---------------------------------------------------");
    }

    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("CAR1234", 2000, "CARP987654321"));
        vehicles.add(new Bike("BIK5678", 500, "BIKP123456789"));
        vehicles.add(new Truck("TRK3456", 4000, "TRKP876543210"));

        int rentalDays = 3;

        for (Vehicle v : vehicles) {
            processVehicle(v, rentalDays);
        }
    }
}

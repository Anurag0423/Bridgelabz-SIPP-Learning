import java.util.*;

// GPS interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract Vehicle class
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    // Constructor
    public Vehicle(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    // Getters
    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    // Protected setter for secure internal update
    protected void setRatePerKm(double ratePerKm) {
        if (ratePerKm >= 0) this.ratePerKm = ratePerKm;
    }

    protected void setCurrentLocation(String location) {
        this.currentLocation = location;
    }

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID   : " + vehicleId);
        System.out.println("Driver Name  : " + driverName);
        System.out.println("Rate per Km  : ₹" + ratePerKm);
    }

    // Abstract method
    public abstract double calculateFare(double distance);
}

// Car class
class Car extends Vehicle implements GPS {
    private String location;

    public Car(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
        this.location = location;
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50; // ₹50 base fare for car
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}

// Bike class
class Bike extends Vehicle implements GPS {
    private String location;

    public Bike(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
        this.location = location;
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance; // no base fare
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}

// Auto class
class Auto extends Vehicle implements GPS {
    private String location;

    public Auto(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
        this.location = location;
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 20; // ₹20 base fare for auto
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}

// Main class
public class RideHailingApp {
    public static void processRide(Vehicle vehicle, double distance) {
        vehicle.getVehicleDetails();
        System.out.println("Distance     : " + distance + " km");
        System.out.println("Total Fare   : ₹" + vehicle.calculateFare(distance));

        if (vehicle instanceof GPS) {
            System.out.println("Current Location: " + ((GPS) vehicle).getCurrentLocation());
        }

        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        List<Vehicle> rides = new ArrayList<>();

        Car car = new Car("CAR123", "Ramesh", 15.0, "MG Road");
        Bike bike = new Bike("BIKE456", "Suresh", 8.0, "BTM Layout");
        Auto auto = new Auto("AUTO789", "Mahesh", 10.0, "Indiranagar");

        rides.add(car);
        rides.add(bike);
        rides.add(auto);

        System.out.println("-------- Ride Fare Summary --------\n");
        for (Vehicle ride : rides) {
            processRide(ride, 10.0); // all rides for 10 km
        }
    }
}

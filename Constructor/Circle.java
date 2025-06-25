import java.util.*;

public class CircleDemo {

    static class Circle {
        private double radius;

        // Default constructor
        public Circle() {
            this(1.0); // Constructor chaining to parameterized constructor
        }

        // Parameterized constructor
        public Circle(double radius) {
            this.radius = radius;
        }

        // Getter
        public double getRadius() {
            return radius;
        }

        // Setter
        public void setRadius(double radius) {
            this.radius = radius;
        }

        // Method to calculate area
        public double calculateArea() {
            return Math.PI * radius * radius;
        }

        // Display method
        public void displayInfo() {
            System.out.println("Radius: " + radius);
            System.out.println("Area: " + calculateArea());
        }
    }

    // Main method to test Circle class
    public static void main(String[] args) {
        // Using default constructor
        Circle defaultCircle = new Circle();
        System.out.println("Default Circle:");
        defaultCircle.displayInfo();

        System.out.println();

        // Using parameterized constructor
        Circle customCircle = new Circle(5.5);
        System.out.println("Custom Circle:");
        customCircle.displayInfo();
    }
}

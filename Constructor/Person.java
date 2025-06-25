import java.util.*;

public class Person {

    // Attributes
    private String name;
    private int age;

    // Default Constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Parameterized Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy Constructor
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Display method
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Main method
    public static void main(String[] args) {
        // Create person using parameterized constructor
        Person original = new Person("Anurag", 25);
        System.out.println("Original Person:");
        original.displayInfo();

        System.out.println();

        // Create a copy of the person
        Person copy = new Person(original);
        System.out.println("Copied Person:");
        copy.displayInfo();
    }
}

public class Employee {
    // Static variable and method
    static String companyName = "Tech Solutions Pvt. Ltd.";
    private static int totalEmployees = 0;

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Instance variables
    private String name;
    private final int id;  // Final - can't be changed
    private String designation;

    // Constructor using 'this'
    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    // Method to display employee details using instanceof
    public void displayDetails() {
        if (this instanceof Employee) {
            System.out.println("\n--- Employee Details ---");
            System.out.println("Company       : " + companyName);
            System.out.println("Name          : " + name);
            System.out.println("Employee ID   : " + id);
            System.out.println("Designation   : " + designation);
        } else {
            System.out.println("Not a valid Employee object.");
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Create Employee objects
        Employee emp1 = new Employee("Anurag Bhardwaj", 101, "Software Engineer");
        Employee emp2 = new Employee("Riya Sharma", 102, "HR Manager");

        // Display employee details
        emp1.displayDetails();
        emp2.displayDetails();

        // Show total employee count using static method
        Employee.displayTotalEmployees();
    }
}

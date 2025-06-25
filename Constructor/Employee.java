public class EmployeeRecords {

    // Base class: Employee
    static class Employee {
        public int employeeID;         // public
        protected String department;   // protected
        private double salary;         // private

        // Constructor
        public Employee(int employeeID, String department, double salary) {
            this.employeeID = employeeID;
            this.department = department;
            this.salary = salary;
        }

        // Public method to set salary
        public void setSalary(double salary) {
            if (salary >= 0) {
                this.salary = salary;
            } else {
                System.out.println("Salary must be non-negative.");
            }
        }

        // Public method to get salary
        public double getSalary() {
            return salary;
        }

        // Method to display employee details
        public void displayEmployeeInfo() {
            System.out.println("Employee ID: " + employeeID);
            System.out.println("Department: " + department);
            System.out.println("Salary: ₹" + salary);
        }
    }

    // Subclass: Manager
    static class Manager extends Employee {
        private int teamSize;

        // Constructor
        public Manager(int employeeID, String department, double salary, int teamSize) {
            super(employeeID, department, salary);
            this.teamSize = teamSize;
        }

        // Method to display manager details using public & protected members
        public void displayManagerInfo() {
            System.out.println("Manager Details:");
            System.out.println("Employee ID (public): " + employeeID);
            System.out.println("Department (protected): " + department);
            System.out.println("Salary (via getter): ₹" + getSalary());
            System.out.println("Team Size: " + teamSize);
        }
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Creating Employee object
        Employee emp1 = new Employee(101, "HR", 35000);
        System.out.println("Employee Info:");
        emp1.displayEmployeeInfo();

        System.out.println("\nUpdating salary...");
        emp1.setSalary(38000);
        emp1.displayEmployeeInfo();

        System.out.println("\n-----------------------------\n");

        // Creating Manager object
        Manager mgr1 = new Manager(201, "IT", 60000, 5);
        mgr1.displayManagerInfo();
    }
}

import java.util.ArrayList;

// Employee class
class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public void displayEmployee() {
        System.out.println("  Employee: " + name);
    }
}

// Department class (composition with Employee)
class Department {
    private String departmentName;
    private ArrayList<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        employees = new ArrayList<>();
    }

    public void addEmployee(String employeeName) {
        employees.add(new Employee(employeeName));
    }

    public void displayDepartment() {
        System.out.println("Department: " + departmentName);
        for (Employee emp : employees) {
            emp.displayEmployee();
        }
    }
}

// Company class (composition with Department)
class Company {
    private String companyName;
    private ArrayList<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        departments = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addEmployeeToDepartment(String deptName, String empName) {
        for (Department dept : departments) {
            if (deptName.equals(dept.departmentName)) {
                dept.addEmployee(empName);
                return;
            }
        }
        System.out.println("Department " + deptName + " not found!");
    }

    public void displayCompany() {
        System.out.println("Company: " + companyName);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
    }

    // "Deleting" the company (simulated by clearing data)
    public void deleteCompany() {
        departments.clear();
        System.out.println("Company '" + companyName + "' and all its departments and employees have been deleted.");
    }
}

// Main class
public class CompanyCompositionDemo {
    public static void main(String[] args) {
        // Create a company
        Company company = new Company("Tech Innovators");

        // Add departments
        company.addDepartment("HR");
        company.addDepartment("Development");

        // Add employees to departments
        company.addEmployeeToDepartment("HR", "Alice");
        company.addEmployeeToDepartment("Development", "Bob");
        company.addEmployeeToDepartment("Development", "Charlie");

        // Display company structure
        System.out.println("=== Company Structure ===");
        company.displayCompany();

        // Delete company
        System.out.println("\n=== Deleting Company ===");
        company.deleteCompany();
    }
}

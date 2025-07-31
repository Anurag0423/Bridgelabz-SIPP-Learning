import java.io.*;
import java.util.ArrayList;

// Employee class (must be Serializable)
class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "ID=" + id +
               ", Name='" + name + '\'' +
               ", Department='" + department + '\'' +
               ", Salary=" + salary +
               '}';
    }
}

// Main class to serialize and deserialize employees
public class EmployeeSerializer {
    public static void main(String[] args) {
        String fileName = "employees.ser";

        // 1. Create a list of Employee objects
        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101, "Alice", "HR", 50000));
        employeeList.add(new Employee(102, "Bob", "IT", 60000));
        employeeList.add(new Employee(103, "Charlie", "Finance", 55000));

        // 2. Serialize the list to a file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employeeList);
            System.out.println("✅ Employees serialized to file: " + fileName);
        } catch (IOException e) {
            System.out.println("❌ Serialization Error: " + e.getMessage());
        }

        // 3. Deserialize the list from the file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            ArrayList<Employee> savedEmployees = (ArrayList<Employee>) ois.readObject();
            System.out.println("\n✅ Deserialized Employee List:");
            for (Employee emp : savedEmployees) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("❌ Deserialization Error: " + e.getMessage());
        }
    }
}

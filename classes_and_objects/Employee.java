package classes_and_objects;
public class Employee{
	// Attributes
	String name;
	int id;
	double salary;
	
	//Constructor
	public Employee(String name, int id, double salary) {
		this.name= name;
		this.id = id;
		this.salary = salary;
	}
	
	public void displayDetails() {
		System.out.println("Employee details: ");
		System.out.println("Name: " + name);
		System.out.println("ID: " + id);
		System.out.println("Salary: " + salary);
		
	}
	
	public static void main(String[] args) {
		Employee emp1 = new Employee("Mohan", 1, 10000);
		emp1.displayDetails();
	}
	
}
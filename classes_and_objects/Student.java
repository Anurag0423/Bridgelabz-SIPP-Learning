package classes_and_objects;

public class Student {
	String name;
	int rollNumber;
	double marks;
	
	public Student(String name, int rollNumber, double marks) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.marks = marks;
	}
	
	public String grade() {
		if(marks >= 90) {
			return "A+";
    	} else if (marks >= 80) {
    		return "A";
    	} else if (marks >= 70) {
    		return "B";
    	} else if (marks >= 60) {
    		return "C";
    	} else if (marks >= 50) {
    		return "D";
    	} else {
    		return "F";
    	}
	}
	public void displayDetails() {
		System.out.println("Student Details:");
        System.out.println("Name       : " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks      : " + marks);
        System.out.println("Grade      : " + grade());
        System.out.println("------------------------------");
    }
	
	public static void main(String[] args) {
		Student s1 = new Student("Aarav", 101, 92.5);
        Student s2 = new Student("Maya", 102, 76.0);
        Student s3 = new Student("Rohan", 103, 48.0);

        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();
	}
}

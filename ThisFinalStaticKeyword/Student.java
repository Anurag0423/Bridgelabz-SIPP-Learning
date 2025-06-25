public class Student {
    // 1. Static: shared across all students
    static String universityName = "Global Tech University";
    private static int totalStudents = 0;

    public static void displayTotalStudents() {
        System.out.println("Total Enrolled Students: " + totalStudents);
    }

    // 2. Final: roll number can't be changed
    private final int rollNumber;

    // Instance variables
    private String name;
    private String grade;

    // 3. Constructor using 'this'
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    // 4. Display details using instanceof
    public void displayDetails() {
        if (this instanceof Student) {
            System.out.println("\n--- Student Details ---");
            System.out.println("University     : " + universityName);
            System.out.println("Name           : " + name);
            System.out.println("Roll Number    : " + rollNumber);
            System.out.println("Grade          : " + grade);
        } else {
            System.out.println("Invalid student object.");
        }
    }

    // Update grade if the object is a valid Student
    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated to: " + grade);
        } else {
            System.out.println("Grade update failed. Not a Student object.");
        }
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Create Student objects
        Student s1 = new Student("Anurag Bhardwaj", 101, "A");
        Student s2 = new Student("Riya Sharma", 102, "B");

        // Display student details
        s1.displayDetails();
        s2.displayDetails();

        // Update and show new grade
        s2.updateGrade("A+");

        // Display updated details
        s2.displayDetails();

        // Show total number of students
        Student.displayTotalStudents();
    }
}

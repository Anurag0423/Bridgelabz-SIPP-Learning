
public class Student {
    public int rollNumber;         // public
    protected String name;         // protected
    private double CGPA;           // private

    // Constructor
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public getter for CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Public setter for CGPA
    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA. Please enter a value between 0.0 and 10.0.");
        }
    }

    // Method to display student info
    public void displayStudentInfo() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}

// Subclass: PostgraduateStudent
class PostgraduateStudent extends Student {

    private String researchTopic;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String researchTopic) {
        super(rollNumber, name, CGPA);
        this.researchTopic = researchTopic;
    }

    public void displayPostgraduateInfo() {
        System.out.println("Postgraduate Student Details:");
        System.out.println("Name (Accessing protected): " + name); // Accessing protected member
        System.out.println("Roll Number: " + rollNumber);          // Accessing public member
        System.out.println("Research Topic: " + researchTopic);
        System.out.println("CGPA (via getter): " + getCGPA());     // Accessing private via method
    }

    // Main method to demonstrate
    public static void main(String[] args) {
        // Create base class object
        Student s1 = new Student(101, "Anurag", 8.6);
        System.out.println("Student Info:");
        s1.displayStudentInfo();

        System.out.println("\nUpdating CGPA...");
        s1.setCGPA(9.2);
        s1.displayStudentInfo();

        System.out.println("\n--------------------------------\n");

        // Create subclass object
        PostgraduateStudent pg = new PostgraduateStudent(201, "Riya", 9.0, "Machine Learning");
        pg.displayPostgraduateInfo();
    }
}

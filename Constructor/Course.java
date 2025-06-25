public class Course {

    // Instance Variables
    private String courseName;
    private int duration; // in weeks or months
    private double fee;

    // Class Variable (Shared across all objects)
    private static String instituteName = "ABC Learning Institute";

    // Constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance Method to display course details
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: ₹" + fee);
        System.out.println("Institute: " + instituteName);
    }

    // Class Method to update the institute name
    public static void updateInstituteName(String newName) {
        instituteName = newName;
        System.out.println("Institute name updated to: " + instituteName);
    }

    // Main method to demonstrate
    public static void main(String[] args) {
        // Creating course objects
        Course c1 = new Course("Java Programming", 8, 5000);
        Course c2 = new Course("Web Development", 12, 7000);

        System.out.println("Before Institute Update:\n");
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();

        // Update institute name
        System.out.println("\nUpdating Institute Name...\n");
        Course.updateInstituteName("TechSkill Academy");

        System.out.println("\nAfter Institute Update:\n");
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
    }
}

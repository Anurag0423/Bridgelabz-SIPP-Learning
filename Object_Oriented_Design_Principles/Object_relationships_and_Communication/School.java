import java.util.ArrayList;

// Course class (associated with multiple students)
class Course {
    private String courseName;
    private ArrayList<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    public void showEnrolledStudents() {
        System.out.println("Course: " + courseName + " - Enrolled Students:");
        for (Student s : enrolledStudents) {
            System.out.println("  - " + s.getName());
        }
    }
}

// Student class (associated with multiple courses)
class Student {
    private String name;
    private ArrayList<Course> enrolledCourses;

    public Student(String name) {
        this.name = name;
        enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.enrollStudent(this);  // two-way association
        }
    }

    public void viewCourses() {
        System.out.println("Student: " + name + " - Enrolled Courses:");
        for (Course c : enrolledCourses) {
            System.out.println("  - " + c.getCourseName());
        }
    }
}

// School class (aggregates students)
class School {
    private String schoolName;
    private ArrayList<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showAllStudents() {
        System.out.println("School: " + schoolName + " - Students:");
        for (Student s : students) {
            System.out.println("  - " + s.getName());
        }
    }
}

// Main class to demonstrate
public class SchoolAssociationDemo {
    public static void main(String[] args) {
        // Create school
        School school = new School("Springfield High");

        // Create students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        // Add students to school (aggregation)
        school.addStudent(alice);
        school.addStudent(bob);

        // Create courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        // Enroll students in courses (association)
        alice.enrollInCourse(math);
        alice.enrollInCourse(science);
        bob.enrollInCourse(math);

        // Display school students
        System.out.println("=== School Students ===");
        school.showAllStudents();

        // Display student courses
        System.out.println("\n=== Student Enrollments ===");
        alice.viewCourses();
        bob.viewCourses();

        // Display course enrollments
        System.out.println("\n=== Course Enrollments ===");
        math.showEnrolledStudents();
        science.showEnrolledStudents();
    }
}

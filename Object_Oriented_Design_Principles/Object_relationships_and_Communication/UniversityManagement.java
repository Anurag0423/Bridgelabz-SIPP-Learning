import java.util.ArrayList;

// Student class
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

    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.addStudent(this);
            System.out.println(name + " enrolled in " + course.getCourseName());
        }
    }

    public void viewCourses() {
        System.out.println("Student: " + name + " - Enrolled Courses:");
        for (Course c : enrolledCourses) {
            System.out.println("  - " + c.getCourseName());
        }
    }
}

// Professor class
class Professor {
    private String name;
    private ArrayList<Course> assignedCourses;

    public Professor(String name) {
        this.name = name;
        assignedCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void assignCourse(Course course) {
        if (!assignedCourses.contains(course)) {
            assignedCourses.add(course);
            course.setProfessor(this);
            System.out.println(name + " assigned to teach " + course.getCourseName());
        }
    }

    public void viewCourses() {
        System.out.println("Professor: " + name + " - Teaching Courses:");
        for (Course c : assignedCourses) {
            System.out.println("  - " + c.getCourseName());
        }
    }
}

// Course class
class Course {
    private String courseName;
    private Professor professor;
    private ArrayList<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("  Professor: " + (professor != null ? professor.getName() : "Not Assigned"));
        System.out.println("  Enrolled Students:");
        for (Student s : students) {
            System.out.println("    - " + s.getName());
        }
    }
}

// University class
class University {
    private String name;
    private ArrayList<Student> students;
    private ArrayList<Professor> professors;
    private ArrayList<Course> courses;

    public University(String name) {
        this.name = name;
        students = new ArrayList<>();
        professors = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayUniversityInfo() {
        System.out.println("University: " + name);
        System.out.println("Students:");
        for (Student s : students) {
            System.out.println("  - " + s.getName());
        }

        System.out.println("Professors:");
        for (Professor p : professors) {
            System.out.println("  - " + p.getName());
        }

        System.out.println("Courses:");
        for (Course c : courses) {
            c.displayCourseDetails();
        }
    }
}

// Main class
public class UniversityManagementSystem {
    public static void main(String[] args) {
        University university = new University("Bharat Institute of Technology");

        // Indian student names
        Student anurag = new Student("Anurag");
        Student ram = new Student("Ram");
        Student shreyash = new Student("Shreyash");

        // Indian professor names
        Professor drVerma = new Professor("Dr. Verma");
        Professor drMishra = new Professor("Dr. Mishra");

        // Courses
        Course dataStructures = new Course("Data Structures");
        Course operatingSystems = new Course("Operating Systems");

        // Aggregation
        university.addStudent(anurag);
        university.addStudent(ram);
        university.addStudent(shreyash);

        university.addProfessor(drVerma);
        university.addProfessor(drMishra);

        university.addCourse(dataStructures);
        university.addCourse(operatingSystems);

        // Associations
        anurag.enrollCourse(dataStructures);
        ram.enrollCourse(dataStructures);
        shreyash.enrollCourse(operatingSystems);

        drVerma.assignCourse(dataStructures);
        drMishra.assignCourse(operatingSystems);

        // Display Info
        System.out.println("\n=== University Info ===");
        university.displayUniversityInfo();
    }
}

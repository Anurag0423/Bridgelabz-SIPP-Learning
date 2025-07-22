import java.util.*;

// Abstract CourseType
abstract class CourseType {
    public abstract String getTypeName();
}

// Subclasses for different course types
class ExamCourse extends CourseType {
    @Override
    public String getTypeName() {
        return "Exam-Based Course";
    }
}

class AssignmentCourse extends CourseType {
    @Override
    public String getTypeName() {
        return "Assignment-Based Course";
    }
}

class ResearchCourse extends CourseType {
    @Override
    public String getTypeName() {
        return "Research-Based Course";
    }
}

// Generic Course class
class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getCourseType() {
        return courseType;
    }
}

// Utility class with wildcard method
class CourseUtils {
    public static void displayCourses(List<? extends CourseType> courseTypes) {
        for (CourseType ct : courseTypes) {
            System.out.println("Course Type: " + ct.getTypeName());
        }
    }

    public static void displayCourseDetails(List<? extends Course<? extends CourseType>> courses) {
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course.getCourseName() + " (" + course.getCourseType().getTypeName() + ")");
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        List<Course<ExamCourse>> examCourses = new ArrayList<>();
        examCourses.add(new Course<>("Mathematics", new ExamCourse()));
        examCourses.add(new Course<>("Physics", new ExamCourse()));

        List<Course<AssignmentCourse>> assignmentCourses = new ArrayList<>();
        assignmentCourses.add(new Course<>("Creative Writing", new AssignmentCourse()));
        assignmentCourses.add(new Course<>("Web Design", new AssignmentCourse()));

        List<Course<ResearchCourse>> researchCourses = new ArrayList<>();
        researchCourses.add(new Course<>("AI Research", new ResearchCourse()));

        // Display all courses using wildcard
        System.out.println("Exam Courses:");
        CourseUtils.displayCourseDetails(examCourses);

        System.out.println("\nAssignment Courses:");
        CourseUtils.displayCourseDetails(assignmentCourses);

        System.out.println("\nResearch Courses:");
        CourseUtils.displayCourseDetails(researchCourses);
    }
}

import java.util.*;

// Abstract class representing a Job Role
abstract class JobRole {
    public abstract String getRoleName();
    public abstract List<String> requiredSkills();
}

// Specific job roles
class SoftwareEngineer extends JobRole {
    @Override
    public String getRoleName() {
        return "Software Engineer";
    }

    @Override
    public List<String> requiredSkills() {
        return Arrays.asList("Java", "Data Structures", "Algorithms");
    }
}

class DataScientist extends JobRole {
    @Override
    public String getRoleName() {
        return "Data Scientist";
    }

    @Override
    public List<String> requiredSkills() {
        return Arrays.asList("Python", "Machine Learning", "Statistics");
    }
}

class ProductManager extends JobRole {
    @Override
    public String getRoleName() {
        return "Product Manager";
    }

    @Override
    public List<String> requiredSkills() {
        return Arrays.asList("Communication", "Product Strategy", "Agile");
    }
}

// Generic Resume class
class Resume<T extends JobRole> {
    private String candidateName;
    private List<String> candidateSkills;
    private T jobRole;

    public Resume(String candidateName, List<String> candidateSkills, T jobRole) {
        this.candidateName = candidateName;
        this.candidateSkills = candidateSkills;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public List<String> getCandidateSkills() {
        return candidateSkills;
    }

    public T getJobRole() {
        return jobRole;
    }
}

// Resume screening utility
class ResumeScreeningSystem {
    public static <T extends JobRole> boolean screenCandidate(Resume<T> resume) {
        List<String> required = resume.getJobRole().requiredSkills();
        List<String> actual = resume.getCandidateSkills();
        return actual.containsAll(required);
    }

    // Wildcard method to display resumes of any job role
    public static void displayResumes(List<? extends Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> r : resumes) {
            System.out.println("Candidate: " + r.getCandidateName() +
                    " | Role: " + r.getJobRole().getRoleName());
        }
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> r1 = new Resume<>(
                "Alice",
                Arrays.asList("Java", "Data Structures", "Algorithms"),
                new SoftwareEngineer()
        );

        Resume<DataScientist> r2 = new Resume<>(
                "Bob",
                Arrays.asList("Python", "Machine Learning", "SQL"),
                new DataScientist()
        );

        Resume<ProductManager> r3 = new Resume<>(
                "Carol",
                Arrays.asList("Communication", "Agile", "Design Thinking"),
                new ProductManager()
        );

        // Screen candidates
        System.out.println("Alice passed? " + ResumeScreeningSystem.screenCandidate(r1));
        System.out.println("Bob passed? " + ResumeScreeningSystem.screenCandidate(r2));
        System.out.println("Carol passed? " + ResumeScreeningSystem.screenCandidate(r3));

        System.out.println("\nAll Resumes:");
        List<Resume<? extends JobRole>> allResumes = Arrays.asList(r1, r2, r3);
        ResumeScreeningSystem.displayResumes(allResumes);
    }
}

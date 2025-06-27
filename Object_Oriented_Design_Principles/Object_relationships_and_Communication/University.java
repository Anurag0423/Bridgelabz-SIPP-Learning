import java.util.ArrayList;

// Faculty class (can exist independently of departments)
class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public void displayFaculty() {
        System.out.println("Faculty: " + name);
    }

    public String getName() {
        return name;
    }
}

// Department class (part of University - composition)
class Department {
    private String deptName;
    private ArrayList<Faculty> facultyList;

    public Department(String deptName) {
        this.deptName = deptName;
        facultyList = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        if (!facultyList.contains(faculty)) {
            facultyList.add(faculty);
        }
    }

    public void displayDepartment() {
        System.out.println("Department: " + deptName);
        if (facultyList.isEmpty()) {
            System.out.println("  No faculty assigned yet.");
        } else {
            for (Faculty f : facultyList) {
                System.out.println("  - " + f.getName());
            }
        }
    }
}

// University class
class University {
    private String universityName;
    private ArrayList<Department> departments;
    private ArrayList<Faculty> facultyPool; // Aggregated list of faculty

    public University(String universityName) {
        this.universityName = universityName;
        departments = new ArrayList<>();
        facultyPool = new ArrayList<>();
    }

    // Composition: Department cannot exist without university
    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    // Aggregation: Faculty exists independently
    public void addFaculty(Faculty faculty) {
        facultyPool.add(faculty);
    }

    public void assignFacultyToDepartment(String deptName, Faculty faculty) {
        for (Department d : departments) {
            if (d.deptName.equals(deptName)) {
                d.addFaculty(faculty);
                return;
            }
        }
        System.out.println("Department " + deptName + " not found.");
    }

    public void displayUniversityStructure() {
        System.out.println("University: " + universityName);
        System.out.println("Departments and Assigned Faculty:");
        for (Department d : departments) {
            d.displayDepartment();
        }

        System.out.println("\nAll Faculty in University (Aggregated):");
        for (Faculty f : facultyPool) {
            f.displayFaculty();
        }
    }

    // Simulated delete: clear everything
    public void deleteUniversity() {
        departments.clear();
        facultyPool.clear(); // Optional: you can skip this to show faculty outlives the university
        System.out.println("University '" + universityName + "' and its departments have been deleted.");
    }
}

// Main class
public class UniversityDemo {
    public static void main(String[] args) {
        // Create a university
        University uni = new University("Global Tech University");

        // Add departments (composition)
        uni.addDepartment("Computer Science");
        uni.addDepartment("Electrical Engineering");

        // Create faculty (aggregation)
        Faculty alice = new Faculty("Dr. Alice");
        Faculty bob = new Faculty("Prof. Bob");
        Faculty charlie = new Faculty("Dr. Charlie");

        uni.addFaculty(alice);
        uni.addFaculty(bob);
        uni.addFaculty(charlie);

        // Assign faculty to departments
        uni.assignFacultyToDepartment("Computer Science", alice);
        uni.assignFacultyToDepartment("Electrical Engineering", bob);

        // Display full structure
        System.out.println("=== University Structure ===");
        uni.displayUniversityStructure();

        // Delete the university (composition effect)
        System.out.println("\n=== Deleting University ===");
        uni.deleteUniversity();
    }
}

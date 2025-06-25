public class Patient {
    // 1. Static: shared hospital name and total patient count
    static String hospitalName = "City Care Hospital";
    private static int totalPatients = 0;

    public static int getTotalPatients() {
        return totalPatients;
    }

    // 2. Final: patient ID is immutable
    private final String patientID;

    // Instance variables
    private String name;
    private int age;
    private String ailment;

    // 3. Constructor using 'this'
    public Patient(String patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    // 4. Display method using instanceof
    public void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("\n--- Patient Details ---");
            System.out.println("Hospital Name : " + hospitalName);
            System.out.println("Patient ID    : " + patientID);
            System.out.println("Name          : " + name);
            System.out.println("Age           : " + age);
            System.out.println("Ailment       : " + ailment);
        } else {
            System.out.println("Invalid Patient object.");
        }
    }

    // Main method to test the Patient class
    public static void main(String[] args) {
        // Create Patient objects
        Patient p1 = new Patient("PAT001", "Anurag Bhardwaj", 25, "Flu");
        Patient p2 = new Patient("PAT002", "Riya Sharma", 30, "Fever");

        // Display details
        p1.displayDetails();
        p2.displayDetails();

        // Display total patients
        System.out.println("\nTotal Patients Admitted: " + Patient.getTotalPatients());
    }
}

import java.util.ArrayList;

// Patient class
class Patient {
    private String name;
    private ArrayList<Doctor> consultedDoctors;

    public Patient(String name) {
        this.name = name;
        consultedDoctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        if (!consultedDoctors.contains(doctor)) {
            consultedDoctors.add(doctor);
        }
    }

    public void viewConsultedDoctors() {
        System.out.println("Patient: " + name + " has consulted:");
        for (Doctor d : consultedDoctors) {
            System.out.println("  - Dr. " + d.getName());
        }
    }
}

// Doctor class
class Doctor {
    private String name;
    private ArrayList<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Communication: Doctor consults a patient
    public void consult(Patient patient) {
        System.out.println("Dr. " + name + " is consulting Patient: " + patient.getName());

        // Maintain two-way association
        if (!patients.contains(patient)) {
            patients.add(patient);
        }

        patient.addDoctor(this);
    }

    public void viewPatients() {
        System.out.println("Dr. " + name + " has consulted:");
        for (Patient p : patients) {
            System.out.println("  - " + p.getName());
        }
    }
}

// Hospital class
class Hospital {
    private String name;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void displayDoctors() {
        System.out.println("Doctors at " + name + ":");
        for (Doctor d : doctors) {
            System.out.println("  - Dr. " + d.getName());
        }
    }

    public void displayPatients() {
        System.out.println("Patients at " + name + ":");
        for (Patient p : patients) {
            System.out.println("  - " + p.getName());
        }
    }
}

// Main class
public class HospitalAssociationDemo {
    public static void main(String[] args) {
        // Create a hospital
        Hospital hospital = new Hospital("City Hospital");

        // Create doctors
        Doctor drSmith = new Doctor("Smith");
        Doctor drJones = new Doctor("Jones");

        // Create patients
        Patient john = new Patient("John");
        Patient emily = new Patient("Emily");

        // Add to hospital
        hospital.addDoctor(drSmith);
        hospital.addDoctor(drJones);
        hospital.addPatient(john);
        hospital.addPatient(emily);

        // Consultations
        drSmith.consult(john);
        drSmith.consult(emily);
        drJones.consult(john);

        // Display hospital data
        System.out.println("\n=== Hospital Records ===");
        hospital.displayDoctors();
        hospital.displayPatients();

        System.out.println("\n=== Doctor Records ===");
        drSmith.viewPatients();
        drJones.viewPatients();

        System.out.println("\n=== Patient Records ===");
        john.viewConsultedDoctors();
        emily.viewConsultedDoctors();
    }
}

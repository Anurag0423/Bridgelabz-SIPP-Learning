import java.util.ArrayList;
import java.util.List;

// Interface for medical records
interface MedicalRecord {
    void addRecord(String entry);
    void viewRecords();
}

// Abstract class Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;
    private List<String> medicalHistory;

    // Constructor
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = new ArrayList<>();
    }

    // Getters
    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    // Encapsulation for sensitive data
    protected void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMaskedDiagnosis() {
        return (diagnosis == null || diagnosis.isEmpty()) ? "Not Available" : diagnosis.charAt(0) + "****";
    }

    public void addToMedicalHistory(String record) {
        medicalHistory.add(record);
    }

    public List<String> getMedicalHistory() {
        return new ArrayList<>(medicalHistory); // return a copy to protect original list
    }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID : " + patientId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Diagnosis  : " + getMaskedDiagnosis());
        System.out.println("Medical History: " + medicalHistory.size() + " entries");
    }
}

// InPatient subclass
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double roomChargePerDay;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double roomChargePerDay) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.roomChargePerDay = roomChargePerDay;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * roomChargePerDay;
    }

    @Override
    public void addRecord(String entry) {
        addToMedicalHistory("InPatient: " + entry);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History for " + getName() + ":");
        for (String record : getMedicalHistory()) {
            System.out.println("- " + record);
        }
    }
}

// OutPatient subclass
class OutPatient extends Patient implements MedicalRecord {
    private int visits;
    private double consultationFee;

    public OutPatient(String patientId, String name, int age, int visits, double consultationFee) {
        super(patientId, name, age);
        this.visits = visits;
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return visits * consultationFee;
    }

    @Override
    public void addRecord(String entry) {
        addToMedicalHistory("OutPatient: " + entry);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History for " + getName() + ":");
        for (String record : getMedicalHistory()) {
            System.out.println("- " + record);
        }
    }
}

// Main class
public class HospitalSystem {
    public static void processPatient(Patient p) {
        p.getPatientDetails();
        System.out.println("Total Bill : ₹" + p.calculateBill());

        if (p instanceof MedicalRecord) {
            ((MedicalRecord)p).viewRecords();
        }
        System.out.println("------------------------------------------");
    }

    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient ip = new InPatient("P101", "Amit Sharma", 45, 5, 2000);
        ip.setDiagnosis("Pneumonia");
        ip.addRecord("Admitted to general ward");
        ip.addRecord("Prescribed antibiotics");

        OutPatient op = new OutPatient("P202", "Neha Verma", 30, 3, 500);
        op.setDiagnosis("Migraine");
        op.addRecord("Consulted neurology");
        op.addRecord("Recommended MRI scan");

        patients.add(ip);
        patients.add(op);

        System.out.println("------ Hospital Patient Billing Report ------\n");
        for (Patient p : patients) {
            processPatient(p); // Polymorphism in action
        }
    }
}

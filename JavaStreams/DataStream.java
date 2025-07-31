import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {
        String fileName = "student_data.dat";

        // 1. Store student data in binary file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101);  // Roll number
            dos.writeUTF("John Doe");  // Name
            dos.writeDouble(3.75);  // GPA

            dos.writeInt(102);  // Another student's data
            dos.writeUTF("Jane Smith");
            dos.writeDouble(3.9);

            System.out.println(" Student data written to file: " + fileName);
        } catch (IOException e) {
            System.out.println(" Error writing to file: " + e.getMessage());
        }

        // 2. Retrieve student data from binary file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (dis.available() > 0) {
                int rollNo = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll Number: " + rollNo + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println(" Error reading from file: " + e.getMessage());
        }
    }
}

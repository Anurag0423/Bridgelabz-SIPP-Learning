import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File source = new File("source.txt");
            File dest = new File("destination.txt");

            if (!source.exists()) {
                System.out.println("Source file does not exist.");
                return;
            }

            fis = new FileInputStream(source);
            fos = new FileOutputStream(dest);

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }
}

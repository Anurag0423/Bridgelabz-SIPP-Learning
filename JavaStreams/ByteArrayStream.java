import java.io.*;

public class ImageByteArrayConverter {
    public static void main(String[] args) {
        String inputImagePath = "original.jpg";
        String outputImagePath = "copy.jpg";

        try {
            // Step 1: Read original image into byte array
            FileInputStream fis = new FileInputStream(inputImagePath);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            fis.close();
            byte[] imageBytes = baos.toByteArray();

            // Step 2: Write byte array to new image file
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(outputImagePath);

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            fos.close();
            bais.close();

            System.out.println("✅ Image copied using byte array stream successfully.");

        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}

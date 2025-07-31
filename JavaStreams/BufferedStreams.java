import java.io.*;

public class BufferedFile {
    public static void main(String[] args) {
        String sourcePath = "largefile.dat";
        String destBuffered = "copy_buffered.dat";
        String destUnbuffered = "copy_unbuffered.dat";

        // Buffered copy
        long startBuffered = System.nanoTime();
        copyUsingBufferedStreams(sourcePath, destBuffered);
        long endBuffered = System.nanoTime();
        System.out.println("Buffered Copy Time: " + (endBuffered - startBuffered) / 1_000_000 + " ms");

        // Unbuffered copy
        long startUnbuffered = System.nanoTime();
        copyUsingUnbufferedStreams(sourcePath, destUnbuffered);
        long endUnbuffered = System.nanoTime();
        System.out.println("Unbuffered Copy Time: " + (endUnbuffered - startUnbuffered) / 1_000_000 + " ms");
    }

    // Buffered copy
    public static void copyUsingBufferedStreams(String source, String dest) {
        try (
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))
        ) {
            byte[] buffer = new byte[4096]; // 4 KB chunks
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Buffered Error: " + e.getMessage());
        }
    }

    // Unbuffered copy
    public static void copyUsingUnbufferedStreams(String source, String dest) {
        try (
            FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(dest)
        ) {
            byte[] buffer = new byte[4096]; // 4 KB chunks
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Unbuffered Error: " + e.getMessage());
        }
    }
}

import java.io.*;

public class PipedStream {
    public static void main(String[] args) throws IOException {
        // Create piped input and output streams
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos); // Connect streams

        // Writer Thread
        Thread writerThread = new Thread(() -> {
            try {
                String message = "Hello from the writer thread!";
                pos.write(message.getBytes());
                pos.close();
            } catch (IOException e) {
                System.out.println(" Writer error: " + e.getMessage());
            }
        });

        // Reader Thread
        Thread readerThread = new Thread(() -> {
            try {
                int data;
                System.out.print("Reader received: ");
                while ((data = pis.read()) != -1) {
                    System.out.print((char) data);
                }
                pis.close();
            } catch (IOException e) {
                System.out.println(" Reader error: " + e.getMessage());
            }
        });

        // Start both threads
        writerThread.start();
        readerThread.start();
    }
}

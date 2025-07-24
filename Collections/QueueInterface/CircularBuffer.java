import java.util.*;

public class CircularBuffer {
    private int[] buffer;
    private int head = 0;
    private int size = 0;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
    }

    public void insert(int value) {
        buffer[head] = value;
        head = (head + 1) % capacity;

        if (size < capacity) {
            size++;
        }
    }

    public void printBuffer() {
        System.out.print("Circular Buffer: [");
        for (int i = 0; i < size; i++) {
            int index = (head + i) % capacity;
            System.out.print(buffer[index]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.insert(4); // Overwrites 1

        cb.printBuffer(); // Should print [2, 3, 4]
    }
}

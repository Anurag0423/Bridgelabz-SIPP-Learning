import java.util.*;

public class ReverseQueue {

    // Recursive method to reverse a queue
    public static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty()) return;

        int front = queue.remove(); // Remove front
        reverse(queue);             // Reverse remaining queue
        queue.add(front);           // Add element back at the rear
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);
        reverse(queue);
        System.out.println("Reversed Queue: " + queue);
    }
}

import java.util.*;

public class NthFromEnd {

    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();

        // Move 'first' pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (first.hasNext()) {
                first.next();
            } else {
                return null; // n is larger than the list size
            }
        }

        // Move both iterators until 'first' reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next(); // This is the N-th from end
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int N = 2;

        String result = findNthFromEnd(list, N);
        System.out.println(N + "th element from the end: " + result);
    }
}

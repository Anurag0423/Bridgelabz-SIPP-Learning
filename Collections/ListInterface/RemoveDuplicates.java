import java.util.*;

public class RemoveDuplicates {

    public static <T> List<T> removeDuplicatesPreserveOrder(List<T> list) {
        Set<T> seen = new LinkedHashSet<>();

        for (T item : list) {
            seen.add(item); // LinkedHashSet maintains order
        }

        return new ArrayList<>(seen); // return as List
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3, 1, 2, 2, 3, 4);

        List<Integer> result = removeDuplicatesPreserveOrder(input);

        System.out.println("List without duplicates: " + result);
    }
}

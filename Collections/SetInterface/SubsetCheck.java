import java.util.*;

public class SubsetCheck {

    public static <T> boolean isSubset(Set<T> subset, Set<T> superset) {
        return superset.containsAll(subset);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        boolean result = isSubset(set1, set2);

        System.out.println("Is set1 a subset of set2? " + result);
    }
}

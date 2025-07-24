import java.util.*;

public class SetToSortedList {

    public static List<Integer> convertAndSortSet(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList); // sort in ascending order
        return sortedList;
    }

    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        List<Integer> sortedList = convertAndSortSet(hashSet);

        System.out.println("Sorted List: " + sortedList);
    }
}

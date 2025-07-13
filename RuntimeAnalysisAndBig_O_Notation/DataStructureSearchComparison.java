import java.util.*;
//6. Problem Statement: Comparing Different Data Structures for Searching
public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        int target = -1; // Not present in data (worst-case search)

        for (int size : sizes) {
            System.out.println("\nDataset Size: " + size);
            int[] array = generateData(size);
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int num : array) {
                hashSet.add(num);
                treeSet.add(num);
            }

            // Array search (O(N))
            long startArray = System.nanoTime();
            boolean foundInArray = false;
            for (int num : array) {
                if (num == target) {
                    foundInArray = true;
                    break;
                }
            }
            long endArray = System.nanoTime();

            // HashSet search (O(1))
            long startHashSet = System.nanoTime();
            boolean foundInHash = hashSet.contains(target);
            long endHashSet = System.nanoTime();

            // TreeSet search (O(log N))
            long startTreeSet = System.nanoTime();
            boolean foundInTree = treeSet.contains(target);
            long endTreeSet = System.nanoTime();

            // Results
            System.out.println("Array Search Time:   " + (endArray - startArray) / 1_000_000.0 + " ms");
            System.out.println("HashSet Search Time: " + (endHashSet - startHashSet) / 1_000_000.0 + " ms");
            System.out.println("TreeSet Search Time: " + (endTreeSet - startTreeSet) / 1_000_000.0 + " ms");
        }
    }

    public static int[] generateData(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i;
        return arr;
    }
}

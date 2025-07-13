import java.util.*;
//FirstLastOccurrence
public class BinarySearchProblem4 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 4, 5, 6, 7};
        int target = 4;

        int first = findFirst(arr, target);
        int last = findLast(arr, target);

        System.out.println("First occurrence: " + first);
        System.out.println("Last occurrence: " + last);
    }

    // Find first occurrence using binary search
    public static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // Keep searching left
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // Find last occurrence using binary search
    public static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // Keep searching right
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}

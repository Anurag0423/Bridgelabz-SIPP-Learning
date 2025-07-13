import java.util.Arrays;

public class ChallengeSearch {
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int target = 4;

        int missing = findFirstMissingPositive(arr.clone());
        System.out.println("First missing positive: " + missing);

        Arrays.sort(arr); // Binary Search requires sorted array
        int index = binarySearch(arr, target);
        System.out.println("Index of target " + target + ": " + index);
    }

    // Linear Search for first missing positive
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Place each number at its correct index (e.g., 1 at index 0)
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int correctIndex = nums[i] - 1;
                // Swap nums[i] with nums[correctIndex]
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // First index i where nums[i] != i + 1 → that's the missing number
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    // Binary Search for target index
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }
}

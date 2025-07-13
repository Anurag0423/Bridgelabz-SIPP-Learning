
//FindPeakElement
public class BinarySearchProblem2 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 20, 4, 1, 0};  // Example array with a peak at index 2 (20)
        int peakIndex = findPeak(nums);
        System.out.println("Peak element: " + nums[peakIndex] + " at index: " + peakIndex);
    }

    // Method to find a peak element using binary search
    public static int findPeak(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean isLeftSmaller = (mid == 0) || (arr[mid] > arr[mid - 1]);
            boolean isRightSmaller = (mid == arr.length - 1) || (arr[mid] > arr[mid + 1]);

            // If current element is a peak
            if (isLeftSmaller && isRightSmaller) {
                return mid;
            }
            // Move to the left half
            else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }
            // Move to the right half
            else {
                left = mid + 1;
            }
        }

        return -1; // Should never reach here for a non-empty array
    }
}

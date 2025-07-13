import java.util.*;
//FindRotationPoint
public class BinarySearchProblem1 {
    public static void main(String[] args) {
        int[] rotatedArray = {15, 18, 2, 3, 6, 12}; // Sample input
        int index = findRotationPoint(rotatedArray);
        System.out.println("Index of rotation point (smallest element): " + index);
        System.out.println("Smallest element: " + rotatedArray[index]);
    }

    // Method to find the index of the smallest element using binary search
    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than right, rotation point is in right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }
            // Else, it's in the left half (including mid)
            else {
                right = mid;
            }
        }

        return left; // or right; both will be pointing to the smallest element
    }
}

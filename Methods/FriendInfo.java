import java.util.Scanner;

class FriendInfo {

    public static int findYoungestIndex(int[] ages) {
        int minIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int findTallestIndex(int[] heights) {
        int maxIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[3];
        int[] heights = new int[3];
        String[] names = {"Amar", "Akbar", "Anthony"};

        for (int i = 0; i < 3; i++) {
            ages[i] = sc.nextInt();
            heights[i] = sc.nextInt();
        }

        int youngestIndex = findYoungestIndex(ages);
        int tallestIndex = findTallestIndex(heights);

        System.out.println("Youngest: " + names[youngestIndex]);
        System.out.println("Tallest: " + names[tallestIndex]);

        sc.close();
    }
}

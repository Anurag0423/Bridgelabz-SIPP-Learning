import java.util.*;

public class RotateList {

    public static <T> void rotateList(List<T> list, int positions) {
        int size = list.size();
        positions = positions % size; // to handle if positions > size

        List<T> rotated = new ArrayList<>();

        // Add elements from positions to end
        for (int i = positions; i < size; i++) {
            rotated.add(list.get(i));
        }

        // Add elements from start to positions
        for (int i = 0; i < positions; i++) {
            rotated.add(list.get(i));
        }

        // Clear original and add all rotated elements back
        list.clear();
        list.addAll(rotated);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));

        int rotateBy = 2;
        rotateList(numbers, rotateBy);

        System.out.println("Rotated List by " + rotateBy + ": " + numbers);
    }
}

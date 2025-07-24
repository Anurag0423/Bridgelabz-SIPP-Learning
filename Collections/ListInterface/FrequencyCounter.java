import java.util.*;

public class FrequencyCounter {

    public static Map<String, Integer> findFrequencies(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }

        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange");

        Map<String, Integer> result = findFrequencies(input);

        System.out.println("Frequencies: " + result);
    }
}

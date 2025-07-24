import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {
        // 1. HashMap to store candidate and vote count
        Map<String, Integer> voteMap = new HashMap<>();

        // 2. LinkedHashMap to track order of first vote for each candidate
        Map<String, Integer> linkedVoteMap = new LinkedHashMap<>();

        // Simulate voting
        String[] votes = {"Alice", "Bob", "Alice", "David", "Bob", "Alice", "Carol"};

        for (String candidate : votes) {
            // HashMap: count total votes
            voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);

            // LinkedHashMap: insert only if first vote
            linkedVoteMap.putIfAbsent(candidate, voteMap.get(candidate));
        }

        // 3. TreeMap to display sorted results (by candidate name)
        Map<String, Integer> sortedVoteMap = new TreeMap<>(voteMap);

        // Output all results
        System.out.println("1. HashMap (Vote Count):");
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\n2. LinkedHashMap (First Vote Order):");
        for (Map.Entry<String, Integer> entry : linkedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + " -> First Vote at Count " + entry.getValue());
        }

        System.out.println("\n3. TreeMap (Sorted by Candidate Name):");
        for (Map.Entry<String, Integer> entry : sortedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

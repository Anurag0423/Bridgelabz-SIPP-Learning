import java.util.*;

class SocialNetwork {
    private Map<String, List<String>> graph = new HashMap<>();

    // Add friendship (undirected)
    public void addFriendship(String person1, String person2) {
        graph.putIfAbsent(person1, new ArrayList<>());
        graph.putIfAbsent(person2, new ArrayList<>());
        graph.get(person1).add(person2);
        graph.get(person2).add(person1);
    }

    // Suggest friends of friends
    public Set<String> suggestFriends(String person) {
        Set<String> suggestions = new HashSet<>();
        Set<String> directFriends = new HashSet<>(graph.getOrDefault(person, new ArrayList<>()));
        directFriends.add(person); // avoid suggesting self

        for (String friend : graph.getOrDefault(person, new ArrayList<>())) {
            for (String friendOfFriend : graph.getOrDefault(friend, new ArrayList<>())) {
                if (!directFriends.contains(friendOfFriend)) {
                    suggestions.add(friendOfFriend);
                }
            }
        }

        return suggestions;
    }
}

// Demo
public class SocialNetworkApp {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();
        network.addFriendship("Alice", "Bob");
        network.addFriendship("Bob", "Charlie");
        network.addFriendship("Bob", "David");
        network.addFriendship("Charlie", "Eve");
        network.addFriendship("David", "Frank");

        System.out.println("Friend suggestions for Alice: " + network.suggestFriends("Alice"));
        System.out.println("Friend suggestions for Bob: " + network.suggestFriends("Bob"));
    }
}

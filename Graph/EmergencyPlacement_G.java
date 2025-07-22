import java.util.*;

class EmergencyPlacement {
    private Map<String, List<String>> graph = new HashMap<>();

    public void addRoad(String a, String b) {
        graph.putIfAbsent(a, new ArrayList<>());
        graph.putIfAbsent(b, new ArrayList<>());
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    public Set<String> placeAmbulances() {
        Set<String> covered = new HashSet<>();
        Set<String> ambulances = new HashSet<>();

        Set<String> allNodes = new HashSet<>(graph.keySet());

        while (covered.size() < allNodes.size()) {
            String best = null;
            int maxCover = -1;

            for (String node : allNodes) {
                if (covered.contains(node)) continue;

                int count = 1; // itself
                for (String neighbor : graph.get(node)) {
                    if (!covered.contains(neighbor)) count++;
                }

                if (count > maxCover) {
                    maxCover = count;
                    best = node;
                }
            }

            ambulances.add(best);
            covered.add(best);
            covered.addAll(graph.get(best));
        }

        return ambulances;
    }
}

// Demo
public class EmergencyServicesApp {
    public static void main(String[] args) {
        EmergencyPlacement city = new EmergencyPlacement();
        city.addRoad("A", "B");
        city.addRoad("A", "C");
        city.addRoad("C", "D");
        city.addRoad("E", "F");

        Set<String> ambulances = city.placeAmbulances();
        System.out.println("Place ambulances at: " + ambulances);
    }
}

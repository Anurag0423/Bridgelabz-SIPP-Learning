import java.util.*;

class PowerGrid {
    private Map<String, List<String>> graph = new HashMap<>();

    // Add a wire connection (undirected)
    public void connect(String city1, String city2) {
        graph.putIfAbsent(city1, new ArrayList<>());
        graph.putIfAbsent(city2, new ArrayList<>());
        graph.get(city1).add(city2);
        graph.get(city2).add(city1);
    }

    // Count cities affected if blackout starts from 'startCity'
    public Set<String> affectedCities(String startCity) {
        Set<String> affected = new HashSet<>();
        dfs(startCity, affected);
        return affected;
    }

    // Check if grid is fully connected
    public boolean isFullyConnected() {
        if (graph.isEmpty()) return true;
        Set<String> visited = new HashSet<>();
        String anyCity = graph.keySet().iterator().next();
        dfs(anyCity, visited);
        return visited.size() == graph.size();
    }

    private void dfs(String city, Set<String> visited) {
        visited.add(city);
        for (String neighbor : graph.getOrDefault(city, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }
}

// Demo
public class PowerGridApp {
    public static void main(String[] args) {
        PowerGrid grid = new PowerGrid();
        grid.connect("A", "B");
        grid.connect("B", "C");
        grid.connect("C", "D");
        grid.connect("E", "F"); // Disconnected component

        System.out.println("Affected cities from A: " + grid.affectedCities("A"));
        System.out.println("Is the power grid fully connected? " + grid.isFullyConnected());
    }
}

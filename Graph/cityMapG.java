import java.util.*;

class CityMap {
    private Map<Integer, List<Integer>> graph = new HashMap<>();

    // Add a directed road
    public void addRoad(int from, int to) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from).add(to);
    }

    // Shortest path using BFS (unweighted graph)
    public List<Integer> shortestPath(int start, int end) {
        Map<Integer, Integer> parent = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);
        parent.put(start, null);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == end) break;

            for (int neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                    parent.put(neighbor, curr);
                }
            }
        }

        // Reconstruct path
        List<Integer> path = new ArrayList<>();
        if (!parent.containsKey(end)) return path; // no path

        for (Integer at = end; at != null; at = parent.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    // Check if all nodes are reachable from source (BFS)
    public boolean isFullyReachable(int source) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return visited.size() == graph.size();
    }
}

// Demo
public class CityNavigationApp {
    public static void main(String[] args) {
        CityMap city = new CityMap();
        city.addRoad(1, 2);
        city.addRoad(2, 3);
        city.addRoad(3, 4);
        city.addRoad(1, 5);

        System.out.println("Shortest Path from 1 to 4: " + city.shortestPath(1, 4));
        System.out.println("Is city fully reachable from 1? " + city.isFullyReachable(1));
    }
}

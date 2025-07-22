import java.util.*;

// Edge class to store destination and cost
class Edge {
    String to;
    int cost;
    public Edge(String to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

class FlightGraph {
    private Map<String, List<Edge>> graph = new HashMap<>();

    // Add a directed flight with cost
    public void addFlight(String from, String to, int cost) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from).add(new Edge(to, cost));
    }

    // Dijkstra: Find cheapest path from source to destination
    public int findCheapestPath(String source, String dest) {
        Map<String, Integer> dist = new HashMap<>();
        for (String node : graph.keySet()) dist.put(node, Integer.MAX_VALUE);
        dist.put(source, 0);

        PriorityQueue<Map.Entry<String, Integer>> pq =
            new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.offer(new AbstractMap.SimpleEntry<>(source, 0));

        while (!pq.isEmpty()) {
            var curr = pq.poll();
            String node = curr.getKey();
            int costSoFar = curr.getValue();

            if (node.equals(dest)) return costSoFar;

            for (Edge edge : graph.getOrDefault(node, new ArrayList<>())) {
                int newCost = costSoFar + edge.cost;
                if (newCost < dist.getOrDefault(edge.to, Integer.MAX_VALUE)) {
                    dist.put(edge.to, newCost);
                    pq.offer(new AbstractMap.SimpleEntry<>(edge.to, newCost));
                }
            }
        }

        return -1; // not reachable
    }

    // BFS to check reachability from a city
    public boolean isAllReachable(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            for (Edge edge : graph.getOrDefault(curr, new ArrayList<>())) {
                if (!visited.contains(edge.to)) {
                    visited.add(edge.to);
                    queue.offer(edge.to);
                }
            }
        }

        return visited.size() == graph.size();
    }
}

// Demo
public class FlightConnectionApp {
    public static void main(String[] args) {
        FlightGraph flights = new FlightGraph();
        flights.addFlight("Delhi", "Mumbai", 5000);
        flights.addFlight("Mumbai", "Chennai", 4000);
        flights.addFlight("Delhi", "Chennai", 10000);
        flights.addFlight("Chennai", "Kolkata", 3000);

        System.out.println("Cheapest cost from Delhi to Chennai: " +
            flights.findCheapestPath("Delhi", "Chennai")); // 9000

        System.out.println("Can reach all cities from Delhi? " +
            flights.isAllReachable("Delhi")); // true
    }
}

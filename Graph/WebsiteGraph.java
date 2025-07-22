import java.util.*;

class WebsiteGraph {
    private Map<String, List<String>> graph = new HashMap<>();

    // Add a one-way link (directed)
    public void addLink(String from, String to) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from).add(to);
    }

    // Check reachability from homepage
    public boolean isFullyReachable(String start) {
        Set<String> visited = new HashSet<>();
        dfs(start, visited);
        return visited.size() == graph.size();
    }

    // Detect cycle using DFS with recursion stack
    public boolean hasCycle() {
        Set<String> visited = new HashSet<>();
        Set<String> recStack = new HashSet<>();

        for (String page : graph.keySet()) {
            if (!visited.contains(page)) {
                if (dfsCycle(page, visited, recStack)) return true;
            }
        }
        return false;
    }

    // DFS for reachability
    private void dfs(String node, Set<String> visited) {
        visited.add(node);
        for (String neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }

    // DFS for cycle detection
    private boolean dfsCycle(String node, Set<String> visited, Set<String> recStack) {
        visited.add(node);
        recStack.add(node);

        for (String neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor) && dfsCycle(neighbor, visited, recStack))
                return true;
            else if (recStack.contains(neighbor))
                return true;
        }

        recStack.remove(node);
        return false;
    }
}

// Demo
public class WebsiteAnalyzerApp {
    public static void main(String[] args) {
        WebsiteGraph web = new WebsiteGraph();

        web.addLink("Home", "About");
        web.addLink("About", "Contact");
        web.addLink("Contact", "Help");
        web.addLink("Help", "Home"); // cycle here

        System.out.println("All pages reachable from Home? " + web.isFullyReachable("Home"));
        System.out.println("Website has cycle? " + web.hasCycle());
    }
}

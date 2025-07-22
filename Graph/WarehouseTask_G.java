import java.util.*;

class TaskScheduler {
    private Map<String, List<String>> graph = new HashMap<>();

    // Add dependency: A must be done before B (A → B)
    public void addDependency(String before, String after) {
        graph.putIfAbsent(before, new ArrayList<>());
        graph.putIfAbsent(after, new ArrayList<>());
        graph.get(before).add(after);
    }

    // Topological Sort using DFS
    public List<String> getTaskOrder() {
        Set<String> visited = new HashSet<>();
        Set<String> recStack = new HashSet<>();
        Stack<String> stack = new Stack<>();

        for (String task : graph.keySet()) {
            if (!visited.contains(task)) {
                if (dfs(task, visited, recStack, stack)) {
                    return null; // cycle detected
                }
            }
        }

        List<String> order = new ArrayList<>();
        while (!stack.isEmpty()) {
            order.add(stack.pop());
        }
        return order;
    }

    // Return true if cycle is detected
    private boolean dfs(String node, Set<String> visited, Set<String> recStack, Stack<String> stack) {
        visited.add(node);
        recStack.add(node);

        for (String neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, visited, recStack, stack)) return true;
            } else if (recStack.contains(neighbor)) {
                return true; // cycle detected
            }
        }

        recStack.remove(node);
        stack.push(node);
        return false;
    }
}

// Demo
public class WarehouseTaskApp {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addDependency("Unload", "Sort");
        scheduler.addDependency("Sort", "Pack");
        scheduler.addDependency("Pack", "Ship");

        List<String> order = scheduler.getTaskOrder();
        if (order == null) {
            System.out.println("Cycle detected! Invalid task dependencies.");
        } else {
            System.out.println("Valid task order: " + order);
        }
    }
}

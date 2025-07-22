import java.util.*;

class CoursePlanner {
    private Map<String, List<String>> graph = new HashMap<>();

    // Add prerequisite: A → B means A must be done before B
    public void addPrerequisite(String prereq, String course) {
        graph.putIfAbsent(prereq, new ArrayList<>());
        graph.putIfAbsent(course, new ArrayList<>());
        graph.get(prereq).add(course);
    }

    // Get valid order or detect cycle
    public List<String> getCourseOrder() {
        Set<String> visited = new HashSet<>();
        Set<String> recStack = new HashSet<>();
        Stack<String> order = new Stack<>();

        for (String course : graph.keySet()) {
            if (!visited.contains(course)) {
                if (dfs(course, visited, recStack, order)) {
                    return null; // cycle found
                }
            }
        }

        List<String> result = new ArrayList<>();
        while (!order.isEmpty()) result.add(order.pop());
        return result;
    }

    // DFS for cycle detection and topological sorting
    private boolean dfs(String course, Set<String> visited, Set<String> recStack, Stack<String> order) {
        visited.add(course);
        recStack.add(course);

        for (String neighbor : graph.get(course)) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, visited, recStack, order)) return true;
            } else if (recStack.contains(neighbor)) {
                return true; // cycle
            }
        }

        recStack.remove(course);
        order.push(course);
        return false;
    }
}

// Demo
public class CoursePlannerApp {
    public static void main(String[] args) {
        CoursePlanner planner = new CoursePlanner();
        planner.addPrerequisite("Math", "Physics");
        planner.addPrerequisite("Physics", "Engineering");
        planner.addPrerequisite("English", "History");

        List<String> order = planner.getCourseOrder();
        if (order == null) {
            System.out.println("Cycle detected in prerequisites!");
        } else {
            System.out.println("Valid course order: " + order);
        }
    }
}

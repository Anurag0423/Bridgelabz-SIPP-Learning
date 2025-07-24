import java.time.LocalDate;
import java.util.*;

// Policy class
class Policy {
    String number;
    String holder;
    LocalDate expiry;
    String type;
    double premium;

    public Policy(String number, String holder, LocalDate expiry, String type, double premium) {
        this.number = number;
        this.holder = holder;
        this.expiry = expiry;
        this.type = type;
        this.premium = premium;
    }

    public String toString() {
        return number + " | " + holder + " | " + expiry + " | " + type + " | ₹" + premium;
    }
}

public class PolicyManagementWithMap {
    public static void main(String[] args) {
        // 1. Maps
        Map<String, Policy> hashMap = new HashMap<>();         // Fast lookup
        Map<String, Policy> linkedMap = new LinkedHashMap<>(); // Insertion order
        TreeMap<LocalDate, List<Policy>> treeMap = new TreeMap<>(); // Sorted by expiry date

        // Sample policies
        Policy p1 = new Policy("P100", "Alice", LocalDate.now().plusDays(10), "Health", 3000);
        Policy p2 = new Policy("P101", "Bob", LocalDate.now().plusDays(40), "Auto", 2200);
        Policy p3 = new Policy("P102", "Alice", LocalDate.now().plusDays(25), "Home", 1500);
        Policy p4 = new Policy("P103", "David", LocalDate.now().minusDays(5), "Health", 2000); // Expired
        Policy p5 = new Policy("P104", "Eva", LocalDate.now().plusDays(5), "Auto", 1700);

        List<Policy> all = Arrays.asList(p1, p2, p3, p4, p5);

        // Add to maps
        for (Policy p : all) {
            hashMap.put(p.number, p);
            linkedMap.put(p.number, p);

            // For TreeMap (group by expiry date)
            treeMap.computeIfAbsent(p.expiry, k -> new ArrayList<>()).add(p);
        }

        // 2. Retrieve a policy by number
        System.out.println("Policy P102 Details:");
        Policy found = hashMap.get("P102");
        System.out.println(found != null ? found : "Not found");

        // 3. Policies expiring within 30 days
        System.out.println("\nPolicies expiring in 30 days:");
        LocalDate now = LocalDate.now();
        LocalDate next30 = now.plusDays(30);
        for (Map.Entry<LocalDate, List<Policy>> entry : treeMap.subMap(now, true, next30, true).entrySet()) {
            for (Policy p : entry.getValue()) {
                System.out.println(p);
            }
        }

        // 4. List all policies for a specific policyholder
        System.out.println("\nPolicies for Alice:");
        for (Policy p : linkedMap.values()) {
            if (p.holder.equalsIgnoreCase("Alice")) {
                System.out.println(p);
            }
        }

        // 5. Remove expired policies
        System.out.println("\nRemoving expired policies...");
        Iterator<Map.Entry<String, Policy>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Policy p = it.next().getValue();
            if (p.expiry.isBefore(now)) {
                System.out.println("Removed: " + p);
                it.remove();
            }
        }

        // Final list of policies after removal
        System.out.println("\nPolicies after removal (HashMap):");
        for (Policy p : hashMap.values()) {
            System.out.println(p);
        }
    }
}

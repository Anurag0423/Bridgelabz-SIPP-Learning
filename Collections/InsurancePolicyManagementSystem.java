import java.time.LocalDate;
import java.util.*;

// Model Class
class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return policyNumber + " | " + policyholderName + " | " + expiryDate + " | " + coverageType + " | " + premiumAmount;
    }
}

// Manager Class
public class InsurancePolicyManager {
    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void displayAllPolicies(Set<Policy> set) {
        set.forEach(System.out::println);
    }

    public void displayExpiringSoon(Set<Policy> set) {
        LocalDate now = LocalDate.now();
        set.stream()
            .filter(p -> !p.getExpiryDate().isBefore(now) && p.getExpiryDate().isBefore(now.plusDays(30)))
            .forEach(System.out::println);
    }

    public void displayByCoverageType(Set<Policy> set, String type) {
        set.stream()
            .filter(p -> p.getCoverageType().equalsIgnoreCase(type))
            .forEach(System.out::println);
    }

    public void findDuplicates(List<Policy> policies) {
        Set<String> seen = new HashSet<>();
        System.out.println("Duplicate Policies:");
        policies.stream()
            .filter(p -> !seen.add(p.getPolicyNumber()))
            .forEach(System.out::println);
    }

    public void comparePerformance() {
        List<Policy> testPolicies = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            testPolicies.add(new Policy("P" + i, "User" + i,
                    LocalDate.now().plusDays(i % 365), "Health", 1000 + i));
        }

        System.out.println("=== Performance Comparison ===");

        long start, end;

        start = System.nanoTime();
        Set<Policy> hs = new HashSet<>(testPolicies);
        end = System.nanoTime();
        System.out.println("HashSet add time: " + (end - start) + " ns");

        start = System.nanoTime();
        hs.contains(testPolicies.get(5000));
        end = System.nanoTime();
        System.out.println("HashSet search time: " + (end - start) + " ns");

        start = System.nanoTime();
        hs.remove(testPolicies.get(5000));
        end = System.nanoTime();
        System.out.println("HashSet remove time: " + (end - start) + " ns");

        start = System.nanoTime();
        Set<Policy> lhs = new LinkedHashSet<>(testPolicies);
        end = System.nanoTime();
        System.out.println("LinkedHashSet add time: " + (end - start) + " ns");

        start = System.nanoTime();
        lhs.contains(testPolicies.get(5000));
        end = System.nanoTime();
        System.out.println("LinkedHashSet search time: " + (end - start) + " ns");

        start = System.nanoTime();
        lhs.remove(testPolicies.get(5000));
        end = System.nanoTime();
        System.out.println("LinkedHashSet remove time: " + (end - start) + " ns");

        start = System.nanoTime();
        Set<Policy> ts = new TreeSet<>(testPolicies);
        end = System.nanoTime();
        System.out.println("TreeSet add time: " + (end - start) + " ns");

        start = System.nanoTime();
        ts.contains(testPolicies.get(5000));
        end = System.nanoTime();
        System.out.println("TreeSet search time: " + (end - start) + " ns");

        start = System.nanoTime();
        ts.remove(testPolicies.get(5000));
        end = System.nanoTime();
        System.out.println("TreeSet remove time: " + (end - start) + " ns");
    }

    // Main method to test the system
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        Policy p1 = new Policy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 2000);
        Policy p2 = new Policy("P102", "Bob", LocalDate.now().plusDays(40), "Auto", 1500);
        Policy p3 = new Policy("P103", "Carol", LocalDate.now().plusDays(20), "Home", 1800);
        Policy p4 = new Policy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 2000); // duplicate
        Policy p5 = new Policy("P104", "David", LocalDate.now().plusDays(5), "Auto", 1900);

        List<Policy> allPolicies = Arrays.asList(p1, p2, p3, p4, p5);
        for (Policy p : allPolicies) manager.addPolicy(p);

        System.out.println("=== All Unique Policies (LinkedHashSet) ===");
        manager.displayAllPolicies(manager.linkedHashSet);

        System.out.println("\n=== Policies Expiring Soon (Next 30 Days) ===");
        manager.displayExpiringSoon(manager.treeSet);

        System.out.println("\n=== Policies with Coverage Type 'Auto' ===");
        manager.displayByCoverageType(manager.hashSet, "Auto");

        System.out.println("\n=== Detecting Duplicates Based on Policy Number ===");
        manager.findDuplicates(allPolicies);

        System.out.println("\n=== Comparing Performance ===");
        manager.comparePerformance();
    }
}

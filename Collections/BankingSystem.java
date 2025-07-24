import java.util.*;

class BankingSystem {
    public static void main(String[] args) {
        // HashMap to store accounts
        Map<String, Double> accounts = new HashMap<>();
        accounts.put("ACC101", 5000.0);
        accounts.put("ACC102", 3000.0);
        accounts.put("ACC103", 7000.0);
        accounts.put("ACC104", 4000.0);

        // Queue to store withdrawal requests (account, amount)
        Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();
        withdrawalQueue.add(new WithdrawalRequest("ACC101", 1000.0));
        withdrawalQueue.add(new WithdrawalRequest("ACC102", 2000.0));
        withdrawalQueue.add(new WithdrawalRequest("ACC103", 8000.0)); // Insufficient
        withdrawalQueue.add(new WithdrawalRequest("ACC104", 500.0));

        // Process withdrawals
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            String accNo = request.accountNumber;
            double amount = request.amount;

            if (accounts.containsKey(accNo)) {
                double balance = accounts.get(accNo);
                if (balance >= amount) {
                    accounts.put(accNo, balance - amount);
                    System.out.println("Withdrawal of ₹" + amount + " from " + accNo + " successful.");
                } else {
                    System.out.println("Insufficient balance for " + accNo);
                }
            } else {
                System.out.println("Account " + accNo + " does not exist.");
            }
        }

        // TreeMap to sort by balance (value to key mapping)
        TreeMap<Double, List<String>> sortedByBalance = new TreeMap<>();
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            double balance = entry.getValue();
            sortedByBalance.putIfAbsent(balance, new ArrayList<>());
            sortedByBalance.get(balance).add(entry.getKey());
        }

        System.out.println("\nAccounts sorted by balance:");
        for (Map.Entry<Double, List<String>> entry : sortedByBalance.entrySet()) {
            for (String acc : entry.getValue()) {
                System.out.println(acc + " → ₹" + entry.getKey());
            }
        }
    }
}

// Helper class for withdrawal requests
class WithdrawalRequest {
    String accountNumber;
    double amount;

    WithdrawalRequest(String accNo, double amt) {
        this.accountNumber = accNo;
        this.amount = amt;
    }
}

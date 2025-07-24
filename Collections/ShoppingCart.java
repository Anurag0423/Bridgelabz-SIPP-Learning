import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        // 1. HashMap to store product prices
        Map<String, Double> productPrices = new HashMap<>();
        productPrices.put("Apple", 1.5);
        productPrices.put("Banana", 0.8);
        productPrices.put("Milk", 2.5);
        productPrices.put("Bread", 1.2);

        // 2. LinkedHashMap to maintain the order of added items
        Map<String, Integer> cart = new LinkedHashMap<>();

        // Simulate adding items to cart
        addToCart(cart, "Milk", 1);
        addToCart(cart, "Apple", 3);
        addToCart(cart, "Bread", 2);
        addToCart(cart, "Banana", 4);

        // 3. TreeMap to sort items by price (price -> list of items)
        TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();
        for (String item : cart.keySet()) {
            double price = productPrices.get(item);
            sortedByPrice.putIfAbsent(price, new ArrayList<>());
            sortedByPrice.get(price).add(item);
        }

        // Output
        System.out.println("1. HashMap (Product Prices):");
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            System.out.println(entry.getKey() + " -> $" + entry.getValue());
        }

        System.out.println("\n2. LinkedHashMap (Cart - Order Added):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " x " + entry.getValue());
        }

        System.out.println("\n3. TreeMap (Items Sorted by Price):");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String item : entry.getValue()) {
                System.out.println(item + " -> $" + entry.getKey());
            }
        }
    }

    public static void addToCart(Map<String, Integer> cart, String product, int quantity) {
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }
}

import java.util.ArrayList;

// Product class (can exist independently of orders)
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void displayProduct() {
        System.out.println("  - " + name + " : ₹" + price);
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

// Order class (aggregates products, linked to a customer)
class Order {
    private static int orderCounter = 1;
    private int orderId;
    private Customer customer;
    private ArrayList<Product> productList;

    public Order(Customer customer) {
        this.customer = customer;
        this.productList = new ArrayList<>();
        this.orderId = orderCounter++;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void displayOrder() {
        System.out.println("Order ID: #" + orderId + " placed by " + customer.getName());
        System.out.println("Products:");
        double total = 0;
        for (Product p : productList) {
            p.displayProduct();
            total += p.getPrice();
        }
        System.out.println("Total Amount: ₹" + total);
    }
}

// Customer class (places orders)
class Customer {
    private String name;
    private ArrayList<Order> orders;

    public Customer(String name) {
        this.name = name;
        orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed Order ID: #" + order.hashCode());
    }

    public void viewOrders() {
        System.out.println("\nCustomer: " + name + " - Order History");
        for (Order o : orders) {
            o.displayOrder();
            System.out.println();
        }
    }
}

// Main class
public class ECommercePlatformDemo {
    public static void main(String[] args) {
        // Create products
        Product p1 = new Product("Laptop", 60000);
        Product p2 = new Product("Headphones", 2000);
        Product p3 = new Product("Mouse", 500);
        Product p4 = new Product("Keyboard", 1000);

        // Create customers
        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        // Alice places an order
        Order aliceOrder = new Order(alice);
        aliceOrder.addProduct(p1);
        aliceOrder.addProduct(p3);
        alice.placeOrder(aliceOrder);

        // Bob places an order
        Order bobOrder = new Order(bob);
        bobOrder.addProduct(p2);
        bobOrder.addProduct(p4);
        bob.placeOrder(bobOrder);

        // Display all orders
        alice.viewOrders();
        bob.viewOrders();
    }
}

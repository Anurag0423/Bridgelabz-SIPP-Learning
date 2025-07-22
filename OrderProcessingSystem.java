import java.util.*;

// Interface
interface Order {
    void process();
}

// Implementations
class OnlineOrder implements Order {
    public void process() {
        System.out.println("Processing online order.");
    }
}

class OfflineOrder implements Order {
    public void process() {
        System.out.println("Processing offline order.");
    }
}

class SubscriptionOrder implements Order {
    public void process() {
        System.out.println("Processing subscription order.");
    }
}

// Order Queue
class OrderProcessor {
    private Queue<Order> orderQueue = new LinkedList<>();

    public void addOrder(Order order) {
        orderQueue.add(order);
    }

    public void processOrders() {
        while (!orderQueue.isEmpty()) {
            orderQueue.poll().process();
        }
    }
}

// Demo
public class OrderSystemApp {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        processor.addOrder(new OnlineOrder());
        processor.addOrder(new OfflineOrder());
        processor.addOrder(new SubscriptionOrder());

        processor.processOrders(); // Output: Processing online, offline, and subscription orders
    }
}

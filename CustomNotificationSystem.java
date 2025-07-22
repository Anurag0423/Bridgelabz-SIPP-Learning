import java.util.*;

// Interface
interface Notification {
    void deliver();
}

// Implementations
class EmailNotification implements Notification {
    public void deliver() {
        System.out.println("Email sent.");
    }
}

class SMSNotification implements Notification {
    public void deliver() {
        System.out.println("SMS sent.");
    }
}

class PushNotification implements Notification {
    public void deliver() {
        System.out.println("Push notification sent.");
    }
}

// Encapsulated Queue
class NotificationQueue {
    private Queue<Notification> queue = new LinkedList<>();

    public void add(Notification n) {
        queue.add(n);
    }

    public void sendAll() {
        while (!queue.isEmpty()) {
            Notification n = queue.poll();
            n.deliver();
        }
    }
}

// Demo
public class NotificationSystemApp {
    public static void main(String[] args) {
        NotificationQueue queue = new NotificationQueue();
        queue.add(new EmailNotification());
        queue.add(new SMSNotification());
        queue.add(new PushNotification());

        queue.sendAll(); // Output: Email sent. SMS sent. Push notification sent.
    }
}

package com.lambdaExpressions.NotificationFiltering;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static List<Notification> filterNotifications(List<Notification> notifications,
            Predicate<Notification> condition) {
        List<Notification> result = new ArrayList<>();
        for (Notification n : notifications) {
            if (condition.test(n)) {
                result.add(n);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Sample notifications
        List<Notification> notifications = Arrays.asList(
                new Notification("Critical", "Patient A needs immediate attention."),
                new Notification("Reminder", "Patient B has a checkup tomorrow."),
                new Notification("Info", "New hospital policy update."),
                new Notification("Critical", "Patient C needs urgent blood test."),
                new Notification("Reminder", "Patient D follow-up scheduled."));

        // User preference: Show only "Critical" alerts
        Predicate<Notification> criticalFilter = n -> n.getType().equalsIgnoreCase("Critical");

        // Another preference: Show only "Reminder" alerts
        Predicate<Notification> reminderFilter = n -> n.getType().equalsIgnoreCase("Reminder");

        // Apply filtering
        List<Notification> criticalAlerts = filterNotifications(notifications, criticalFilter);
        List<Notification> reminderAlerts = filterNotifications(notifications, reminderFilter);

        // Output
        System.out.println("=== Critical Alerts ===");
        criticalAlerts.forEach(System.out::println);

        System.out.println("\n=== Reminder Alerts ===");
        reminderAlerts.forEach(System.out::println);
    }
}
import java.util.LinkedList;

// Interface for all tasks
interface Task {
    int getPriority();          // Lower number = higher priority
    void execute();             // What the task should do
}

// Email Task implementation
class EmailTask implements Task {
    private String recipient;
    private int priority;

    public EmailTask(String recipient, int priority) {
        this.recipient = recipient;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void execute() {
        System.out.println("Sending email to " + recipient);
    }
}

// Report Task implementation
class ReportTask implements Task {
    private String reportName;
    private int priority;

    public ReportTask(String reportName, int priority) {
        this.reportName = reportName;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void execute() {
        System.out.println("Generating report: " + reportName);
    }
}

// Scheduler with priority-based task queue
class TaskScheduler {
    private LinkedList<Task> taskQueue = new LinkedList<>();

    // Insert task into queue based on priority
    public void addTask(Task newTask) {
        int index = 0;
        while (index < taskQueue.size() &&
               taskQueue.get(index).getPriority() <= newTask.getPriority()) {
            index++;
        }
        taskQueue.add(index, newTask); // insert at the right spot
    }

    // Execute all tasks in order
    public void runAll() {
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.removeFirst();
            task.execute();
        }
    }
}

// Main class to run the scheduler
public class TaskSchedulerApp {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addTask(new EmailTask("user@example.com", 3));    // lower priority
        scheduler.addTask(new ReportTask("Sales Report", 1));       // high priority
        scheduler.addTask(new EmailTask("admin@example.com", 2));

        scheduler.runAll(); // Output will be in priority order
    }
}

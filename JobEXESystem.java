import java.util.*;

// Interface
interface Executable {
    void execute();
}

// Implementations
class DataSyncJob implements Executable {
    public void execute() {
        System.out.println("Running data sync job...");
    }
}

class EmailAlertJob implements Executable {
    public void execute() {
        System.out.println("Sending email alerts...");
    }
}

class CleanupJob implements Executable {
    public void execute() {
        System.out.println("Cleaning up temp files...");
    }
}

// Job Queue
class JobScheduler {
    private Queue<Executable> jobQueue = new LinkedList<>();

    public void addJob(Executable job) {
        jobQueue.add(job);
    }

    public void runJobs() {
        while (!jobQueue.isEmpty()) {
            jobQueue.poll().execute();
        }
    }
}

// Demo
public class JobExecutionApp {
    public static void main(String[] args) {
        JobScheduler scheduler = new JobScheduler();
        scheduler.addJob(new DataSyncJob());
        scheduler.addJob(new EmailAlertJob());
        scheduler.addJob(new CleanupJob());

        scheduler.runJobs(); // Output: Executes all jobs in order
    }
}

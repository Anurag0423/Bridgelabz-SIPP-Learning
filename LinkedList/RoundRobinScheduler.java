package LinkedList;

class ProcessLinkedList {
    Node head;
    Node tail;
    int size;

    class Node {
        int pid;
        int burstTime;
        int priority;
        int remainingTime;
        Node next;

        Node(int pid, int burstTime, int priority) {
            this.pid = pid;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
            this.priority = priority;
            this.next = null;
            size++;
        }
    }

    void addProcess(int pid, int bt, int priority) {
        Node newNode = new Node(pid, bt, priority);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    void deleteProcess(int pid) {
        if (head == null) return;

        if (head.pid == pid) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            size--;
            return;
        }

        Node temp = head;
        while (temp.next != head && temp.next.pid != pid)
            temp = temp.next;

        if (temp.next.pid == pid) {
            if (temp.next == tail) tail = temp;
            temp.next = temp.next.next;
            tail.next = head;
            size--;
        }
    }

    void simulateRR(int quantum) {
        if (head == null) return;

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int completed = 0;

        Node temp = head;
        while (completed < size) {
            if (temp.remainingTime > 0) {
                int execTime = Math.min(temp.remainingTime, quantum);
                temp.remainingTime -= execTime;

                if (temp.remainingTime == 0) {
                    completed++;
                    int turnaround = totalTurnaroundTime + execTime;
                    int waiting = turnaround - temp.burstTime;
                    totalWaitingTime += waiting;
                    totalTurnaroundTime += turnaround;

                    System.out.println("Process " + temp.pid + " completed.");
                    System.out.println("Waiting Time    : " + waiting);
                    System.out.println("Turnaround Time : " + turnaround);
                    System.out.println();
                } else {
                    totalTurnaroundTime += execTime;
                }
            }
            temp = temp.next;
        }

        System.out.println("Average Waiting Time    : " + (totalWaitingTime / (double) size));
        System.out.println("Average Turnaround Time : " + (totalTurnaroundTime / (double) size));
    }

    void displayAll() {
        if (head == null) return;

        Node temp = head;
        do {
            display(temp);
            temp = temp.next;
        } while (temp != head);
    }

    void display(Node node) {
        System.out.println("PID         : " + node.pid);
        System.out.println("Burst Time  : " + node.burstTime);
        System.out.println("Priority    : " + node.priority);
        System.out.println();
    }
}

public class RoundRobinScheduler {
    public static void main(String[] args) {
        ProcessLinkedList processes = new ProcessLinkedList();

        processes.addProcess(1, 6, 2);
        processes.addProcess(2, 4, 1);
        processes.addProcess(3, 8, 3);

        System.out.println("Processes in Circular Queue:");
        processes.displayAll();

        System.out.println("Simulating Round Robin with quantum = 2");
        processes.simulateRR(2);
    }
}

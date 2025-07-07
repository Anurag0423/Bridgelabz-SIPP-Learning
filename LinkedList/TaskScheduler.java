package LinkedList;

class TaskLinkedList {
    Node head = null;
    Node tail = null;
    int size = 0;

    class Node {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        Node next;

        Node(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
            size++;
        }
    }

    void addStart(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    void addEnd(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    void addAtPos(int taskId, String taskName, int priority, String dueDate, int pos) {
        if (pos < 0 || pos > size) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 0) {
            addStart(taskId, taskName, priority, dueDate);
            return;
        }

        if (pos == size) {
            addEnd(taskId, taskName, priority, dueDate);
            return;
        }

        Node newNode = new Node(taskId, taskName, priority, dueDate);
        Node temp = head;
        for (int i = 1; i < pos; i++) temp = temp.next;

        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteByTaskId(int taskId) {
        if (head == null) return;

        if (head.taskId == taskId) {
            if (head == tail) {
                head = tail = null;
                size--;
                return;
            }
            head = head.next;
            tail.next = head;
            size--;
            return;
        }

        Node temp = head;
        while (temp.next != head && temp.next.taskId != taskId) {
            temp = temp.next;
        }

        if (temp.next.taskId == taskId) {
            if (temp.next == tail) {
                tail = temp;
            }
            temp.next = temp.next.next;
            tail.next = head;
            size--;
        }
    }

    void displayAll() {
        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }

        Node temp = head;
        int count = 0;
        do {
            display(temp);
            temp = temp.next;
            count++;
        } while (temp != head && count < size);
    }

    void searchByPriority(int targetPriority) {
        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }

        Node temp = head;
        boolean found = false;
        int count = 0;

        do {
            if (temp.priority == targetPriority) {
                display(temp);
                found = true;
            }
            temp = temp.next;
            count++;
        } while (temp != head && count < size);

        if (!found) System.out.println("No task with priority " + targetPriority);
    }

    void display(Node node) {
        System.out.println("Task ID  : " + node.taskId);
        System.out.println("Task Name: " + node.taskName);
        System.out.println("Priority : " + node.priority);
        System.out.println("Due Date : " + node.dueDate);
        System.out.println();
    }

    void viewNextTasks(int rounds) {
        if (head == null) return;

        Node current = head;
        for (int i = 0; i < rounds * size; i++) {
            display(current);
            current = current.next;
        }
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addEnd(1, "Submit Report", 2, "2025-07-05");
        taskList.addStart(2, "Fix Bug #123", 1, "2025-07-04");
        taskList.addAtPos(3, "Prepare Presentation", 3, "2025-07-06", 1);
        taskList.addEnd(4, "Code Review", 2, "2025-07-07");

        System.out.println("All Tasks:");
        taskList.displayAll();

        System.out.println("Search for priority 2:");
        taskList.searchByPriority(2);

        System.out.println("Removing task with ID 2:");
        taskList.deleteByTaskId(2);

        System.out.println("Current Tasks:");
        taskList.displayAll();

        System.out.println("Next 2 cycles of task execution:");
        taskList.viewNextTasks(2);
    }
}

package LinkedList;

class LinkedList {
    Node head;
    Node tail;
    int size;

    class Node {
        int rollNo;
        String name;
        int age;
        int grade;
        Node next;

        Node(int rollNo, String name, int age, int grade) {
            this.rollNo = rollNo;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
            size++;
        }
    }

    void addEnd(int rollNo, String name, int age, int grade) {
        Node newNode = new Node(rollNo, name, age, grade);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    void addStart(int rollNo, String name, int age, int grade) {
        Node newNode = new Node(rollNo, name, age, grade);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    void addAtPos(int rollNo, String name, int age, int grade, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 0) {
            addStart(rollNo, name, age, grade);
            return;
        }

        if (position == size) {
            addEnd(rollNo, name, age, grade);
            return;
        }

        Node newNode = new Node(rollNo, name, age, grade);
        Node temp = head;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    void displayByRollno(int rollNo) {
        if (head == null) {
            System.out.println("No record");
            return;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                display(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Roll no not found");
    }

    void deleteByRollno(int rollNo) {
        if (head == null) {
            System.out.println("No record");
            return;
        }

        if (head.rollNo == rollNo) {
            head = head.next;
            size--;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.rollNo == rollNo) {
                temp.next = temp.next.next;
                size--;
                return;
            }
            temp = temp.next;
        }

        System.out.println("Roll no not found");
    }

    void updateGradeByRoll(int rollNo, int newGrade) {
        Node temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Roll no not found");
    }

    void displayAll() {
        Node cur = head;
        System.out.println("Total students: " + size);
        while (cur != null) {
            display(cur);
            cur = cur.next;
        }
    }

    void display(Node cur) {
        System.out.println("Name: " + cur.name);
        System.out.println("Roll no: " + cur.rollNo);
        System.out.println("Age: " + cur.age);
        System.out.println("Grade: " + cur.grade);
        System.out.println();
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.addStart(1, "Govind", 19, 81);
        l1.addEnd(3, "Gopal", 21, 82);
        l1.addAtPos(2, "Golu", 20, 80, 1);

        System.out.println("Initial Records:");
        l1.displayAll();

        System.out.println("Displaying Roll No 2:");
        l1.displayByRollno(2);

        System.out.println("Updating Grade of Roll No 3 to 85");
        l1.updateGradeByRoll(3, 85);

        System.out.println("Deleting Roll No 1:");
        l1.deleteByRollno(1);

        System.out.println("Final Records:");
        l1.displayAll();
    }
}

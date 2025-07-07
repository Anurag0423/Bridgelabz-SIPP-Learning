package LinkedList;

class TextHistory {
    Node head;
    Node tail;
    Node current;
    int size = 0;
    int limit = 10;

    class Node {
        String state;
        Node prev;
        Node next;

        Node(String state) {
            this.state = state;
        }
    }

    void addState(String text) {
        Node newNode = new Node(text);
        if (head == null) head = tail = current = newNode;
        else {
            if (current.next != null) current.next.prev = null;
            current.next = null;
            newNode.prev = current;
            current.next = newNode;
            current = newNode;
            tail = newNode;
        }

        size++;
        if (size > limit) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("Cannot undo");
        }
    }

    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("Cannot redo");
        }
    }

    void showCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.state);
        } else {
            System.out.println("Editor is empty");
        }
    }
}

public class TextEditorHistory {
    public static void main(String[] args) {
        TextHistory editor = new TextHistory();

        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");
        editor.showCurrentState();

        editor.undo();
        editor.showCurrentState();

        editor.undo();
        editor.showCurrentState();

        editor.redo();
        editor.showCurrentState();
    }
}

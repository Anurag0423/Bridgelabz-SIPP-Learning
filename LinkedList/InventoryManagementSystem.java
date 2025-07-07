package LinkedList;

class InventoryLinkedList {
    Node head;
    Node tail;
    int size;

    class Node {
        String itemName;
        int itemId;
        int quantity;
        double price;
        Node next;

        Node(String itemName, int itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
            size++;
        }
    }

    void addStart(String itemName, int itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
        if (head == null) head = tail = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    void addEnd(String itemName, int itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
        if (head == null) head = tail = newNode;
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    void addAtPos(String itemName, int itemId, int quantity, double price, int pos) {
        if (pos < 0 || pos > size) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 0) {
            addStart(itemName, itemId, quantity, price);
            return;
        }
        if (pos == size) {
            addEnd(itemName, itemId, quantity, price);
            return;
        }

        Node newNode = new Node(itemName, itemId, quantity, price);
        Node temp = head;
        for (int i = 1; i < pos; i++) temp = temp.next;
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteByItemId(int id) {
        if (head == null) return;
        if (head.itemId == id) {
            head = head.next;
            size--;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.itemId != id)
            temp = temp.next;

        if (temp.next != null) {
            temp.next = temp.next.next;
            size--;
        }
    }

    void updateQuantity(int id, int newQty) {
        Node temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
    }

    void searchByIdOrName(String keyword) {
        Node temp = head;
        while (temp != null) {
            if (String.valueOf(temp.itemId).equals(keyword) || temp.itemName.equalsIgnoreCase(keyword))
                display(temp);
            temp = temp.next;
        }
    }

    void displayAll() {
        Node temp = head;
        while (temp != null) {
            display(temp);
            temp = temp.next;
        }
    }

    void display(Node node) {
        System.out.println("Item ID   : " + node.itemId);
        System.out.println("Item Name : " + node.itemName);
        System.out.println("Quantity  : " + node.quantity);
        System.out.println("Price     : " + node.price);
        System.out.println();
    }

    void calculateTotalValue() {
        double total = 0;
        Node temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryLinkedList inventory = new InventoryLinkedList();

        inventory.addEnd("Pen", 101, 100, 1.5);
        inventory.addStart("Notebook", 102, 50, 4.0);
        inventory.addAtPos("Pencil", 103, 75, 0.5, 1);

        inventory.displayAll();

        inventory.updateQuantity(101, 120);

        System.out.println("Item with ID 101 after quantity update:");
        inventory.searchByIdOrName("101");

        inventory.calculateTotalValue();
    }
}

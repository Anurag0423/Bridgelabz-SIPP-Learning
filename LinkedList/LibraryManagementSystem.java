package LinkedList;

class LibraryLinkedList {
    Node head;
    Node tail;
    int size;

    class Node {
        String title;
        String author;
        String genre;
        int bookId;
        boolean available;
        Node next;
        Node prev;

        Node(String title, String author, String genre, int bookId, boolean available) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.available = available;
            size++;
        }
    }

    void addEnd(String title, String author, String genre, int bookId, boolean available) {
        Node newNode = new Node(title, author, genre, bookId, available);
        if (head == null) head = tail = newNode;
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void removeById(int id) {
        Node temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                if (temp.prev != null) temp.prev.next = temp.next;
                else head = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                else tail = temp.prev;
                size--;
                return;
            }
            temp = temp.next;
        }
    }

    void updateAvailability(int id, boolean status) {
        Node temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.available = status;
                return;
            }
            temp = temp.next;
        }
    }

    void displayAllForward() {
        Node temp = head;
        while (temp != null) {
            display(temp);
            temp = temp.next;
        }
    }

    void countBooks() {
        System.out.println("Total books in library: " + size);
    }

    void display(Node node) {
        System.out.println("Book ID    : " + node.bookId);
        System.out.println("Title      : " + node.title);
        System.out.println("Author     : " + node.author);
        System.out.println("Genre      : " + node.genre);
        System.out.println("Available? : " + (node.available ? "Yes" : "No"));
        System.out.println();
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryLinkedList library = new LibraryLinkedList();

        library.addEnd("1984", "Govind Upadhyay", "Dystopian", 201, true);
        library.addEnd("Gadget Masala", "Doraemon", "Fiction", 202, false);
        library.addEnd("Gun mania", "John Wick", "Martial Arts", 203, true);

        library.displayAllForward();

        library.updateAvailability(202, true);

        System.out.println("After updating availability:");
        library.displayAllForward();

        library.removeById(201);
        library.countBooks();
    }
}

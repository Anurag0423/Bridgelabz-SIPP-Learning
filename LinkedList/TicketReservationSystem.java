package LinkedList;

class TicketCircularList {
    Node head;
    Node tail;
    int size;

    class Node {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        Node next;

        Node(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            size++;
        }
    }

    void addTicket(int ticketId, String customer, String movie, String seat, String time) {
        Node newNode = new Node(ticketId, customer, movie, seat, time);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    void removeTicket(int ticketId) {
        if (head == null) return;
        if (head.ticketId == ticketId) {
            if (head == tail) head = tail = null;
            else {
                head = head.next;
                tail.next = head;
            }
            size--;
            return;
        }

        Node temp = head;
        while (temp.next != head && temp.next.ticketId != ticketId)
            temp = temp.next;

        if (temp.next.ticketId == ticketId) {
            if (temp.next == tail) tail = temp;
            temp.next = temp.next.next;
            tail.next = head;
            size--;
        }
    }

    void displayAll() {
        if (head == null) return;
        Node temp = head;
        do {
            display(temp);
            temp = temp.next;
        } while (temp != head);
    }

    void searchTicket(String keyword) {
        if (head == null) return;
        Node temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword))
                display(temp);
            temp = temp.next;
        } while (temp != head);
    }

    void countTickets() {
        System.out.println("Total tickets booked: " + size);
    }

    void display(Node node) {
        System.out.println("Ticket ID   : " + node.ticketId);
        System.out.println("Customer    : " + node.customerName);
        System.out.println("Movie       : " + node.movieName);
        System.out.println("Seat No     : " + node.seatNumber);
        System.out.println("Booking Time: " + node.bookingTime);
        System.out.println();
    }
}

public class TicketReservationSystem {
    public static void main(String[] args) {
        TicketCircularList system = new TicketCircularList();

        system.addTicket(201, "Ravi", "Inception", "A1", "10:00 AM");
        system.addTicket(202, "Sneha", "Interstellar", "A2", "10:30 AM");
        system.addTicket(203, "Govind", "Dune", "A3", "11:00 AM");

        system.displayAll();
        system.searchTicket("Interstellar");
        system.removeTicket(202);
        system.countTickets();
    }
}

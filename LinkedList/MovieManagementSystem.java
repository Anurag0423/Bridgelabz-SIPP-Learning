package LinkedList;

class MovieLinkedList {
    Node head;
    Node tail;
    int size;

    class Node {
        String title;
        String director;
        int year;
        float rating;
        Node next;
        Node prev;

        Node(String title, String director, int year, float rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
            this.next = this.prev = null;
            size++;
        }
    }

    void addStart(String title, String director, int year, float rating) {
        Node newNode = new Node(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void addEnd(String title, String director, int year, float rating) {
        Node newNode = new Node(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void addAtPos(String title, String director, int year, float rating, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position"); return;
        }

        if (position == 0) {
            addStart(title, director, year, rating);
            return;
        }

        if (position == size) {
            addEnd(title, director, year, rating);
            return;
        }

        Node newNode = new Node(title, director, year, rating);
        Node temp = head;
        for (int i = 1; i < position; i++) temp = temp.next;

        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) temp.next.prev = newNode;
        temp.next = newNode;
    }

    void removeByTitle(String title) {
        Node temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                if (temp.prev != null) temp.prev.next = temp.next;
                else head = temp.next;

                if (temp.next != null) temp.next.prev = temp.prev;
                else tail = temp.prev;

                size--;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

    void searchByDirector(String director) {
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                display(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found by director: " + director);
    }

    void searchByRating(float rating) {
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating >= rating) {
                display(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies with rating ≥ " + rating);
    }

    void updateRating(String title, float newRating) {
        Node temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

    void displayAllForward() {
        Node cur = head;
        System.out.println("Movies in list (forward): " + size);
        while (cur != null) {
            display(cur);
            cur = cur.next;
        }
    }

    void displayAllReverse() {
        Node cur = tail;
        System.out.println("Movies in list (reverse): " + size);
        while (cur != null) {
            display(cur);
            cur = cur.prev;
        }
    }

    void display(Node cur) {
        System.out.println("Title   : " + cur.title);
        System.out.println("Director: " + cur.director);
        System.out.println("Year    : " + cur.year);
        System.out.println("Rating  : " + cur.rating);
        System.out.println();
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieLinkedList movies = new MovieLinkedList();

        movies.addEnd("Inception", "Christopher Nolan", 2010, 8.8f);
        movies.addStart("The Matrix", "The Wachowskis", 1999, 8.7f);
        movies.addAtPos("Interstellar", "Christopher Nolan", 2014, 8.6f, 1);
        movies.addEnd("Avatar", "James Cameron", 2009, 7.8f);

        System.out.println("All Movies (Forward):");
        movies.displayAllForward();

        System.out.println("Search by Director (Christopher Nolan):");
        movies.searchByDirector("Christopher Nolan");

        System.out.println("Search by Rating ≥ 8.0:");
        movies.searchByRating(8.0f);

        System.out.println("Updating Rating for 'Avatar':");
        movies.updateRating("Avatar", 8.0f);

        System.out.println("After Deleting 'The Matrix':");
        movies.removeByTitle("The Matrix");
        movies.displayAllReverse();
    }
}

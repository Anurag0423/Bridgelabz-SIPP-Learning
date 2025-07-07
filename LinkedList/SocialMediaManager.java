package LinkedList;

class FriendLinkedList {
    Node head;
    Node tail;
    int size;

    class Node {
        int userId;
        String name;
        int age;
        int[] friendIds; // simplified as array for now
        Node next;

        Node(int userId, String name, int age, int[] friendIds) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friendIds = friendIds;
            this.next = null;
            size++;
        }
    }

    void addEnd(int userId, String name, int age, int[] friendIds) {
        Node newNode = new Node(userId, name, age, friendIds);
        if (head == null) head = tail = newNode;
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    void displayAllFriendsOfUser(int userId) {
        Node temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                System.out.println("User: " + temp.name);
                System.out.print("Friends: ");
                for (int id : temp.friendIds)
                    System.out.print(id + " ");
                System.out.println();
                return;
            }
            temp = temp.next;
        }
    }

    void findMutualFriends(int userId1, int userId2) {
        Node user1 = findUser(userId1);
        Node user2 = findUser(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found");
            return;
        }

        System.out.print("Mutual Friends: ");
        for (int f1 : user1.friendIds) {
            for (int f2 : user2.friendIds) {
                if (f1 == f2) System.out.print(f1 + " ");
            }
        }
        System.out.println();
    }

    Node findUser(int userId) {
        Node temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    void displayAllUsers() {
        Node temp = head;
        while (temp != null) {
            System.out.println("UserID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}

public class SocialMediaManager {
    public static void main(String[] args) {
        FriendLinkedList network = new FriendLinkedList();

        network.addEnd(1, "Alice", 22, new int[]{2, 3});
        network.addEnd(2, "Bob", 25, new int[]{1, 3});
        network.addEnd(3, "Charlie", 21, new int[]{1});

        network.displayAllUsers();
        network.displayAllFriendsOfUser(1);
        network.findMutualFriends(1, 2);
    }
}

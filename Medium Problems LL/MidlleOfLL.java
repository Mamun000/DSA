class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

}

public class MidlleOfLL {
    //Brute Force Approach TC: O(N)+O(N/2)  SC: O(1)
    public static Node findMiddle(Node head) {
        Node current = head;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        int mid = count / 2 + 1;
        current = head;
        while (current != null) {
            mid--;
            if (mid == 0) {
                break;
            }
            current = current.next;
        }
        return current;

    }
    //Optimal Approach TC: O(N/2) SC: O(1)
    public static Node findMiddleOptimalApproach(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node middleNode = findMiddle(head);
        System.out.println("The middle node value is: " + middleNode.data);

        System.out.println("Mid is : " + findMiddleOptimalApproach(head).data);
    }
}
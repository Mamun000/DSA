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

public class ReverseLLRecursive {

    public static Node reverseLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newNode = reverseLL(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newNode;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        print(head);
        head = reverseLL(head);
        print(head);
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println();
    }

}

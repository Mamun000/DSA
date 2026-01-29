class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

}

public class RemoveDuplicatesDLL {
    public static Node removeDuplicatesDLL(Node head) {
        Node current = head;

        while (current != null && current.next != null) {
            Node nextDistinct = current.next;

            while (nextDistinct != null && nextDistinct.data == current.data) {
                nextDistinct = nextDistinct.next;
            }
            current.next = nextDistinct;
            if (nextDistinct != null) {
                nextDistinct.prev = current;
            }
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(10);
        head.next.prev = head;
        head.next.next = new Node(20);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(30);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(30);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new Node(40);
        head.next.next.next.next.next.prev = head.next.next.next.next;

        head = removeDuplicatesDLL(head);
        print(head);

    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
    }

}
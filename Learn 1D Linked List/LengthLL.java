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

public class LengthLL {
    public static int lengthLL(Node head) {
        Node current = head;
        int count = 0;

        while (current != null) {
            current = current.next;
            count++;
        }
        return count;

    }

    public static void main(String[] args) {
        Node head = new Node(20);
        head.next = new Node(30);
        head.next.next = new Node(40);

        System.out.println("Length Linked List:" + lengthLL(head));

    }

}

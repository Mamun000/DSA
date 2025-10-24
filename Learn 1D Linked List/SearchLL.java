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

public class SearchLL {
    public static boolean lengthLL(Node head, int k) {
        Node current = head;

        while (current != null) {
            if (current.data == k)
                return true;
            current = current.next;

        }
        return false;

    }

    public static void main(String[] args) {
        Node head = new Node(20);
        head.next = new Node(30);
        head.next.next = new Node(40);

        System.out.println("Length Linked List:" + lengthLL(head, 50));

    }

}

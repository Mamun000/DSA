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

public class DeletetLL {
    public static Node deleteAtEnd(Node head) {
        Node current = head;

        while (current.next != null) {
            if (current.next.next == null) {
                current.next = null;
                break;
            }
            current = current.next;
        }
        return head;

    }

    public static void main(String[] args) {
        Node head = new Node(20);
        head.next = new Node(30);
        head.next.next = new Node(40);

        System.out.print("Original Linked List:");
        printList(head);

        head = deleteAtEnd(head);

        System.out.print("\nLinked List after deleting at end:");
        printList(head);
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }

    }

}

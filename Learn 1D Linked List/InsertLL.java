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

public class InsertLL {
    public static Node insertAtBeginning(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;

    }

    public static void main(String[] args) {
        Node head = new Node(20);
        head.next = new Node(30);

        System.out.println("Original Linked List:");
        printList(head);

        head = insertAtBeginning(head, 10);

        System.out.println("Linked List after insertion at beginning:");
        printList(head);
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

}

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

}

public class InsertAtEndDLL {
    public static Node insertAtTail(Node head, int val) {
        Node temp = new Node(val);

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = temp;
        current.prev = current;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        // Convert the array to a doubly linked list
        Node head = convertArr2DLL(arr);
        printDLL(head);

        head = insertAtTail(head, 5);
        printDLL(head);

    }

    public static Node convertArr2DLL(int arr[]) {
        int n = arr.length;
        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < n; i++) {
            Node temp = new Node(arr[i], null, prev);

            prev.next = temp;

            prev = temp;

        }
        return head;
    }

    public static void printDLL(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + "<->");
            current = current.next;
        }
        System.out.println();
    }
}
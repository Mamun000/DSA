class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class DeleteTailDLL {
    public static Node deleteTail(Node head) {
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.prev = head;

        head.next.next = new Node(30);
        head.next.next.prev = head.next;

        deleteTail(head);

        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "<->");
            curr = curr.next;
        }

    }

}
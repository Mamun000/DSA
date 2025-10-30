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

class ReverseDll {
    public static Node reverseDll(Node head) {
        Node current = head;
        Node last = null;
        while (current != null) {
            last = current.prev;
            current.prev = current.next;
            current.next = last;
            current = current.prev;
        }
        return last.prev;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20, null, head);
        head.next.next = new Node(30, null, head.next);
        print(head);

        head = reverseDll(head);
        print(head);

    }

    public static void print(Node head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
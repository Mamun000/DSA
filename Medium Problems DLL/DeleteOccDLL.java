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

public class DeleteOccDLL {
    public static Node deleteOccLL(Node head, int key) {
        Node temp = head;
        while (temp != null) {
            if (head.data == key) {
                head = head.next;
                if (head != null) {
                    head.prev = null;
                }
                temp = head;
                continue;
            }
            if (temp.data == key) {
                temp.prev.next = temp.next;
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                temp = temp.next;
                continue;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.prev = head;
        head.next.next = new Node(30);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(20);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(40);
        head.next.next.next.next.prev = head.next.next.next;

        head = deleteOccLL(head, 20);
        print(head);

    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

}
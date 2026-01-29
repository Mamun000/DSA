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

public class RemoveNthNodeLL {
    // Time Complexity O(n) Space Complexity O(1)
    public static Node removeNthNode(Node head, int n) {
        int i = 1;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            i++;
        }
        int x = i - n - 1;
        if (x == 0) {
            return head.next;
        }
        i = 0;
        temp = head;
        while (temp != null) {
            i++;
            if (i == x) {
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }

        return head;

    }

    // Time Complexity O(n) Space Complexity O(1)
    public static Node removeNthNodeTwoPointer(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node first = dummy;
        Node second = dummy;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(17);
        head.next = new Node(15);
        head.next.next = new Node(8);
        head.next.next.next = new Node(12);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(4);
        print(head);
        head = removeNthNode(head, 3);
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
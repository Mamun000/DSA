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

public class SortNumsLL {
    public static Node sortNumsLLBFA(Node head) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                count0++;
            } else if (temp.data == 1) {
                count1++;
            } else {
                count2++;
            }
            temp = temp.next;
        }

        temp = head;
        for (int i = 0; i < count0; i++) {
            temp.data = 0;
            temp = temp.next;
        }
        for (int i = 0; i < count1; i++) {
            temp.data = 1;
            temp = temp.next;
        }
        for (int i = 0; i < count2; i++) {
            temp.data = 2;
            temp = temp.next;
        }

        return head;
    }

    public static Node sortNumsLLOA(Node head) {
        Node zero = new Node(-1);
        Node one = new Node(-1);
        Node two = new Node(-1);

        Node zeroTail = zero;
        Node oneTail = one;
        Node twoTail = two;

        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zeroTail.next = temp;
                zeroTail = zeroTail.next;
            } else if (temp.data == 1) {
                oneTail.next = temp;
                oneTail = oneTail.next;

            } else {
                twoTail.next = temp;
                twoTail = twoTail.next;
            }
            temp = temp.next;
        }
        zeroTail.next = (one != null) ? one.next : two.next;
        oneTail.next = two.next;
        twoTail.next = null;
        head = zero.next;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(0);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);
        System.out.print("Original Linked List: ");
        printLinkedList(head);
        head = sortNumsLLOA(head);
        System.out.print("Sorted Linked List: ");
        printLinkedList(head);
    }

    public static void printLinkedList(Node head) {
        // Pointer to traverse list
        Node temp = head;

        // Traverse and print values
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}

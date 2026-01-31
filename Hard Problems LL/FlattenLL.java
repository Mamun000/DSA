import java.util.*;

class Node {
    int data;
    Node next;
    Node child;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
    }

    Node(int data, Node next, Node child) {
        this.data = data;
        this.next = next;
        this.child = child;
    }

}

public class FlattenLL {
    public static Node flattenLLBFA(Node head) {
        List<Integer> arr = new ArrayList<>();

        while (head != null) {
            Node t2 = head;
            while (t2 != null) {
                arr.add(t2.data);
                t2 = t2.child;
            }
            head = head.next;
        }
        Collections.sort(arr);
        return convertArrayToLL(arr);
    }

    public static Node flatternOA(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mergedHead = flatternOA(head.next);
        return mergeTwoSortedLL(head, mergedHead);
    }

    public static Node mergeTwoSortedLL(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node temp = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.child = head1;
                head1 = head1.child;
            } else {
                temp.child = head2;
                head2 = head2.child;
            }
            temp = temp.child;
        }

        if (head1 != null) {
            temp.child = head1;
        }
        if (head2 != null) {
            temp.child = head2;
        }
        return dummy.child;
    }

    public static Node convertArrayToLL(List<Integer> arr) {
        Node dummy = new Node(-1);
        Node temp = dummy;

        for (int val : arr) {
            temp.child = new Node(val);
            temp = temp.child;
        }
        return dummy.child;

    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(19);
        head.next.next.next = new Node(28);

        head.child = new Node(7);
        head.child.child = new Node(8);
        head.child.child.child = new Node(30);

        head.next.child = new Node(20);

        head.next.next.child = new Node(22);
        head.next.next.child.child = new Node(50);

        head.next.next.next.child = new Node(35);
        head.next.next.next.child.child = new Node(40);
        head.next.next.next.child.child.child = new Node(45);

        printOriginalLinkedList(head, 0);

        Node newHead = flatternOA(head);
        System.out.println("\nFlattened Linked List:");
        printLinkedList(newHead);

    }

    // Print the original linked list in a grid-like structure
    public static void printOriginalLinkedList(Node head, int depth) {
        while (head != null) {
            System.out.print(head.data);
            if (head.child != null) {
                System.out.print(" -> ");
                printOriginalLinkedList(head.child, depth + 1);
            }
            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; ++i) {
                    System.out.print("| ");
                }
            }
            head = head.next;
        }
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.child;
        }
        System.out.println();
    }
}
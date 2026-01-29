import java.util.ArrayList;
import java.util.List;

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

public class OddEvenLL {
    public static Node oddEvenLLBFA(Node head) {
        if (head == null)
            return head;

        List<Integer> list = new ArrayList<>();
        Node temp = head;

        // store odd index nodes
        while (temp != null) {
            list.add(temp.data);
            if (temp.next != null)
                temp = temp.next.next;
            else
                break;
        }

        // store even index nodes
        temp = head.next;
        while (temp != null) {
            list.add(temp.data);
            if (temp.next != null)
                temp = temp.next.next;
            else
                break;
        }

        // rewrite linked list
        temp = head;
        int i = 0;
        while (temp != null) {
            temp.data = list.get(i++);
            temp = temp.next;
        }

        return head;
    }

    public static Node oddEvenLLOA(Node head) {
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;

        }
        odd.next = evenHead;
        return head;

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
        head = oddEvenLLBFA(head);
        print(head);
        head = oddEvenLLOA(head);
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
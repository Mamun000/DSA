import java.util.HashMap;

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

public class FindInsertionLL {
    public static Node findInsertionLLBFA(Node head1, Node head2) {
        Node temp = head1;
        HashMap<Node, Integer> map = new HashMap<>();

        while (temp != null) {
            map.put(temp, 1);
            temp = temp.next;
        }
        temp = head2;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public static Node findInsertionLLBA(Node head1, Node head2) {
        Node temp = head1;
        int n1 = 0;
        int n2 = 0;
        while (temp != null) {
            temp = temp.next;
            n1++;
        }
        temp = head2;
        while (temp != null) {
            temp = temp.next;
            n2++;
        }
        int dif = n1 - n2;
        if (dif < 0) {
            while (dif++ != 0) {
                head2 = head2.next;
            }
        } else {
            while (dif-- != 0) {
                head1 = head1.next;
            }
        }

        while (head1 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    public static Node findInsertionLLOA(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1.next != null || temp2.next != null) {
            if (temp1 == temp2)
                return temp1;
            if (temp1.next == null)
                temp1 = head2;
            if (temp2.next == null)
                temp2 = head1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Node common = new Node(7);
        common.next = new Node(8);
        common.next.next = new Node(9);

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = common;

        Node head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = common;

        System.out.println(findInsertionLLOA(head1, head2).data);

    }
}
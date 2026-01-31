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

public class ReverseLLinGroup {
    public static Node reverseLLinGroup(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node groupPrev = dummy;
        while (true) {
            Node kth = getKthNode(groupPrev, k);
            if (kth == null)
                break;
            Node groupNext = kth.next;
            Node prev = groupNext;
            Node curr = groupPrev.next;
            for (int i = 0; i < k; i++) {
                Node temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            Node temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;

        }
        return dummy.next;

    }

    private static Node getKthNode(Node curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        int k = 2;
        Node newHead = reverseLLinGroup(head, k);
        Node curr = newHead;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }

    }
}
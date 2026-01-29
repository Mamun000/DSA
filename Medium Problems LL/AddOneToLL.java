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

public class AddOneToLL {
    public static Node addOneBFA(Node head) {
        head = reverse(head);

        Node current = head;
        int carry = 1;
        while (current != null && carry > 0) {
            int sum = current.data + carry;
            current.data = sum % 10;
            carry = sum / 10;
            current = current.next;
        }
        if (carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = head;
            head = newNode;
            return head;
        }

        head = reverse(head);
        return head;
    }

    public static Node addOneOA(Node head) {
        int carry = addOneUtil(head);
        if (carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public static int addOneUtil(Node node) {
        if (node == null) {
            return 1;
        }
        // Recurse to the end
        int carry = addOneUtil(node.next);
        int sum = node.data + carry;
        node.data = sum % 10;
        // Return new carry
        return sum / 10;
    }

    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);
        head = addOneOA(head);
        print(head);
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println();
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node newNode = current.next;
            current.next = prev;
            prev = current;
            current = newNode;
        }
        return prev;
    }
}
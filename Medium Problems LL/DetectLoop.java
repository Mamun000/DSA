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

public class DetectLoop {

    public static boolean detectLoopBFA(Node head) {
        Node temp = head;
        HashMap<Node, Integer> map = new HashMap<>();

        while (temp != null) {
            if (map.containsKey(temp)) {
                return true;
            }
            map.put(temp, 1);
            temp = temp.next;
        }
        return false;

    }

    public static boolean detectLoopOA(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow;
        Node fast;
        slow = head;
        fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next;
        System.out.println(detectLoopBFA(head));
        System.out.println(detectLoopOA(head));
    }

}

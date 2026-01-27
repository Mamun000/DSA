import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.next = next;
        this.data = data;
    }
}

public class LengthOfLoop {
    public static int lengthOfLoopBFA(Node head) {
        Node temp = head;
        int count = 0;
        HashMap<Node, Integer> map = new HashMap<>();

        while (temp != null) {
            if (map.containsKey(temp)) {
                return count - map.get(temp);
            }

            map.put(temp, count);
            temp = temp.next;
            count++;
        }
        return 0;
    }

    public static int lengthOfLoopOA(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null || fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int count = 1;
                while (fast.next != slow) {
                    fast = fast.next;
                    count++;
                }
                return count;
            }

        }
        return 0;

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        // Linking the nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Creating a loop from fifth to second
        fifth.next = second;
        System.out.println(lengthOfLoopBFA(head));
        System.out.println(lengthOfLoopOA(head));
    }
}
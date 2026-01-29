import java.util.Map;
import java.util.HashMap;

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

public class FindPairSumDLL {
    public static Map<Integer, Integer> findPairSumDLL(Node head, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Node current = head;
        while (current != null) {
            int complement = target - current.data;
            if (map.containsKey(complement)) {
                return map;
            }
            map.put(current.data, complement);
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.prev = head;
        head.next.next = new Node(30);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(40);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.prev = head.next.next.next;
        int target = 70;
        Map<Integer, Integer> result = findPairSumDLL(head, target);
        if (result != null) {
            System.out.println("Pair found: " + result.keySet() + " + " + result.values());
        } else {
            System.out.println("No pair found with sum " + target);
        }

    }

}

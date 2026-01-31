class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}

public class CloneLLwithRandomPointer {
    public static Node copyNodeBFA(Node head) {
        // If the original list
        // is empty, return null
        if (head == null)
            return null;

        // Step 1: Insert copy of
        // nodes in between
        insertCopyInBetween(head);
        // Step 2: Connect random
        // pointers of copied nodes
        connectRandomPointers(head);
        // Step 3: Retrieve the deep
        // copy of the linked list
        return getDeepCopyList(head);
    }

    public static void insertCopyInBetween(Node head) {
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            Node copyNode = new Node(curr.val);
            curr.next = copyNode;
            copyNode.next = next;
            curr = next;
        }
    }

    public static void connectRandomPointers(Node head) {
        Node curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
    }

    public static Node getDeepCopyList(Node head) {
        Node curr = head;
        Node deepCopyHead = head.next;
        while (curr != null && curr.next != null) {
            Node next = curr.next.next;
            curr.next.next = next != null ? next.next : null;
            curr = next;
        }
        return deepCopyHead;
    }

    public static void main(String[] args) {
        // Example linked list: 7 -> 14 -> 21 -> 28
        Node head = new Node(7);
        head.next = new Node(14);
        head.next.next = new Node(21);
        head.next.next.next = new Node(28);

        // Assigning random pointers
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

        System.out.println("Original Linked List with Random Pointers:");
        printClonedLinkedList(head);

        // Clone the linked list
        Node clonedList = copyNodeBFA(head);

        System.out.println("\nCloned Linked List with Random Pointers:");
        printClonedLinkedList(clonedList);

    }

    public static void printClonedLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            int randomVal = (curr.random != null) ? curr.random.val : -1;
            System.out.println("Node Value: " + curr.val + ", Random points to: " + randomVal);
            curr = curr.next;
        }
    }

}

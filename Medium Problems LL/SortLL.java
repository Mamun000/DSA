import java.util.ArrayList;
import java.util.Collections;
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
public class SortLL
{
   public static Node SortfLLBFA(Node head){
       Node temp=head;
       ArrayList<Integer> arr=new ArrayList<>();
       while(temp!=null){
           arr.add(temp.data);
           temp=temp.next;
       }
       Collections.sort(arr);
        temp = head;
        for (int i = 0; i < arr.size(); i++) {
            temp.data = arr.get(i);
            temp = temp.next;
        }
        return head;
   }
    
	public static void main(String[] args) {
		Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(5);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(1);

        // Print original list
        System.out.print("Original Linked List: ");
        printLinkedList(head);
        head = SortfLLBFA(head);
        System.out.print("Sorted Linked List: ");
        printLinkedList(head);
	}
	 static void printLinkedList(Node head) {
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
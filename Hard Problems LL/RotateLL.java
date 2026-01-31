class Node{
    int data;
    Node next;
    Node (int data){
        this.data=data;
        this.next=null;
    }
    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
}
public class RotateLL{
    public static Node rotateLL(Node head, int k){
        if (head == null || head.next == null || k == 0)
            return head;
        Node temp=head;
        int count=1;
        while(temp.next!=null){
            count++;
            temp=temp.next;
        }
        temp.next=head;
        k=k%count;
        int step=count-k;
        Node newTail=head;
        for(int i=1;i<step;i++){
            newTail=newTail.next;
        }
        Node newHead=newTail.next;
        newTail.next=null;
        return newHead;
    }
    public static void main(String[]args){
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        int k=2;
        Node newHead=rotateLL(head,k);
        Node curr=newHead;
        print(curr);

    }
    public static void print(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
}
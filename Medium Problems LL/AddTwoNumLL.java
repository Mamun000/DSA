class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
    Node(int data, Node next){
        this.data=data;
        this.next=next;
    }
}
public class AddTwoNumLL
{
    public static Node addTwoNum(Node head1, Node head2){
        Node dummy=new Node(-1);
        Node temp=dummy;
        int carry=0;
        while(head1!=null || head2!=null || carry!=0){
            int sum=0;
            if(head1!=null){
                sum+=head1.data;
                head1=head1.next;
            }
            if(head2!=null){
                sum+=head2.data;
                head2=head2.next;
            }
            sum+=carry;
            carry=sum/10;
            
            Node newNode=new Node(sum%10);
            temp.next=newNode;
            temp=temp.next;
        }
        return dummy.next;
    }
    
	public static void main(String[] args) {
        Node head1=new Node(2);
        head1.next=new Node(4);
        head1.next.next=new Node(3);
        
        Node head2=new Node(5);
        head2.next=new Node(6);
        head2.next.next=new Node(4);
        
        Node result=addTwoNum(head1,head2);
        print(result);
		
	}
    public static void print(Node head){
        while(head!=null){
            System.out.print(head.data+"->");
            head=head.next;
        }
        System.out.println();
    }
	
}
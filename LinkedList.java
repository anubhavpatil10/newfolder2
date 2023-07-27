import java.util.Stack;

public class LinkedList {
	
	private Node head;

	public LinkedList() {
		super();
		this.head=null;
	}
	
	
	public Node getHead() {
		return head;
	}



	public boolean insert(int data) {
		
		Node newNode = new Node(data);
		if(newNode==null)
			return false;
		
		if(head==null) 
		{
			head=newNode;
			return true;
		}
		
		Node last =head;
		
		while(last.getNext()!=null)   //find last node of list
		{
			last = last.getNext();
		}
		
		last.setNext(newNode);   //add newNode at the last list
		return true; 
	}
	
	public void display() {
		
		if(head==null)
		{
			System.out.println("Empty list !!");
		}
		else
		{
			Node last = head;
			while(last!=null)
			{
				System.out.print(last.getData()+" ");
				last = last.getNext();
			}
			System.out.println("\n");
		}
	}
	
	public void displayRev() {
		
		Node temp = head;
		
		Stack<Node> stack = new Stack<>();
		
		while(temp!=null)
		{
			stack.push(temp);
			temp = temp.getNext();
		}
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop().getData()+" ");
		}
		System.out.println("\n");
	}
	
	public void displayRev(Node head) {
		
		if(head==null)
		{
			return;
		}
		
		displayRev(head.getNext());
		System.out.print(head.getData()+" ");
	}
	
	public boolean insert(int data, int position) {
		
		if(position<=0 || (head==null && position>1))
		{
			return false;
		}
		
		Node newNode = new Node(data);
		if(newNode==null)
			return false;
		
		if(position==1)
		{
			newNode.setNext(head);
			head=newNode;
			return true;
		}
		
		Node prev=head;
		for(int i=1 ; i < position-1 ; i++) //find previous position of given position
		{
			prev = prev.getNext();
		}
		
		newNode.setNext(prev.getNext());
		prev.setNext(newNode);
		return true;
		
		
	}
	
	public boolean deleteByValue(int data)
	{
		if(head==null)
		{
			return false;
		}
		
		if(head.getData()==data)
		{
			head = head.getNext();
		}
		
		Node prev = head, del = head;
		while(del.getData()!= data)
		{
			prev=del;
			del = del.getNext();
			if(del==null)
			{
				System.out.println(data + " is not in the list");
				return false;
			}
		}
		
		prev.setNext(del.getNext());
		return true;
		
	}
	
	public boolean deleteByPosition(int position)
	{
		if(position<=0 || head == null)
		{
			return false;
		}
		
		if(position==1)
		{
			head = head.getNext();
			return true;
		}
		
		Node prev = head;
		for(int i=1 ; i < position -1 ; i++)
		{
			prev = prev.getNext();
			if(prev.getNext()==null)
				return false;
		}
		
		Node del = prev.getNext();
		prev.setNext(del.getNext());
		return true;
	}
	
	public void reverse()
	{
		if(head == null || head.getNext() == null)
			return;
		
		Node n1 = head, n2 = head.getNext(), n3 = null;
		
		while(n2!=null)
		{
			n3 = n2.getNext();
			n2.setNext(n1);
			n1= n2;
			n2=n3;
		}
		
		head.setNext(null);
		head = n1;
	}
	
	public void reverse (Node n1 , Node n2)
	{
		if(n2==null)
		{
			head.setNext(null);
			head = n1;
			return;
		}
		
		reverse(n2, n2.getNext());
		n2.setNext(n1);
	}
	
	public boolean insertAtBegining(int data)
	{
		Node newNode = new Node(data);
		if(head==null)
		{
			head=newNode;
			return true;
		}
		newNode.setNext(head);
		head = newNode;
		return true;
		
	}
	
	public boolean deleteAtFirst()
	{
		if(head==null)
			return false;
		
		head = head.getNext();
		return true;
		
	}
	
	public boolean deleteAtLast()
	{
		if(head==null)
			return false;
		
		Node last=head,prev=head;
		
		while(last.getNext()!=null)
		{
			prev = last;
			last = last.getNext();
		}
		
		prev.setNext(null);
		return true;
	}
	
	

}

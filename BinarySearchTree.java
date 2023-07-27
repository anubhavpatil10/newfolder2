import java.util.Stack;

public class BinarySearchTree {
	
	private Node root;

	public BinarySearchTree() {
		this.root = null;
	}
	
	public boolean insert(int data) {
		
		Node newNode = new Node(data);
		if(newNode == null)
		{
			return false;
		}
		
		if(root == null) {
			root=newNode;
			return true;
		}
		
		Node temp = root;
		
		while(true) {
			if(data == temp.getData())
				return false;
			
			if(data<temp.getData())
			{
				//insert data into left node
				//check temp already having left node or not
				if(temp.getLeft()==null)
				{
					temp.setLeft(newNode);
					return true;
				}
				temp=temp.getLeft();
			}
			else
			{
				//insert data into right node
				//check temp alrady having right node or not
				if(temp.getRight()==null)
				{
					temp.setRight(newNode);
					return true;
				}
				temp = temp.getRight();
			}
		}
		
		
	}
	
	public void preOrder() {
		
		Node temp = root;
		
		Stack<Node> stack = new Stack<Node>();
		
		while(temp!= null || !stack.empty())
		{
			while(temp!=null)
			{
				System.out.print(temp.getData()+" ");
				stack.push(temp);
				temp = temp.getLeft();
			}
			
			temp = stack.pop().getRight();
		}
		System.out.println("\n");
		
	}
	
	public void inOrder() {
		Node temp = root;
		Stack<Node> stack = new Stack<>();
		
		while(temp!=null || !stack.empty())
		{
			while(temp!=null)
			{
				stack.push(temp);
				temp = temp.getLeft();
				
			}
			temp=stack.pop();
			System.out.print(temp.getData()+" ");
			temp = temp.getRight();
		}
		System.out.println("\n");
	}
	
	public int getMax() {
		
		if(root==null)
			return -1;
		
		Node temp = root;
		while(temp.getRight()!=null) {
			temp = temp.getRight();
		}
		return temp.getData();
	}
	
	public boolean find(int data)
	{
		Node temp = root;
		
		while(temp!=null)
		{
			if(temp.getData()==data)
			{
				return true;
			}
			if(data<temp.getData())
			{
				//to find data in left node
				temp = temp.getLeft();
			}
			else
			{
				//to find data in right node
				temp = temp.getRight();
			}
		}
		return false;
	}
	
	public void postOrder() {
		
		class Pair{
			Node node;
			char flag;
			
			public Pair(Node node,char flag)
			{
				this.node = node;
				this.flag = flag;
			}
		}
		
		Node temp = root;
		Stack<Pair> stack = new Stack<>();
		
		while(temp!=null || !stack.isEmpty())
		{
			while(temp!=null)
			{
				stack.push(new Pair(temp, 'L'));
				temp = temp.getLeft();
			}
			
			Pair pair = stack.pop();
			if(pair.flag=='L')
			{
				temp = pair.node.getRight();
				pair.flag = 'R';
				stack.push(pair);
			}
			else
			{
				System.out.print(pair.node.getData()+ " ");
			}
		}
		
		System.out.println("\n");
	}
	
	
	public boolean delete(int data)
	{
		if(root==null)
		{
			return false;
		}
		
		Node parent = root , del = root;
		
		while(del.getData()!=data)
		{
			if(data<del.getData())
			{
				parent = del;
				del = del.getLeft();
			}
			else
			{
				parent = del;
				del = del.getRight();
			}
			if(del==null)
			{
				return false;
			}
		}
		
		while(true)
		{
			if(del.getLeft()==null && del.getRight()==null)
			{
				if(del == root)
				{
					root = null;
					return true;
				}
				if(parent.getLeft()==del)
				{
					parent.setLeft(null);
				}
				else
				{
					parent.setRight(null);
				}
				return true;
			}
			
			//if del is non terminal node
			
			//find max from left subtree or find min from right subtree
			if(del.getLeft()!=null)
			{
				parent = del;
				Node max = del.getLeft();
				while(max.getRight()!=null)
				{
					parent = del;
					max = max.getRight();
				}
				
				int temp = del.getData();
				del.setData(max.getData());
				max.setData(temp);
				
				del = max;
			}
			else
			{
				parent = del;
				Node min = del.getRight();
				while(min.getLeft()!=null)
				{
					parent= min;
					min = min.getLeft();
				}
				
				int temp = del.getData();
				del.setData(min.getData());
				min.setData(temp);
				
				del = min;
			}
			
			
			
		}
	}
	

}

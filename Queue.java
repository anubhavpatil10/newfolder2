package queue;

public class Queue {
	private int[] arr;
	private int front,rear;
	private int size;
	
	public Queue(int size) {
		this.size = size;
		this.arr = new int[size];
		this.front = this.rear = -1;
		
	}
	
	public boolean isEmpty()
	{
		return ((this.rear==-1 && this.front==-1) || (front>rear));
	}
	
	public boolean isFull()
	{
		return rear==size-1;
	}
	
	public boolean insert(int data)
	{
		if(isFull())
			return false;
		
		arr[++rear]=data;
		if(front==-1)
			front=0;
		return true;
	}
	
	public int delete() 
	{
		if(isEmpty())
			return -1;
		
		return arr[front++];
	}
	

}

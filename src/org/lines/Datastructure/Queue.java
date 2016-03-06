package org.lines.Datastructure;

public class Queue {
	private int Size;
	private long[] Array;
	private int front;
	private int rear;
	private int nItems;
	
	public Queue(){
		this.Size=10;
		Array=new long[10];
		this.front=0;
		this.rear=-1;
		nItems=0;
	}
	
	public Queue(int size){
		this.Size=size;
		Array=new long[Size];
		this.front=0;
		this.rear=-1;
		nItems=0;
	}
	
	public void insert(long elem){
		if(rear==Size-1)
			rear=-1;
		Array[++rear]=elem;
		nItems++;
	}
	
	public long remove(){
		if(front==Size)
			front=0;
		nItems--;
		return Array[front++];
	}
	
	public long peek(){
		return Array[front];
	}
	
	public boolean isEmpty(){
		return (nItems==0);
	}
	
	public boolean isFull(){
		return (nItems==Size);
	}
	
	public int getSize(){
		return Size;
	}

}

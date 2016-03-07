package org.lines.Datastructure;

public class DoubleLinklist {
	public DLinklist head;
	public DLinklist end;
	
	public DoubleLinklist(int data){
		head=new DLinklist(data);
		head.next=null;
		head.previous=null;
	}
	public boolean isEmpty(){
		return (head==null);
	}
	
	public void inserthead(int data){
		DLinklist current=new DLinklist(data);
		if(!isEmpty()){
			head.previous=current;
			current.next=head;
			head=current;
		}
		else
			head=new DLinklist(data);
	}
	
	public DLinklist find(int key){
		DLinklist current=head;
		current.previous=head;
		
		if(!isEmpty()){
			while(current.next!=null){
				if(current.getdata()!=key){
					current=current.next;
				}
				else
					break;
			}
			return current;
		}
		else
			return null;
	}
	
	public void delete(int key){
		DLinklist current=head;
		
		if(!isEmpty()){
			while(current.next!=null){
				if(current.getdata()!=key){
					current=current.next;
				}
				else
					break;
			}
			current
		}
		else
			System.out.println("linklist is empty");
	}

}

class DLinklist{
	private int data;
	public DLinklist previous;
	public DLinklist next;
	
	public DLinklist(int data){
		this.data=data;
		previous=null;
		next=null;
	}
	
	public void display(){
		System.out.println(data);
	}
	
	public int getdata(){
		return this.data;
	}
}

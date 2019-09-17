package csDataStruct;
import interfacePackage.*;

public class LinkedListQueue<E> implements Queue<E> {
	
	private class Node{
		public E e;
		public Node next;
		
		public Node(E e, Node node){
			this.e = e;
			this.next = node;
		}
		
		public Node(E e){
			this(e, null);
		}
		
		@Override
		public String toString(){
			return e.toString();
		}
	}
	
	private int size;
	private Node head;
	private Node tail;
	
	public LinkedListQueue(){
		size = 0;
		head = null;
		tail = null;
	}
	
	@Override
	public int getSize(){
		return size;
	}
	
	@Override
	public boolean isEmpty(){
		return size == 0;
	}
	
	@Override
	public void enqueue(E e){
		if(tail == null){
			tail = new Node(e);
			head = tail;
		}else{
			tail.next = new Node(e);
			tail = tail.next;
		}
		size++;
	}
	
	@Override
	public E dequeue(){
		if(isEmpty()){
			throw new IllegalArgumentException("cannot dequeue from an empty queue.");
		}
		
		Node node = head;
		head = head.next;
		size--;
		if(head == null){
			tail = null;
		}
		
		return node.e;
	}
	
	@Override
	public E getFront(){
		return head.e;
	}
	
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append("LinkedListQueue: size=" + size + "\n head [");
		Node node = head;
		while(node != null){
			res.append(node.e);
			node = node.next;
			if(node != null){
				res.append(", ");
			}
		}
		res.append("] tail");
		
		return res.toString();
	}
}

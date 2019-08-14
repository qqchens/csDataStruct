package csDataStruct;

import interfacePackage.*;

public class LinkedListStack<E> implements Stack<E> {
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

		public Node(){
			this(null, null);
		}

		@Override
		public String toString(){
			return e.toString();
		}
	}
	
	private int size;
	private Node dummyhead;
	public LinkedListStack() {
		size = 0;
		dummyhead = new Node();
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
	public void push(E e){
		dummyhead.next = new Node(e, dummyhead.next);
		size++;
	}
	
	@Override
	public E pop(){
		if(isEmpty()){
			throw new IllegalArgumentException("cannot pop from an empty stack.");
		}
		
		Node node = dummyhead.next;
		dummyhead.next = node.next;
		node.next = null;
		size--;
		return node.e;
	}
	
	@Override
	public E peek(){
		if(isEmpty()){
			throw new IllegalArgumentException("empty stack.");
		}
		
		return dummyhead.next.e;
	}
	
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append("LinkedListStack: size=" + size + "\ntop [");
		Node node = dummyhead.next;
		while(node != null){
			res.append(node.e);
			node = node.next;
			if(node != null){
				res.append(", ");
			}
		}
		res.append("]");
		return res.toString();
		
	}
	
}

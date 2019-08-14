package csDataStruct;

public class LinkedList<E> {

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
	
	public LinkedList(){
		dummyhead = new Node();
		size = 0;
	}
	
	//返回链表元素个数
	public int getSize(){
		return size;
	}
	
	//检查是否为空
	public boolean isEmpty(){
		return size == 0;
	}
	
	//向链表中增加元素
	public void add(int index, E e){
		if(index < 0 || index > size){
			throw new IllegalArgumentException("illegal index.");
		}
		
		Node pre = dummyhead;
		for(int i=0;i<index;i++){
			pre = pre.next;
		}
		
		Node newNode = new Node(e);
		newNode.next = pre.next;
		pre.next = newNode;
//		pre.next = new Node(e, pre.next);	//等价于上面三句
		
		size++;
	}
	
	//链表首位增加元素
	public void addFirst(E e){
		add(0, e);
	}
	
	//链表末位增加元素
	public void addLast(E e){
		add(size, e);
	}
	
	//查找元素
	public E get(int index){
		if(index < 0 || index >= size){
			throw new IllegalArgumentException("illegal index.");
		}
		
		Node node = dummyhead.next;
		for(int i=0;i<index;i++){
			node = node.next;
		}
		
		return node.e;
	}
	
	//查找首位元素
	public E getFirst(){
		return get(0);
	}
	
	//查找末位元素
	public E getLast(){
		return get(size-1);
	}
	
	//删除元素
	public E remove(int index){
		if(index < 0 || index >= size){
			throw new IllegalArgumentException("illegal index.");
		}
		Node pre = dummyhead;
		for(int i=0;i<index;i++){
			pre = pre.next;
		}
		
		Node delNode = pre.next;
		pre.next = delNode.next;
		delNode.next = null;
		size--;
		return delNode.e;
	}
	
	//删除首位
	public E removeFirst(){
		return remove(0);
	}
	
	//删除末位
	public E removeLast(){
		return remove(size-1);
	}
	
	//修改元素
	public void set(int index, E e){
		if(index < 0 || index >= size){
			throw new IllegalArgumentException("illegal index.");
		}
		
		Node pre = dummyhead.next;
		for(int i=0;i<index;i++){
			pre = pre.next;
		}
		pre.e = e;
	}
	
	//是否包含元素
	public boolean contains(E e){
		Node node = dummyhead.next;
		while(node != null){
			if(node.e.equals(e)){
				return true;
			}
			node = node.next;
		}
		return false;
	}
	
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append("LinkedList: size=" + size + "\n");
		Node node = dummyhead.next;
		while(node != null){
			res.append(node.e.toString() + "--> ");
		}
		res.append("NULL");
		
		return res.toString();
	}
}

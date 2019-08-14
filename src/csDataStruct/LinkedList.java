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
	
	//��������Ԫ�ظ���
	public int getSize(){
		return size;
	}
	
	//����Ƿ�Ϊ��
	public boolean isEmpty(){
		return size == 0;
	}
	
	//������������Ԫ��
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
//		pre.next = new Node(e, pre.next);	//�ȼ�����������
		
		size++;
	}
	
	//������λ����Ԫ��
	public void addFirst(E e){
		add(0, e);
	}
	
	//����ĩλ����Ԫ��
	public void addLast(E e){
		add(size, e);
	}
	
	//����Ԫ��
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
	
	//������λԪ��
	public E getFirst(){
		return get(0);
	}
	
	//����ĩλԪ��
	public E getLast(){
		return get(size-1);
	}
	
	//ɾ��Ԫ��
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
	
	//ɾ����λ
	public E removeFirst(){
		return remove(0);
	}
	
	//ɾ��ĩλ
	public E removeLast(){
		return remove(size-1);
	}
	
	//�޸�Ԫ��
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
	
	//�Ƿ����Ԫ��
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

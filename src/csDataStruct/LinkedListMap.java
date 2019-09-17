package csDataStruct;

import interfacePackage.Map;

public class LinkedListMap<K, V> implements Map<K, V> {
	
	private class Node{
		public K key;
		public V value;
		public Node next;
		
		public Node(K k, V v, Node node){
			this.key = k;
			this.value = v;
			this.next = node;
		}
		public Node(K k, V v){
			this(k, v, null);
		}
		public Node(){
			this(null, null);
		}
		
		@Override
		public String toString(){
			return key.toString() + ":" + value.toString();
		}
		
	}
	
	private Node dummyHead;
	private int size;
	
	public LinkedListMap() {
		dummyHead = new Node();
		size = 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(K k) {
		
		return getNode(k) != null;
	}
	
	//获取k对应的节点
	private Node getNode(K k){
		Node node = dummyHead.next;
		while(node != null){
			if(node.key.equals(k)){
				return node;
			}
			node = node.next;
		}
		return null;
	}

	@Override
	public void add(K k, V v) {
		Node node = getNode(k);
		if(node == null){
			dummyHead.next = new Node(k, v, dummyHead.next);
			size++;
		}
		else{
			//可以不处理，也可以更新key的值
		}
		
	}

	@Override
	public void set(K k, V v) {
		Node node = getNode(k);
		if(node == null){
			throw new IllegalArgumentException(k + "doesn't exist!");
		}
		node.value = v;
	}

	@Override
	public V get(K k) {
		Node node = getNode(k);
		if(node == null){
			throw new IllegalArgumentException(k + "doesn't exist!");
		}
		return node.value;
	}

	@Override
	public V remove(K k) {
		Node pre = dummyHead;
		while(pre.next != null){
			if(pre.next.key.equals(k)){
				break;
			}
			pre = pre.next;
		}
		
		if(pre.next != null){
			Node del = pre.next;
			pre.next = del.next;
			del.next = null;
			size --;
			return del.value;
		}
		
		return null;
	}

	public static void main(String[] args) {
		Main main = new Main();
		Map map = new LinkedListMap<>();
		String filename = "/csDataStruct/src/csDataStruct/PrideAndPrejudice.txt";
		double cost = main.testMap(map, filename);
		System.out.println("BSTMap Cost:" + cost);
	}
	
}

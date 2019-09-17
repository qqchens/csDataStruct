package csDataStruct;

import interfacePackage.Map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

	private class Node{
		public K key;
		public V value;
		public Node left, right;

		public Node(K k, V v){
			this.key = k;
			this.value = v;
			this.left = null;
			this.right = null;
		}
	}
	
	private Node root;
	private int size;
	
	public BSTMap() {
		root = null;
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
	
	private Node getNode(K k){
		Node node = root;
		while(node != null){
			if(node.key.compareTo(k) < 0){
				node = node.right;
			}else if(node.key.compareTo(k) > 0){
				node = node.left;
			}else{
				return node;
			}
		}
		return node;
	}

	@Override
	public boolean contains(K k) {
		return getNode(k) != null;
	}

	@Override
	public void add(K k, V v) {
		root = add(root, k, v);
	}
	
	private Node add(Node node, K k, V v){
		if(node == null){
			size++;
			return new Node(k, v);
		}
		
		if(node.key.compareTo(k) < 0){
			node.right = add(node.right, k, v);
		}else if(node.key.compareTo(k) > 0){
			node.left = add(node.left, k, v);
		}else{
			node.value = v;
		}
		
		return node;
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
		return node == null ? null : node.value;
	}

	@Override
	public V remove(K k) {
		Node node = getNode(k);
		if(node != null){
			root = remove(root, k);
			return node.value;
		}
		
		return null;
	}
	
	private Node remove(Node node, K k){
		if(node == null){
			return null;
		}
		
		if(node.key.compareTo(k) < 0){
			node.right = remove(node.right, k);
			return node;
		}else if(node.key.compareTo(k) > 0){
			node.left = remove(node.left, k);
			return node;
		}else{
			if(node.left == null){
				Node rightNode = node.right;
				node.right = null;
				return rightNode;
			}
			
			if(node.right == null){
				Node leftNode = node.left;
				node.left = null;
				return leftNode;
			}
			
			Node newNode = miniNode(node.right);
			newNode.left = node.left;
			newNode.right = removeMini(node.right);
			node.left = node.right = null;
			size--;
			return newNode;
		}
		
	}
	
	private Node miniNode(Node node){
		if(node.left == null){
			return node;
		}
		return miniNode(node.left);
	}
	
	private Node removeMini(Node node){
		if(node.left == null){
			Node rightNode = node.right;
			node.right = null;
			size--;
			return rightNode;
		}
		
		node.left = removeMini(node.left);
		return node;
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		Map map = new BSTMap<>();
		String filename = "/csDataStruct/src/csDataStruct/PrideAndPrejudice.txt";
		double cost = main.testMap(map, filename);
		System.out.println("BSTMap Cost:" + cost);
	}

}

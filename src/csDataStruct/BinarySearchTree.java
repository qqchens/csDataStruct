package csDataStruct;

public class BinarySearchTree<E extends Comparable<E>> {

	private class Node{
		public E e;
		public Node left, right;
		
		public Node(E e){
			this.e = e;
			this.left = null;
			this.right = null;
		}
	}
	
	private int size;
	private Node root;
	
	public BinarySearchTree(){
		this.size = 1;
		this.root = null;
	}
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	//�������в���Ԫ��
	public void add(E e){
		root = add(root, e);
	}
	
	//�������в���Ԫ�أ��ݹ�ʵ�֣�
	private Node add(Node node, E e){
		if(node == null){
			size ++;
			return new Node(e);
		}else if(e.compareTo(node.e) < 0){
			return add(node.left, e);
		}else if(e.compareTo(node.e) > 0){
			return add(node.right, e);
		}
		return node;
	}
	
	//�������в���Ԫ�أ��ǵݹ�ʵ�֣�
	public void loop_add(E e){
		if(root == null){
			root = new Node(e); 
			return;
		}
		Node node = root;
		while(node != null){
			if(e.compareTo(node.e) < 0){
				node = node.left;
			}else if(e.compareTo(node.e) > 0){
				node = node.right;
			}else{
				return;
			}
		}
		node = new Node(e);
	}
	
	//����Ƿ����ĳԪ��
	public boolean contains(E e){
		return contains(root, e);
	}
	
	//����Ƿ����ĳԪ�أ��ݹ�ʵ�֣�
	private boolean contains(Node node, E e){
		if(node == null){
			return false;
		}else if(e.compareTo(node.e) < 0){
			return contains(node.left, e);
		}else if(e.compareTo(node.e) > 0){
			return contains(node.right, e);
		}
		return true;
	}
	
	//����Ƿ����ĳԪ�أ��ǵݹ�ʵ�֣�
	public boolean loop_contains(E e){
		if(isEmpty()){
			return false;
		}
		Node node = root;
		while(node != null){
			if(e.compareTo(node.e) < 0){
				node = node.left;
			}else if (e.compareTo(node.e) > 0){
				node = node.right;
			}else{
				return true;
			}
		}
		return false;
	}
}

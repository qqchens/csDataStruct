package csDataStruct;

import java.util.Stack;

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

	//����Ԫ�ظ����͸��ڵ�
	private int size;
	private Node root;

	public BinarySearchTree(){
		this.size = 0;
		this.root = null;
	}

	//��ȡ����Ԫ�ظ���
	public int getSize(){
		return size;
	}

	//������Ƿ�Ϊ��
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
			node.left = add(node.left, e);
		}else if(e.compareTo(node.e) > 0){
			node.right = add(node.right, e);
		}
		return node;
	}

	//�������в���Ԫ�أ��ǵݹ�ʵ�֣�
	public void addNotRec(E e){
		Node node = root;
		size ++;
		while(node != null){
			if(e.compareTo(node.e) < 0){
				if(node.left == null){
					node.left = new Node(e);
					return;
				}
				node = node.left;
			}else if(e.compareTo(node.e) > 0){
				if(node.right == null){
					node.right = new Node(e);
					return;
				}
				node = node.right;
			}else{
				return;
			}
		}
		root = new Node(e);
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
	public boolean containsNotRec(E e){
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

	//ǰ�����
	public String DLR(){
		String res = DLR_imp(root);
		return res;
	}

	//ǰ�����ʵ��
	private String DLR_imp(Node node){

		if(node == null){
			return "";
		}else{
			StringBuilder res = new StringBuilder();
			res.append(node.e.toString());
			res.append(DLR_imp(node.left));
			res.append(DLR_imp(node.right));
			return res.toString();
		}
	}

	//�������
	public String LDR(){
		String res = LDR_imp(root);
		return res;
	}

	//�������ʵ��
	private String LDR_imp(Node node){

		if(node == null){
			return "";
		}else{
			StringBuilder res = new StringBuilder();
			res.append(LDR_imp(node.left));
			res.append(node.e.toString());
			res.append(LDR_imp(node.right));
			return res.toString();
		}
	}

	//�������
	public String LRD(){
		String res = LRD_imp(root);
		return res;
	}

	//�������ʵ��
	private String LRD_imp(Node node){

		if(node == null){
			return "";
		}else{
			StringBuilder res = new StringBuilder();
			res.append(LRD_imp(node.left));
			res.append(LRD_imp(node.right));
			res.append(node.e.toString());
			return res.toString();
		}
	}
	
	//ǰ��������ǵݹ�ʵ�֣�
	public String DLRNotRec(){
		if(isEmpty()){
			throw new IllegalArgumentException("can not traversing an empty tree.");
		}
		Stack<Node> s = new Stack<>();
		Node node = root;
		
		s.push(node);
		StringBuffer res = new StringBuffer();
		while(!s.isEmpty()){
			node = s.pop();
			res.append(node.e);
			if(node.right != null){
				s.push(node.right);
			}
			if(node.left != null){
				s.push(node.left);
			}
		}
		
		return res.toString();
	}
	
	//����������ǵݹ�ʵ�֣�
	public String LRDNotRec(){
		if(isEmpty()){
			throw new IllegalArgumentException("can not traversing an empty tree.");
		}
		Stack<Node> s = new Stack<>();
		Node node = root;
		s.push(node);
		StringBuffer res = new StringBuffer();
		
		while(!s.isEmpty()){
			node = s.pop();
			res.insert(0, node.e);
			if(node.left != null){
				s.push(node.left);
			}
			if(node.right != null){
				s.push(node.right);
			}
		}
		
		return res.toString();
	}
	//����������ǵݹ�ʵ�֣�
	public String LDRNotRec(){
		if(isEmpty()){
			throw new IllegalArgumentException("can not traversing an empty tree.");
		}
		Stack<Node> s = new Stack<>();
		Node node = root;
		StringBuffer res = new StringBuffer();
		
		while(!s.isEmpty() || node!=null){
			if(node != null){
				s.push(node);
				node = node.left;
			}else{
				node = s.pop();
				res.append(node.e);
				node = node.right;
			}
		}
		
		return res.toString();
	}
}

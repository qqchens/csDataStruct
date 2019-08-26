package csDataStruct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
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

	//树的元素个数和根节点
	private int size;
	private Node root;

	public BinarySearchTree(){
		this.size = 0;
		this.root = null;
	}

	//获取树种元素个数
	public int getSize(){
		return size;
	}

	//检查树是否为空
	public boolean isEmpty(){
		return size == 0;
	}

	//二叉树中插入元素
	public void add(E e){
		root = add(root, e);
	}

	//二叉树中插入元素（递归实现）
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

	//二叉树中插入元素（非递归实现）
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
				size--;
				return;
			}
		}
		root = new Node(e);
	}

	//检查是否包含某元素
	public boolean contains(E e){
		return contains(root, e);
	}

	//检查是否包含某元素（递归实现）
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

	//检查是否包含某元素（非递归实现）
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

	//前序遍历
	public String DLR(){
		String res = DLR_imp(root);
		return res;
	}

	//前序遍历实现
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

	//中序遍历
	public String LDR(){
		String res = LDR_imp(root);
		return res;
	}

	//中序遍历实现
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

	//后序遍历
	public String LRD(){
		String res = LRD_imp(root);
		return res;
	}

	//后序遍历实现
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
	
	//前序遍历（非递归实现）
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
	
	//后序遍历（非递归实现）
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
	//中序遍历（非递归实现）
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
	
	//层序遍历
	public String levelOrder(){
		if(isEmpty()){
			throw new IllegalArgumentException("can not traversing an empty tree.");
		}
		
		StringBuilder res = new StringBuilder();
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node node = q.remove();
			res.append(node.e);
			
			if(node.left != null){
				q.add(node.left);
			}
			
			if(node.right != null){
				q.add(node.right);
			}
		}
		
		return res.toString();
	}
	
	//获取最小元素
	public E getMin(){
		if(isEmpty()){
			throw new IllegalArgumentException("empty tree error.");
		}
//		return getMinElem(root).e;
		Node node = root;
		while(node.left != null){
			node = node.left;
		}
		
		return node.e;
	}
	
	//获取最大元素
	public E getMax(){
		if(isEmpty()){
			throw new IllegalArgumentException("empty tree error.");
		}
//		return getMaxElem(root).e;
		Node node = root;
		while(node.right != null){
			node = node.right;
		}
		
		return node.e;
	}
	
	//递归实现获取最小值、最大值
	public Node getMinElem(Node node){
		
		if(node.left == null){
			return node;
		}
		return getMinElem(node.left);
	}
	public Node getMaxElem(Node node){
		
		if(node.right == null){
			return node;
		}
		return getMaxElem(node.right);
	}
	
	//删除最大值、最小值
	public E removeMax(){
		E max = getMax();
		root = removeMaxElem(root);
		size--;
		return max;
	}
	public E removeMin(){
		E max = getMin();
		root = removeMinElem(root);
		size--;
		return max;
	}
	
	private Node removeMaxElem(Node node){
		if(node.right == null){
			Node newNode = node.left;
			node.left = null;
			
			return newNode;
		}
		node.right = removeMaxElem(node.right);
		return node;
	}
	private Node removeMinElem(Node node){
		if(node.left == null){
			Node newNode = node.right;
			node.right = null;
			return newNode;
		}
		node.left = removeMinElem(node.left);
		return node;
	}
	
	//删除任意元素
	public void remove(E e){
		root = remove(root, e);
		size --;
	}
	//删除函数-递归
	public Node remove(Node node,E e){
		if(node == null){
			return node;
		}
		
		if(node.e.compareTo(e) < 0){
			node.right = remove(node.right, e);
		}else if(node.e.compareTo(e) > 0){
			node.left = remove(node.left, e);
		}else{
			
			if(node.left == null){
				node = node.right;
			}else if(node.right == null){
				node = node.left;
			}else{
				Node newNode = getMinElem(node.right);
				newNode.left = node.left;
				newNode.right = removeMinElem(node.right);
				
				node.right = null;
				node = newNode;
			}
			
		}
		
		return node;
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		System.out.println(bst.getSize());
		for(int i=0;i<1000;i++){
			bst.add(random.nextInt(10000));
		}
		System.out.println(bst.getSize());
		
		List<Integer> l = new ArrayList<>();
		while(!bst.isEmpty()){
//			l.add(bst.removeMax());
			l.add(bst.removeMin());
		}
		System.out.println(l);
	}
	
}

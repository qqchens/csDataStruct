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
	public void loop_add(E e){
		Node node = root;
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
}

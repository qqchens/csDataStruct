package csDataStruct;

import interfacePackage.Merge;

public class SegementTree<E> {
	
	private E[] tree;
	private E[] data;
	private Merge<E> merge;
	
	@SuppressWarnings("unchecked")
	public SegementTree(E[] arr, Merge<E> merge){
		
		this.merge = merge;
		data = (E[])new Object[arr.length];
		for(int i=0; i<arr.length; i++){
			data[i] = arr[i];
		}
		
		tree = (E[])new Object[data.length * 4];
		buildSegementTree(0, 0, data.length-1);
	}
	
	public int getSize(){
		return data.length;
	}
	
	public E get(int index){
		if(index < 0 || index >= getSize()){
			throw new IllegalArgumentException("Index is illegal.");
		}
		
		return data[index];
	}
	
	private int leftChild(int index){
		return 2 * index + 1;
	}
	private int rightChild(int index){
		return 2 * index + 2;
	}
	private void buildSegementTree(int index, int left, int right){
		if(left == right){
			tree[index] = data[left];
			return;
		}
		
		int leftIndex = leftChild(index);
		int rightIndex = rightChild(index);
		int min = left + (right - left) / 2;
		
		buildSegementTree(leftIndex, left, min);
		buildSegementTree(rightIndex, min + 1, right);
		
		tree[index] = merge.merge(tree[leftIndex], tree[rightIndex]);
	}
	
	@Override
	public String toString(){
		StringBuffer res = new StringBuffer();
		res.append("[");
		
		for(int i=0; i<tree.length; i++){
			if(tree[i] != null){
				res.append(tree[i]);
			}else{
				res.append("null");
			}
			
			if(i != tree.length - 1){
				res.append(", ");
			}
		}
		res.append("]");
		
		return res.toString();
	}
	
	//统计线段树中的l-r范围
	public E query(int l, int r){
		
		if(l<0 || l>=data.length || r<0 || r>=data.length || r<l){
			throw new IllegalArgumentException("Index is illegal.");
		}
		
		return query(0, 0, data.length-1, l, r);
	}
	
	//递归调用，统计
	private E query(int index, int leftIndex, int rightIndex, int l, int r){
		if(l == r){
			return data[l];
		}
		
		int min = leftIndex + (rightIndex - leftIndex) / 2;
		int leftChildIndex = leftChild(index);
		int rightChildIndex = rightChild(index);
		if(min >= r){
			return query(leftChildIndex, leftIndex, min, l, r);
		}else if(min + 1 <= l){
			return query(rightChildIndex, min+1, rightIndex, l, r);
		}
		
		E leftChild = query(leftChildIndex, leftIndex, min, l, min);
		E rightChild = query(rightChildIndex, min+1, rightIndex, min+1, r);
		return merge.merge(leftChild, rightChild);
		
	}
	
	//更新线段树的某个值
	public void set(int index, E e){
		if(index<0 || index>=data.length){
			throw new IllegalArgumentException("Index is illegal.");
		}
		
		data[index] = e;
		set(0, 0, data.length-1, index, e);
	}
	
	//递归调用更新
	private void set(int root, int l, int r, int index, E e){
		
		if(l == r){
			tree[root] = e;
			return;
		}
		
		int min = l + (r - l) / 2;
		int leftChild = leftChild(root);
		int rightChild = rightChild(root);
		if(min >= index){
			set(leftChild, l, min, index, e);
		}else{
			set(rightChild, min+1, r, index, e);
		}
		
		tree[root] = merge.merge(tree[leftChild], tree[rightChild]);
		
	}

	public static void main(String[] args) {
		Integer[] num = {-2, 3, 5, 1, 0, 7};
		SegementTree<Integer> s = new SegementTree<>(num, new Merge<Integer>(){
			@Override
			public Integer merge(Integer a, Integer b){
				return a + b;
			}
		});
		
		System.out.println(s);
		s.set(3, 2);
		System.out.println(s);
		
		SegementTree<Integer> s2 = new SegementTree<>(num, (a, b) -> a * b);
		System.out.println(s2.query(0, 2));
	}

}

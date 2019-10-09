package csDataStruct;

import interfacePackage.Merge;

public class SegementTree<E> {
	
	private E[] tree;
	private E[] data;
	private Merge<E> merge;
	
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
	

	public static void main(String[] args) {
		Integer[] num = {-2, 3, 5, 1, 0, 7};
		SegementTree<Integer> s = new SegementTree<>(num, new Merge<Integer>(){
			@Override
			public Integer merge(Integer a, Integer b){
				return a + b;
			}
		});
		
		System.out.println(s);
		
		SegementTree<Integer> s2 = new SegementTree<>(num, (a, b) -> a * b);
		System.out.println(s2);
	}

}

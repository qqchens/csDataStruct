package csDataStruct;

import interfacePackage.Set;

public class BSTSet<E extends Comparable<E>> implements Set<E> {
	
	private BinarySearchTree<E> bstree;
	
	public BSTSet(){
		bstree = new BinarySearchTree<>();
	}
	
	@Override
	public void add(E e){
		bstree.addNotRec(e);
//		bstree.add(e);
	}
	
	@Override
	public void remove(E e){
		bstree.remove(e);
	}
	
	@Override
	public int getSize(){
		return bstree.getSize();
	}
	
	@Override
	public boolean isEmpty(){
		return bstree.isEmpty();
	}
	
	@Override
	public boolean contains(E e){
		return bstree.contains(e);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {1,2,3,4,5,5,5,5,7,6};
		
		BSTSet<Integer> s = new BSTSet<>();
		for(int i=0;i<nums.length;i++){
			s.add(nums[i]);
		}
		
		System.out.println(s.getSize());
		for(int i=0;i<nums.length;i++){
			System.out.println(s.contains(nums[i]));
		}

	}

}

package csDataStruct;

import interfacePackage.Set;

public class LinkedListSet<E> implements Set<E> {
	private LinkedList<E> list;
	
	public LinkedListSet(){
		list = new LinkedList<>();
	}
	
	@Override
	public void add(E e){
		if(!list.contains(e)){
			list.addFirst(e);
		}
	}
	
	@Override
	public void remove(E e){
		list.removeElement(e);
	}
	
	@Override
	public int getSize(){
		return list.getSize();
	}
	
	@Override
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	@Override
	public boolean contains(E e){
		return list.contains(e);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {1,2,3,4,4,4,4,4,4,4,4,8,5,5,5,5,7,6};
		
		LinkedListSet<Integer> s = new LinkedListSet<>();
		for(int i=0;i<nums.length;i++){
			s.add(nums[i]);
		}
		
		System.out.println(s.getSize());
		for(int i=0;i<nums.length;i++){
			System.out.println(s.contains(nums[i]));
		}

	}
}

package csDataStruct;

import interfacePackage.Queue;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
	
	private MaxHeap<E> maxHeap;
	
	public PriorityQueue(){
		this.maxHeap = new MaxHeap<>();
	}

	@Override
	public int getSize() {
		return maxHeap.getSize();
	}

	@Override
	public boolean isEmpty() {
		return maxHeap.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		maxHeap.add(e);
	}

	@Override
	public E dequeue() {
		return maxHeap.getMax();
	}

	@Override
	public E getFront() {
		return maxHeap.peak();
	}

	public static void main(String[] args) {
		int[] a = new int[]{1,3,5,7,9,1122,2,4,112,31,123,1223};
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<a.length;i++){
			pq.enqueue(a[i]);
		}
		
		while(!pq.isEmpty()){
			System.out.println(pq.dequeue());
		}

	}
}

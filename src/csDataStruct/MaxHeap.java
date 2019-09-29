package csDataStruct;

import java.util.Random;

public class MaxHeap<E extends Comparable<E>> {

	private Array<E> data;
	
	public MaxHeap(){
		data = new Array<>();
	}
	
	public MaxHeap(int capacity){
		data = new Array<>(capacity);
	}
	
	public int getSize(){
		return data.getSize();
	}
	
	public boolean isEmpty(){
		return data.isEmpty();
	}
	
	private int parent(int index){
		return (index - 1) / 2;
	}
	
	private int leftChild(int index){
		return index * 2 + 1;
	}
	
	private int rightChild(int index){
		return index * 2 + 2;
	}
	
	public void add(E e){
		data.addLast(e);
		siftUp(data.getSize() - 1);
	}
	
	private void siftUp(int index){
		while(index > 0 && data.get(index).compareTo(data.get(parent(index))) > 0){
			data.swap(index, parent(index));
			index = parent(index);
		}
	}
	
	public E getMax(){
		E e = data.getFirst();
		data.swap(0, data.getSize()-1);
		data.removeLast();
		siftDown(0);
		
		return e;
	}
	
	private void siftDown(int index){
		while(leftChild(index) < data.getSize()){
			int checkIndex = leftChild(index);
			if(checkIndex + 1 < data.getSize() && data.get(checkIndex + 1).compareTo(data.get(checkIndex)) > 0){
				checkIndex = rightChild(index);
			}
			
			if(data.get(index).compareTo(data.get(checkIndex)) > 0){
				break;
			}
			data.swap(index, checkIndex);
			index = checkIndex;
		}
	}
	
	public static void main(String[] args) {
		int num = 1000000;
		
		MaxHeap<Integer> m = new MaxHeap<>();
		Random r = new Random();
		for(int i=0; i<num; i++){
			m.add(r.nextInt(Integer.MAX_VALUE));
		}
		
		int[] arr = new int[num];
		for(int i=0; i<num; i++){
			arr[i] = m.getMax();
		}

		for(int i=0; i<num-1; i++){
			if(arr[i+1] > arr[i]){
				throw new IllegalArgumentException("Error.");
			}
		}
		
		System.out.println("Test MaxHeap Completed");
	}

}

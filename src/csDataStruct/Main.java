package csDataStruct;

import java.util.ArrayList;
import java.util.Random;

import interfacePackage.Map;
import interfacePackage.Queue;
import interfacePackage.Stack;

public class Main {

	public static void main(String[] args) {
		int testCount = 100000;
		//队列比较
//		ArrayQueue<Integer> a1 = new ArrayQueue<Integer>();
//		double time1 = testQueue(a1, testCount);
//		System.out.println("ArrayQueue 用时" + time1 + "ms。");
		
//		LoopQueue<Integer> a2 = new LoopQueue<Integer>();
//		double time2 = testQueue(a2, testCount);
//		System.out.println("LoopQueue 用时" + time2 + "ms。");
		
//		LinkedListQueue<Integer> a3 = new LinkedListQueue<Integer>();
//		double time3 = testQueue(a3, testCount);
//		System.out.println("LinkedListQueue 用时" + time3 + "ms。");
		
		//栈比较
//		LinkedListStack<Integer> a4 = new LinkedListStack<Integer>();
//		double time4 = testStack(a4, testCount);
//		System.out.println("LinkedListQueue 用时" + time4 + "ms。");
//		
//		ArrayStack<Integer> a5 = new ArrayStack<Integer>();
//		double time5 = testStack(a5, testCount);
//		System.out.println("LinkedListQueue 用时" + time5 + "ms。");
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
//		System.out.println(bst.getSize());
		for(int i=1;i<10;i=i+2){
			bst.addNotRec(i);
//			bst.add(i);
		}
		for(int i=1;i<10;i++){
			bst.addNotRec(i);
//			bst.add(i);
		}
		while(!bst.isEmpty()){
			System.out.println(bst.removeMin());
		}
		System.out.println(bst.getMax());
		System.out.println(bst.getMin());
		
	}

	public static double testQueue(Queue<Integer> q, int count){
		long startTime = System.currentTimeMillis();
		Random random = new Random();
		for(int i=0;i<count;i++){
			q.enqueue(random.nextInt(Integer.MAX_VALUE));
		}
		while(!q.isEmpty()){
			q.dequeue();
		}
		long endTime = System.currentTimeMillis();
		long consum = endTime - startTime;
		return consum;
	}
	
	public static double testStack(Stack<Integer> q, int count){
		long startTime = System.currentTimeMillis();
		Random random = new Random();
		for(int i=0;i<count;i++){
			q.push(random.nextInt(Integer.MAX_VALUE));
		}
		while(!q.isEmpty()){
			q.pop();
		}
		long endTime = System.currentTimeMillis();
		long consum = endTime - startTime;
		return consum;
	}
	
	public static double testMap(Map<String, Integer> map, String filename){
		long startTime = System.nanoTime();
		System.out.println("filename:" + filename);
		ArrayList<String> words = new ArrayList<>();
		if(FileOperation.readfile(filename, words)){
			System.out.println("Total words:" + words.size());
			
			for(String word : words){
				if(map.contains(word)){
					map.set(word, map.get(word)+1);
				}else{
					map.add(word, 1);
				}
			}
			
			System.out.println("Total different words:" + map.getSize());
			System.out.println("Frequency of PRIDE:" + map.get("pride"));
			System.out.println("Frequency of And:" + map.get("and"));
			System.out.println("Frequency of PREJUDICE:" + map.get("prejudice"));
		}
		
		long endTime = System.nanoTime();
		
		return (endTime - startTime) / 1000000000.0;
	}
}

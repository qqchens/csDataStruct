package csDataStruct;

import java.util.Random;
import interfacePackage.*;

public class Main {

	public static void main(String[] args) {
		int testCount = 100000;
		
//		ArrayQueue<Integer> a1 = new ArrayQueue<Integer>();
//		double time1 = testQueue(a1, testCount);
//		System.out.println("ArrayQueue 用时" + time1 + "ms。");
		
//		LoopQueue<Integer> a2 = new LoopQueue<Integer>();
//		double time2 = testQueue(a2, testCount);
//		System.out.println("LoopQueue 用时" + time2 + "ms。");
		
//		LinkedListQueue<Integer> a3 = new LinkedListQueue<Integer>();
//		double time3 = testQueue(a3, testCount);
//		System.out.println("LinkedListQueue 用时" + time3 + "ms。");
		
		LinkedListStack<Integer> a4 = new LinkedListStack<Integer>();
		double time4 = testStack(a4, testCount);
		System.out.println("LinkedListQueue 用时" + time4 + "ms。");
		
		ArrayStack<Integer> a5 = new ArrayStack<Integer>();
		double time5 = testStack(a5, testCount);
		System.out.println("LinkedListQueue 用时" + time5 + "ms。");
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
}

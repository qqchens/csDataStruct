package csDataStruct;

import java.util.Random;
import interfacePackage.Queue;

public class Main {

	public static void main(String[] args) {
		int testCount = 1000000;
		ArrayQueue<Integer> a1 = new ArrayQueue<Integer>();
		LoopQueue<Integer> a2 = new LoopQueue<Integer>();
		
		double time1 = testQueue(a1, testCount);
		double time2 = testQueue(a2, testCount);
		System.out.println("ArrayQueue 用时" + time1 + "hs。");
		System.out.println("LoopQueue 用时" + time2 + "hs。");
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
}

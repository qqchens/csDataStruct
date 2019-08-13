package csDataStruct;
import interfacePackage.*;
public class ArrayQueue<E> implements Queue<E>{
	
	private Array<E> data;
	
	//构造函数，传入队列容量
	public ArrayQueue(int capacity) {
		data = new Array<E>(capacity);
	}
	
	//无参构造函数，队列容量默认为10
	public ArrayQueue() {
		data = new Array<E>(10);
	}
	
	//返回队列中元素个数
	@Override
	public int getSize(){
		return data.getSize();
	}
	
	//检查队列是否为空
	@Override
	public boolean isEmpty(){
		return data.getSize() == 0;
	}
	
	//获取队列容量
	public int getcapacity(){
		return data.getCapacity();
	}
	
	//元素进队
	@Override
	public void enqueue(E e){
		data.addLast(e);
	}
	
	//元素出队
	@Override
	public E dequeue(){
		return data.removeFirst();
	}
	
	//获取队受元素
	@Override
	public E getFront(){
		return data.getFirst();
	}
	
	//重构格式化输出
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append(String.format("ArrayQueue: size=%d, capacity=%d\n", data.getSize(), data.getCapacity()));
		res.append("head [");
		for(int i=0;i<data.getSize();i++){
			res.append(data.get(i));
			if(i != data.getSize()-1){
				res.append(", ");
			}
		}
		res.append("] tail");
		
		return res.toString();
	}
	
	public static void main(String[] args) {
		ArrayQueue<Integer> a = new ArrayQueue<Integer>(3);

		for(int i=0;i<10;i++){
			a.enqueue(i);
			System.out.println(a);
		}
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
		System.out.println(a);
	}
}

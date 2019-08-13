package csDataStruct;
import interfacePackage.*;
public class LoopQueue<E> implements Queue<E>{

	private int head;
	private int tail;
	private int size;
	private E[] data;
	
	//构造函数，输入队列容量
	@SuppressWarnings("unchecked")
	public LoopQueue(int capacity){
		data = (E[])new Object[capacity + 1];
		head = 0;
		tail = 0;
		size = 0;
	}
	
	//无参构造函数，默认队列容量10
	public LoopQueue(){
		this(10);
	}
	
	//返回队列容量
	@Override
	public int getSize(){
		return size;
	}
	
	//检查队列是否为空
	@Override
	public boolean isEmpty(){
		return size == 0;
	}
	
	//返回队列容量
	public int getCapacity(){
		return data.length - 1;
	}
	
	//元素入队
	@Override
	public void enqueue(E e){
		if((tail+1) % data.length == head){
			resize(data.length * 2);
		}
		
		data[tail] = e;
		tail++;
		size++;
	}
	
	//元素出队
	public E dequeue(){
		E e = data[head];
		head++;
		size--;
		
		if(size == data.length/3 && data.length/2 !=0){
			resize(data.length / 2);
		}
		
		return e;
	}
	
	//查看队首元素
	@Override
	public E getFront(){
		return data[head];
	}
	
	//队列扩容
	@SuppressWarnings("unchecked")
	public void resize(int newCapacity){
		E[] newData = (E[])new Object[newCapacity];
		for(int i=0;i<size;i++){
			newData[i] = data[(i+head)%data.length];
		}
		data = newData;
		head = 0;
		tail = size;
	}
	
	//格式化输出
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append(String.format("LoopQueue: size=%d, capacity=%d\n", size, data.length-1));
		res.append("head [");
		for(int i=0;i<size;i++){
			res.append(data[(i+head)%data.length]);
			if(i != size-1){
				res.append(", ");
			}
		}
		res.append("] tail");
		return res.toString();
	}
	
	public static void main(String[] args) {
		LoopQueue<Integer> a = new LoopQueue<Integer>(3);

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

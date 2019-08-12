package csDataStruct;
import interfacePackage.*;

public class ArrayStack<E> implements Stack<E> {
	
	private Array<E> data;
	
	//构造函数，传入栈的容量
	public ArrayStack(int capacity){
		data = new Array<E>(capacity);
	}

	//无参构造函数，默认容量10
	public ArrayStack(){
		this(10);
	}
	
	//获取栈内元素个数
	@Override
	public int getSize(){
		return data.getSize();
	}
	
	//检查栈是否为空
	@Override
	public boolean isEmpty(){
		return data.isEmpty();
	}
	
	//获取栈的容量
	public int getCapacity(){
		return data.getCapacity();
	}
	
	//往栈中添加元素
	public void push(){
		
	}
	@Override
	public void set(E e){
		data.addLast(e);
	}
	
	//从栈中取出元素
	@Override
	public E get(){
		return data.removeLast();
	}
	
	//查看栈顶元素
	@Override
	public E peek(){
		return data.getLast();
	}
	
	@Override
	public String toString(){
		StringBuffer res = new StringBuffer();
		
		res.append("Stack: [");
		for(int i=0;i<data.getSize();i++){
			res.append(data.get(i));
			if(i != data.getSize()-1){
				res.append(", ");
			}
		}
		res.append("]");
		
		return res.toString();
	}
}

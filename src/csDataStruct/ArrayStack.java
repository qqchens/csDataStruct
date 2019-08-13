package csDataStruct;
import interfacePackage.*;

public class ArrayStack<E> implements Stack<E> {
	
	private Array<E> data;
	
	//���캯��������ջ������
	public ArrayStack(int capacity){
		data = new Array<E>(capacity);
	}

	//�޲ι��캯����Ĭ������10
	public ArrayStack(){
		this(10);
	}
	
	//��ȡջ��Ԫ�ظ���
	@Override
	public int getSize(){
		return data.getSize();
	}
	
	//���ջ�Ƿ�Ϊ��
	@Override
	public boolean isEmpty(){
		return data.isEmpty();
	}
	
	//��ȡջ������
	public int getCapacity(){
		return data.getCapacity();
	}
	
	//��ջ�����Ԫ��
	@Override
	public void push(E e){
		data.addLast(e);
	}
	
	//��ջ��ȡ��Ԫ��
	@Override
	public E pop(){
		return data.removeLast();
	}
	
	//�鿴ջ��Ԫ��
	@Override
	public E peek(){
		return data.getLast();
	}
	
	//�ع���ʽ�����
	@Override
	public String toString(){
		StringBuffer res = new StringBuffer();
		
		res.append(String.format("Stack: size=%d, capacity=%d\n", data.getSize(), data.getCapacity()));
		res.append("[");
		for(int i=0;i<data.getSize();i++){
			res.append(data.get(i));
			if(i != data.getSize()-1){
				res.append(", ");
			}
		}
		res.append("] top");
		
		return res.toString();
	}
	
	public static void main(String[] args) {
		ArrayStack<Integer> a = new ArrayStack<Integer>(3);

		for(int i=0;i<10;i++){
			a.push(i);
			System.out.println(a);
		}
		System.out.println(a.pop());
		System.out.println(a.pop());
		System.out.println(a.pop());
		System.out.println(a.pop());
		System.out.println(a.pop());
		System.out.println(a.pop());
		System.out.println(a);
	}
}

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
	public void push(){
		
	}
	@Override
	public void set(E e){
		data.addLast(e);
	}
	
	//��ջ��ȡ��Ԫ��
	@Override
	public E get(){
		return data.removeLast();
	}
	
	//�鿴ջ��Ԫ��
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

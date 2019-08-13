package csDataStruct;
import interfacePackage.*;
public class ArrayQueue<E> implements Queue<E>{
	
	private Array<E> data;
	
	//���캯���������������
	public ArrayQueue(int capacity) {
		data = new Array<E>(capacity);
	}
	
	//�޲ι��캯������������Ĭ��Ϊ10
	public ArrayQueue() {
		data = new Array<E>(10);
	}
	
	//���ض�����Ԫ�ظ���
	@Override
	public int getSize(){
		return data.getSize();
	}
	
	//�������Ƿ�Ϊ��
	@Override
	public boolean isEmpty(){
		return data.getSize() == 0;
	}
	
	//��ȡ��������
	public int getcapacity(){
		return data.getCapacity();
	}
	
	//Ԫ�ؽ���
	@Override
	public void enqueue(E e){
		data.addLast(e);
	}
	
	//Ԫ�س���
	@Override
	public E dequeue(){
		return data.removeFirst();
	}
	
	//��ȡ����Ԫ��
	@Override
	public E getFront(){
		return data.getFirst();
	}
	
	//�ع���ʽ�����
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

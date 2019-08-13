package csDataStruct;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Array<E> {
	
	private E[] data;
	private int size;

	//���캯���������������������������
	@SuppressWarnings("unchecked")
	public Array(int capacity){
		data = (E[])new Object[capacity];
		size = 0;
	}
	
	//�޲ι��캯����Ĭ������10
	public Array(){
		this(10);
	}
	
	//��ȡ����Ԫ�ظ���
	public int getSize(){
		return size;
	}
	
	//��ȡ��������
	public int getCapacity(){
		return data.length;
	}
	
	//��������Ƿ�Ϊ��
	public boolean isEmpty(){
		return size == 0;
	}
	
	//����λ�����һ��Ԫ��
	public void add(int index, E e){
		
		if(index < 0 || index > size){
			throw new IllegalArgumentException("Add failed. Require index >= 0 and <= size.");
		}
		if(size == data.length){
			resize(2 * data.length);
		}
		
		for(int i=size;i>index;i--){
			data[i] = data[i-1];
		}
		data[index] = e;
		size++;
	}
	
	//��λ���һ��Ԫ��
	public void addFirst(E e){
		add(0, e);
	}
	
	//ĩλ���һ��Ԫ��
	public void addLast(E e){
		add(size, e);
	}
	
	//��ʽ�����
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array:size=%d, capacity=%d\n", size, data.length));
		res.append("[");
		for(int i=0;i<size;i++){
			res.append(data[i]);
			if(i != size-1){
				res.append(", ");
			}
		}
		res.append("]");
		
		return res.toString();
	}
	
	//��ѯ����λ�õ�Ԫ��
	public E get(int index){
		if(index < 0 || index >= size){
			throw new IllegalArgumentException("Get failed. index is illegal.");
		}
		return data[index];
	}
	
	//��ȡ��λԪ��
	public E getFirst(){
		return get(0);
	}
	
	//��ȡĩλԪ��
	public E getLast(){
		return get(size-1);
	}
	
	//�޸�����λ�õ�Ԫ��
	public void set(int index, E e){
		if(index < 0 || index >= size){
			throw new IllegalArgumentException("Get failed. index is illegal.");
		}
		data[index] = e;
	}
	
	//�ж��Ƿ����Ԫ��
	public boolean contains(E e){
		for(int i=0;i<size;i++){
			if(data[i].equals(e)){
				return true;
			}
		}
		return false;
	}
	
	//����Ԫ�ص�����λ��
	public int find(E e){
		for(int i=0;i<size;i++){
			if(e.equals(data[i])){
				return i;
			}
		}
		return -1;
	}
	
	//ɾ������λ�õ�Ԫ�� 
	public E remove(int index){
		if(index < 0 || index >= size){
			throw new IllegalArgumentException("Get failed. index is illegal.");
		}
		E e = data[index];
		for(int i=index;i<size;i++){
			data[i] = data[i+1];
		}
		size --;
		
		if(size == data.length/3){
			resize(data.length/2);
		}
		
		return e;
	}
	
	//ɾ����λԪ��
	public E removeFirst(){
		return remove(0);
	}

	//ɾ��ĩλԪ��
	public E removeLast(){
		return remove(size-1);
	}
	
	//ɾ��ָ��Ԫ��
	public void removeElement(E e){
		int index = find(e);
		if(index != -1){
			remove(index);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int newcapacity){
		E[] newData = (E[])new Object[newcapacity];
		for(int i=0;i<size;i++){
			newData[i] = data[i];
		}
		data = newData;
	}
}

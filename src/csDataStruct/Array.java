package csDataStruct;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Array<E> {
	
	private E[] data;
	private int size;

	//构造函数，传入数组的容量，构造数组
	@SuppressWarnings("unchecked")
	public Array(int capacity){
		data = (E[])new Object[capacity];
		size = 0;
	}
	
	//无参构造函数。默认容量10
	public Array(){
		this(10);
	}
	
	//获取数组元素个数
	public int getSize(){
		return size;
	}
	
	//获取数组容量
	public int getCapacity(){
		return data.length;
	}
	
	//检查数组是否为空
	public boolean isEmpty(){
		return size == 0;
	}
	
	//索引位置添加一个元素
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
	
	//首位添加一个元素
	public void addFirst(E e){
		add(0, e);
	}
	
	//末位添加一个元素
	public void addLast(E e){
		add(size, e);
	}
	
	//格式化输出
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
	
	//查询索引位置的元素
	public E get(int index){
		if(index < 0 || index >= size){
			throw new IllegalArgumentException("Get failed. index is illegal.");
		}
		return data[index];
	}
	
	//获取首位元素
	public E getFirst(){
		return get(0);
	}
	
	//获取末位元素
	public E getLast(){
		return get(size-1);
	}
	
	//修改索引位置的元素
	public void set(int index, E e){
		if(index < 0 || index >= size){
			throw new IllegalArgumentException("Get failed. index is illegal.");
		}
		data[index] = e;
	}
	
	//判断是否包含元素
	public boolean contains(E e){
		for(int i=0;i<size;i++){
			if(data[i].equals(e)){
				return true;
			}
		}
		return false;
	}
	
	//返回元素的索引位置
	public int find(E e){
		for(int i=0;i<size;i++){
			if(e.equals(data[i])){
				return i;
			}
		}
		return -1;
	}
	
	//删除索引位置的元素 
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
	
	//删除首位元素
	public E removeFirst(){
		return remove(0);
	}

	//删除末位元素
	public E removeLast(){
		return remove(size-1);
	}
	
	//删除指定元素
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

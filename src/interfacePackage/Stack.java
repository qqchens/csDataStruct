package interfacePackage;

public interface Stack<E> {
	public int getSize();
	public boolean isEmpty();
	public void set(E e);
	public E get();
	public E peek();
}

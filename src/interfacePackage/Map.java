package interfacePackage;

public interface Map<K, V> {

	public int getSize();
	public boolean isEmpty();
	public boolean contains(K k);
	public void add(K k, V v);
	public void set(K k, V v);
	public V get(K k);
	public V remove(K k);
}

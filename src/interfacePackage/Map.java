package interfacePackage;

public interface Map<K, V> {

	int getSize();
	boolean isEmpty();
	boolean contains(K k);
	void add(K k, V v);
	void set(K k, V v);
	V get(K k);
	V remove(K k);
}

package csDataStruct;

import java.util.TreeMap;

public class Trie {
	
	private Node root;
	private int size;
	private int capacity;
	
	private class Node{
		public boolean isWord;
		public int number;
		public TreeMap<Character, Node> next;
		
		public Node(){
			this.isWord = false;
			this.number = 0;
			next = new TreeMap<>();
		}
	}
	
	public Trie(){
		this.size = 0;
		this.capacity = 0;
		this.root = new Node();
	}
	
	//获取不同元素个数
	public int getSize(){
		return size;
	}
	
	//获取元素总数
	public int getCapacity(){
		return capacity;
	}
	
	//线段树中添加元素
	public void add(String word){
		add(word, 1);
	}
	
	//线段树中添加元素、个数
	public void add(String word, int num){
		Node cur = root;
		for(int i=0; i<word.length(); i++){
			char c = word.charAt(i);
			if(!cur.next.containsKey(c)){
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);
		}
		if(cur.isWord){
			cur.number += num;
		}else{
			cur.isWord = true;
			cur.number = num;
			size++;
		}
		capacity += num;
	}
	
	//查找是否包含某元素
	public boolean contains(String word){
		Node cur = root;
		for(int i=0; i<word.length(); i++){
			char c = word.charAt(i);
			if(!cur.next.containsKey(c)){
				return false;
			}
			cur = cur.next.get(c);
		}
		return cur.isWord;
	}
	
	//检查是否包含前缀preFix
	public boolean isPreFix(String preFix){
		Node cur = root;
		for(int i=0; i<preFix.length(); i++){
			char c = preFix.charAt(i);
			if(!cur.next.containsKey(c)){
				return false;
			}
			cur = cur.next.get(c);
		}
		return true;
	}
	
	//获取包含word的元素个数
	public int sum(String word){
		Node cur = root;
		for(int i=0; i<word.length(); i++){
			char c = word.charAt(i);
			if(!cur.next.containsKey(c)){
				return 0;
			}
			cur = cur.next.get(c);
		}
		return sum(cur);
	}
	
	//获取node的包含的word数量
	private int sum(Node node){
		int res = node.number;
		for(Character c: node.next.keySet()){
			res += sum(node.next.get(c));
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

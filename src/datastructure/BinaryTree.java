package datastructure;

public class BinaryTree<K extends Comparable<K>, V> {
	private Node<K, V> root;
	
	public void add(K key, V value) {
		Node<K, V> node = new Node<>(key, value);
		if(null == root) {
			root = node;
		} else {
			Node<K, V> temp = root;
			
			while(true) {
				if(node.getKey().compareTo(temp.getKey()) < 0) { // left
					if(null == temp.left) {
						temp.left = node;
					} else {
						
					}
					
				} else if(node.getKey().compareTo(temp.getKey()) > 0) { // right
					
				} else {
					
				}
			}
		}
	}
	

	private static class Node<K extends Comparable<K>, V> {
		private K key;
		private V value;
		Node<K, V> left, right;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
	}
}

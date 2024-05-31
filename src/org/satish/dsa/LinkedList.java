package org.satish.dsa;

public class LinkedList<T> {
	
	Node head;
	
	public void add(T data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		if(head == null) {
			head = node;
		} else {
			Node n = head;
			
			while(n.next != null) {
				n = n.next;
			}
			n.next = node;
		}
		
	}
	
	public void show() {
		Node node = head;
		
		while(node.next != null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
		System.out.print(node.data+" ");
	}
	
	public void addFirst(T data) {
		Node node = new Node();
		node.data = data;
		node.next = head;
		
		head = node;
	}
	
	public void insertAtIndex(int index, T data) {
		Node node = new Node();
		node.data = data;
		
		Node n = head;
		for(int i = 0; i < index-1;i++ )
			n = n.next;
		
		node.next = n.next;
		n.next = node;

	}
	
	
}

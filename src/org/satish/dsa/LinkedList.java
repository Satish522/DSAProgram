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
		if(index == 0) {
			addFirst(data);
		} else {
			Node n = head;
			for(int i = 0; i < index-1;i++ )
				n = n.next;
			
			node.next = n.next;
			n.next = node;
		}
		

	}
	
	public void deleteAt(int index) {
		
		if(index == 0) {
			head = head.next;
		} else {
			
			Node n = head;
			for(int i = 0; i < index-1;i++ )
				n = n.next;
			Node n1 = n.next;
			
			n.next = n1.next;
		
		}
		
	}
	
	
}

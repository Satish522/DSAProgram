package org.satish.dsa;

public class RunnerClass {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("Satish");
		list.add("Kumar");
		list.add("Subudhi");
		list.addFirst("Rajvika");
		list.addFirst("Swapna");
		list.insertAtIndex(2, "Rajsi");
		list.insertAtIndex(3, "S");
		list.insertAtIndex(1, "Senapati");
		list.deleteAt(6);
		list.show();
		
		java.util.LinkedList<String> ll = new java.util.LinkedList<>();
		
	}

}
 
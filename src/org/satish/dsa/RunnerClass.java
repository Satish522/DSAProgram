package org.satish.dsa;

public class RunnerClass {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(65);
		list.add(3);
		list.add(6);
		list.add(33);
		list.show();
		System.out.println(list.head.data+"  "+list.head.next.next.next.data);
	}

}

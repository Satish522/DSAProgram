package org.satish.dsa;

public class StackRunner {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(3);
		stack.show();
		stack.push(4);
		stack.show();
		System.out.println(stack.peek());
		stack.show();
		stack.push(7);
		stack.show();
		stack.push(5);
		stack.show();
		stack.push(17);
		stack.show();
		stack.push(13);
		stack.show();
		System.out.println(stack.pop());
		stack.show();
		System.out.println(stack.size());
		System.out.println(stack.pop());
		stack.show();
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		 
		
	}

}

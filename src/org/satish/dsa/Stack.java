package org.satish.dsa;

public class Stack {
	
	int stack[] = new int[5];
	int top =0;
	
	public void push(int data) {
		
		if(top < stack.length) {
			stack[top] = data;
			top++;
		} else {
			System.out.println("Stack is full");
		}
				
	}
	
	public int pop() {
		 
		int data = 0;
		if(isEmpty()) {
			System.out.println("Stack is empty");
		} else {
			top--;
			data = stack[top];
			stack[top] = 0;
		}
			
		return data;
		
	}
	
	public int peek() {
		int data;
		data = stack[top-1];
		return data;
	}
	
	public void show() {
		for(int n : stack) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public int size() {
		return top;
	}
	
	public boolean isEmpty() {
		
		return top <= 0;
	}
	
}

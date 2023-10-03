package org.satish.array;

public class LergestThreeElement {

	public static void main(String[] args) {
		int arr[] = { 12, 13, 1, 10, 34, 1 };
        int n = arr.length;
        print3largest(arr, n);

	}

	private static void print3largest(int[] arr, int n) {
		// Bruteforce approach with O(n)
		int first =0 , second = 0 , third = 0;
		
		for(int element : arr) {
			
			if(element > first) {
				third = second;
				second = first;
				first = element;
				
			} else if(element > second) {
				third = second;
				second = element;
				
			} else if(element > third) {
				third = element;
			}
			
		}
		
		System.out.println("First element "+ first);
		System.out.println("Second element "+ second);
		System.out.println("Third element "+ third);
		
	}
	
	
	
	

}

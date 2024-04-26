package org.satish.array.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = {5,3,9,2,6,3,7};
		
		int size = arr.length;
		int steps = 0;
		System.out.println("Before Sorting...");
		for(int i : arr) {
			System.out.print(i + " ");
		}
		
		for(int i=0; i<size; i++) {
			for(int j =0; j< size-1; j++) {
				steps++;
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			System.out.println();
			for(int ele : arr) {
				System.out.print(ele + " ");
			}
			
		}
		System.out.println("\nNumber of steps :"+steps);
		System.out.println("After Bubble Sorting...");
		for(int i : arr) {
			System.out.print(i + " ");
		}

	}

}

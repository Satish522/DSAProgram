package org.satish.array;

public class MoveZeroAtEnd {

	public static void main(String[] args) {
		int arr[] = {0,1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        int n = arr.length;
		
		/*
		 * pushZerosToEnd(arr, n);
		 * 
		 * System.out.println("Array after pushing zeros to the back: "); for (int i=0;
		 * i<n; i++) System.out.print(arr[i]+" ");
		 */ 
        pushZerosWithSwapToEnd(arr, n);

	}

	private static void pushZerosWithSwapToEnd(int[] A, int n) {
		int j = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] != 0) {
                //   Swap - A[j] , A[i]
                swap(A, j, i); // Partitioning the array
                j++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " "); // Print the array
        }
		
	}

	private static void swap(int[] A, int a, int b) {
		int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
		
	}

	private static void pushZerosToEnd(int[] arr, int n) {
		int count = 0;
		for(int element : arr) {
			if(element > 0 ) {
				arr[count] = element;
				count++;
			}
			
			
		}
		
		while(count < n) {
			arr[count++] = 0;
			
		}
	}
	
	

}

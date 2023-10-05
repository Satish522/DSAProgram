package org.satish.array;

import java.util.Arrays;

public class EvenPositionGreaterThanOdd {

	public static void main(String[] args) {
		int A[] = { 1, 3, 2, 2, 58, 822, 893, 7 , 2, 2,4,4,6,3,6,8,9 };
        int n = A.length;
       // assign(A, n);
        rearrange(A, n);

	}

	private static void assign(int[] a, int n) {
		Arrays.sort(a);
		
		for(int ele : a) {
			System.out.print(ele+" ");
		}
		System.out.println();
		
		int ans[] = new int[n];
		int revers = n-1;
		int forward =0;
		for(int i = 0 ; i < n; i++) {
			
			
			if((i+1) % 2 == 0) {
				ans[i]= a[revers--];
				//revers--;
						
			}else {
				ans[i] = a[forward++];
			}
		}
		
		for(int ele : ans) {
			System.out.print(ele+" ");
		}
		
	}
	
	private static void rearrange(int[] arr, int n) {
		
		for(int i=1; i < n; i++) {
			
			if(i%2 == 0) {
				if(arr[i] > arr[i-1]) {
					int temp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = temp;
				}
			} else {
				if(arr[i] < arr[i-1]) {
					int temp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = temp;
				}
				
			}
			
		}
		
		for(int ele : arr) {
			System.out.print(ele+" ");
		}
	}

}

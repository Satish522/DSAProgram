package org.satish.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.satish.array.util.DSAUtil;

public class ArrayEasyProblems {

	public static void main(String[] args) {
		int arr[] = DSAUtil.generateRandomeArray(10);
		int sortedArr[] = DSAUtil.generateRandomeSortedArray(10);
		findLargestElement(arr);
		findSecondLargest(arr);
		findSecondSmallest(arr);
		checkArraySorted(arr);
		removeDuplicates(sortedArr);
		leftRotateByOnePlace(arr);
		leftRotateByDPlace(arr, 4);
		rightRotateByDPlace(arr, 5); // Finish by your self both approach ??
		moveZeroToEndOfArray(arr);
		
		
	}

	private static void moveZeroToEndOfArray(int[] arr) {
		
	//	bruteForceMoveZeroToEndOfArray(arr);
		
		optimalMoveZeroToEndOfArray(arr);
		
	}

	private static void optimalMoveZeroToEndOfArray(int[] arr) {
		System.out.println("\nShifting 0 to end of array optmial");
		int j = -1;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == 0) {
				j=i;
				break;
			}
		}
		
		for(int i = j+1; i < arr.length; i++) {
			if(arr[i] != 0) {
				int tmp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = tmp;
				j++;
			}
		}
		System.out.print(" >> ");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
	}

	private static void swap(int i, int j) {
		
		
	}

	private static void bruteForceMoveZeroToEndOfArray(int[] arr) {
		System.out.println("\nShifting 0 to end of array");
		List temp = new ArrayList();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != 0)
				temp.add(arr[i]);
		}
		
		for(int i =0 ; i< temp.size(); i++) {
			arr[i] = (int) temp.get(i);
		}
		
		for(int i = temp.size(); i< arr.length; i++) {
			arr[i] = 0;
		}
		System.out.print(" >> ");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		
	}

	private static void rightRotateByDPlace(int[] arr, int i) {
		
		
	}

	private static void leftRotateByDPlace(int[] arr, int d) {
		System.out.println("\nRotate left by D place");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		if(arr.length < d) {
			 d = d % arr.length;
		}
		System.out.println("Actual rotation "+ d);
		//bruteForceLeftRotateByDPlace(arr, d);
		
		//no better solution so jumping to optmial
		optimalLeftRotateByDPlace(arr, d);
		
		
	}

	private static void optimalLeftRotateByDPlace(int[] arr, int d) {
		int n = arr.length;
		System.out.println("\nRotate left by "+d+" place optmial");
		reverse(arr, 0, d-1);
		reverse(arr, d, n-1);
		reverse(arr, 0, n-1);
		System.out.print(" >> ");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
	}
	
	

	private static void reverse(int[] arr, int start, int end) {
		while(start <= end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		
	}

	private static void bruteForceLeftRotateByDPlace(int[] arr, int d) {
		//bruteForce approach
		System.out.println("\nRotate left by "+d+" place");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		int temp[] = new int[d];
		int n = arr.length;
		//putting  d's elements into temp array
		for(int i=0; i<d;i++) {
			temp[i] = arr[i];
		}
		//Shifting left by d
		for(int i = d ; i < n; i++) {
			arr[i-d] = arr[i];
		}
		int j  = 0;
		//putting back temp to back of arr
		for(int i = 0 ; i < temp.length; i++) {
			arr[n-d + i] = temp[i];
		}
		System.out.print(" >> ");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
	}

	private static void leftRotateByOnePlace(int[] arr) {
		System.out.println("\nRotate left by one place");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		int first = arr[0];
		
		for(int i = 1; i <arr.length ; i++) {
			arr[i-1] = arr[i];
		}
		arr[arr.length-1] = first;
		System.out.print(" >> ");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		
	}

	private static void removeDuplicates(int[] arr) {
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		//Bruteforce
		/*Set<Integer> unique = new HashSet<Integer>();
		for(int i =0; i < arr.length; i++) {
			System.out.println(arr[i]+" => "+ unique.add(arr[i]));
		}*/
		
		//Optimal solution
		int i = 0;
		for(int j = 1 ; j < arr.length; j++) {
			if(arr[j] != arr[i]) {
				arr[i+1] = arr[j] ; 
				i++;
			}
		}
		i+=1;
		while(i < arr.length) {
			arr[i++] = 0;
		}
		System.out.println();
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		
		
	}

	private static boolean checkArraySorted(int[] arr) {
		for(int i = 1; i< arr.length; i++) {
			if(arr[i-1] <= arr[i]) {
				System.out.println("valid....");
				
			} else {
				System.out.println("Unsorted....");
				return false;
			}
		}
		System.out.println("Sorted....");
		return true;
	}

	private static void findSecondSmallest(int[] arr) {
		int smallest = arr[0];
		int ssmallest = Integer.MAX_VALUE;
		
		for(int i =0; i< arr.length;i++) {
			if(arr[i] < smallest) {
				ssmallest = smallest;
				smallest = arr[i];
			}
		}
		System.out.println();
		System.out.println(ssmallest);
		
	}

	private static void findSecondLargest(int[] arr) {
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		// Bruteforce approach
		bruteForceFindSecondLargest(arr);
			
		//Optimal approach
		optimalFindSecondLargest(arr);
	}

	private static void optimalFindSecondLargest(int[] arr) {
		int largest = arr[0];
		int slargest = Integer.MIN_VALUE;
		
		for(int i =0; i< arr.length;i++) {
			if(arr[i]> largest) {
				slargest = largest;
				largest = arr[i];
			}
		}
		System.out.println();
		System.out.println(slargest);
	
		
	}

	private static void bruteForceFindSecondLargest(int[] arr) {
		int largest = arr[0];
		int secondLargest = -1;
		
		for(int i=0; i < arr.length; i++) {
			if(arr[i] > largest)
				largest = arr[i];			
		}
		
		for(int i=0; i < arr.length; i++) {
			if(arr[i] > secondLargest && arr[i] < largest)
				secondLargest = arr[i];			
		}
		System.out.println();
		System.out.println(secondLargest);
		
	}

	private static void findLargestElement(int[] arr) {
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		int largest = arr[0];
		for(int i=0; i < arr.length; i++) {
			if(arr[i] > largest)
				largest = arr[i];
		}
		System.out.println();
		System.out.println(largest);
		
	}

}

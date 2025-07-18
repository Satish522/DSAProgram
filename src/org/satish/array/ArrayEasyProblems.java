package org.satish.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

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
		unionSortedArray(DSAUtil.generateRandomeSortedArray(19), DSAUtil.generateRandomeSortedArray(36));
		intersectionSortedArray(DSAUtil.generateRandomeSortedArray(19), DSAUtil.generateRandomeSortedArray(20));
		findMissingNumber(DSAUtil.generateRandomeSortedArray(5));
		findMaximumConsecutive1();
		findNumberAppearOnce();
		findLongestSubarrayWithSum();
		
		
	}

	private static void findLongestSubarrayWithSum() {
		bruteforceFindLongestSubarrayWithSum();
		
		betterFindLongestSubarrayWithSum();
		
		optimalFindLongestSubarrayWithSum();
	}

	private static void optimalFindLongestSubarrayWithSum() {
		int arr[] = {1, 2, 3, 2, 1,1,1,1,4,1,3,3};
		int targetSum  = 6;
		
		int sum =0;
		int length = 0;
		int i =0, j=0;
		while (j<arr.length) {
			
			while(targetSum < sum && i<=j) {
				sum = sum - arr[i];
				i++;
			}
			
			sum += arr[j];
			j++;
			
			if(targetSum == sum) {
				int len = j-i;
				length = Math.max(length, len);
			}
			
		}
		System.out.println("\nOptimal approach ==> Max subarray "+ length);
		
	}

	private static void betterFindLongestSubarrayWithSum() {
		int arr[] = {1, 2, 3, 2,1,1,1,1,4,1,3,3};
		int targetSum  = 6;
		int sum =0;
		int length =0 ;
		Map<Integer, Integer> preSum = new HashMap<Integer, Integer>();
		
		for(int i=0; i< arr.length;i++) {
			
			sum += arr[i];
			
			if(sum == targetSum) {
				length = Math.max(length, i+1); 
			}
			
			int rem = sum - targetSum;
			
			if(preSum.containsKey(rem)) {
				length = Math.max(length, (i - preSum.get(rem)));
			}
			
			//if(!preSum.containsKey(sum))
				preSum.put(sum , i);
			
			
		}
		System.out.println("\nBetter approach ==> Max subarray "+ length);
		
		
	}

	private static void bruteforceFindLongestSubarrayWithSum() {
		int arr[] = {2, 3, 5, 1, 9};
        long sum = 10;
        System.out.println("\n Find longest sub array of sum "+ sum);
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		int length =0;
		for(int i = 0; i<arr.length; i++) {
			int sumR =0;
			for(int j = i; j < arr.length; j++) {
				
				sumR +=arr[j];
				/*
				for(int k = 0; k <= j ; k++) {
					sumR +=arr[k];
				}*/
				
				if(sumR == sum) {
					length = Math.max(length, j-i+1);
				}
				
			}
		}
		
		System.out.println("\nMax subarray "+ length);
		
	}

	private static void findNumberAppearOnce() {
		int[] twiceArr = new int[] {1,1,2,2,3,3,4,4,5,6,6,8,8};
		
		bruteforceFindNumberAppearOnce(twiceArr);
		
		betterApproachFindNumberAppearOnce(twiceArr);
		
		optimalApproachFindNumberAppearOnce(twiceArr);
		
	}

	private static void optimalApproachFindNumberAppearOnce(int[] twiceArr) {
		int xor = 0 ;
		for(int ele : twiceArr) {
			xor = xor ^ ele;
		}
		System.out.println("Optimal solution ==> Single apearance number is "+xor);
		
	}

	private static void betterApproachFindNumberAppearOnce(int[] twiceArr) {
		
		Map<Integer, Integer> map =  new HashMap<Integer, Integer>();
		
		for(int ele : twiceArr) {
			map.put(ele, map.getOrDefault(ele, 0)+1);
		}
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1)
				System.out.println("Better approach ==> Single apearance number is "+entry.getKey());
		}
		
		
	}

	private static void bruteforceFindNumberAppearOnce(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			int counter = 0;
			for(int j=0; j < arr.length; j++) {
				if(arr[i] == arr[j])
					counter++;
			}
			
			if(counter == 1)
				System.out.println("Single apearance number is "+arr[i]);
		}
		
		
	}

	private static void findMaximumConsecutive1() {
		int arr[] = new int[] {1,1, 0,1,1,1,0,1,1,0,1,1,1,1};
		int counter = 0, max =0;
		for(int i = 0; i< arr.length; i++) {
			if(arr[i] == 1) {
				counter++;
				
			} else {
				counter = 0;
			}
			max = Math.max(max, counter);
		}
		
		System.out.println("Maximum consecutive one is " + max);
	}

	private static void findMissingNumber(int[] arr) {
		arr = new int[]{1,2,3,4,6,7,8,9};
		System.out.println("\n Find missing number");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		
		bruteforceFindMissingNumber(arr);
		
		betterFindMissingNumber(arr);
		
		optimalFindMissingNumber(arr);
		
		moreOptimalFindMissingNumber(arr);
		
	}

	private static void moreOptimalFindMissingNumber(int[] arr) {
		int n = arr.length+1;
		int xor1 = 0, xor2 = 0;

		for(int i=1;i <=n; i++) {
			xor1 ^= i;
		}
		
		for(int ele : arr) {
			xor1 ^= ele;
		}
		
		System.out.println("Missing number is........  "+ xor1);
		xor1 = 0;
        for (int i = 0; i < n - 1; i++) {
            xor2 = xor2 ^ arr[i]; // XOR of array elements
            xor1 = xor1 ^ (i + 1); //XOR up to [1...N-1]
        }
         xor1 = xor1 ^ n; //XOR up to [1...N]

        System.out.println("More Optimal solution ==> Missing number is "+(xor1 ^ xor2)); // the missing number
		
	}

	private static void optimalFindMissingNumber(int[] arr) {
		int n = arr.length;
		int result = 0;
		for(int i =0 ; i<=n-1; i++) {
			result = result + arr[i];
		}
		
		int expectResult = (arr[n-1] * (arr[n-1]+1))/2;
		
		int missingNumber = expectResult -result;
		
		System.out.println("Optmial solution ==> Missing number is "+missingNumber);
		
		
	}

	private static void betterFindMissingNumber(int[] arr) {
		int hash[] = new int[arr.length + 1]; //hash array

        // storing the frequencies:
        for (int i = 0; i < arr.length - 1; i++) {
        	hash[arr[i]]++;
        	System.out.println(hash[arr[i]]);
        }
        
        for(int i =1 ; i < arr.length-1; i++) {
        	if(hash[i] == 0)
        		System.out.println("Better solution => Missing number is "+ i);
        }
            
        
	}

	private static void bruteforceFindMissingNumber(int[] arr) {
		for(int i =0; i < arr.length; i++) {
			int flag = 0; 
			for(int j=0; j < arr.length-1; j++) {
				if(arr[j] == i) {
					flag = 1;
					break;
				}
			}
			if(flag == 0) {
				System.out.println("Bruteforce ==> Missing number is " + i);
			}
		}
		
	}

	private static void intersectionSortedArray(int[] arr1, int[] arr2) {
		
		bruteforceIntersectionSortedArray(arr1,arr2); // n1*n2 time complexity
		
		optmialIntersectionSortedArray(arr1,arr2);
		
		
	}

	private static void optmialIntersectionSortedArray(int[] arr1, int[] arr2) {
		System.out.println("\n Intersection of array1 and array2 optimal");
		Arrays.stream(arr1).forEach(ele -> System.out.print(ele+" "));
		System.out.println();
		Arrays.stream(arr2).forEach(ele -> System.out.print(ele+" "));
		Vector<Integer> intersection = new Vector<Integer>();
		
		
		int n1 = arr1.length;
		int n2 = arr2.length;
		
		int i = 0;
		int j = 0;
		
		
		while(i<n1 && j < n2) {
			if(arr1[i] < arr2[j]) {
				i++;
			} else if(arr1[i] > arr2[j]) {
				j++;
			} else {
				intersection.add(arr1[i]);
				i++;
				j++;
			}
		}
		
		
		
		System.out.println();
		intersection.stream().forEach(ele -> System.out.print(ele+" "));
	}

	private static void bruteforceIntersectionSortedArray(int[] arr1, int[] arr2) {
		System.out.println("\n Unnion of array1 and array2 ");
		Arrays.stream(arr1).forEach(ele -> System.out.print(ele+" "));
		System.out.println();
		Arrays.stream(arr2).forEach(ele -> System.out.print(ele+" "));
		
		int n1 = arr1.length;
		int n2 = arr2.length;
		
		int i = 0;
		int j = 0;
		int vis[] = new int[n2];
		Vector<Integer> intersection = new Vector<Integer>();
		for(i = 0; i< n1; i++) {
			for(j =0; j< n2;j++) {
				if(arr1[i] == arr2[j] && vis[j] == 0) {
					intersection.add(arr1[i]);
					vis[j] = 1;
					break;
				}
				
				if(arr2[j]>arr1[i]) break;
			}
		}
		
		System.out.println();
		intersection.stream().forEach(ele -> System.out.print(ele+" "));
		
	}

	private static void unionSortedArray(int[] arr1, int[] arr2) {
		System.out.println("\n Unnion of array1 and array2 ");
		Arrays.stream(arr1).forEach(ele -> System.out.print(ele+" "));
		System.out.println();
		Arrays.stream(arr2).forEach(ele -> System.out.print(ele+" "));
		
		int n1 = arr1.length;
		int n2 = arr2.length;
		
		int i =0;
		int j=0;
		
		Vector<Integer> unionarr = new Vector<Integer>();
		while(i<n1 && j < n2) {
			if(arr1[i] <= arr2[j]) {
				if(unionarr.size() == 0 || unionarr.lastElement() != arr1[i]) {
					unionarr.add(arr1[i]);
				}
				i++;
			} else {
				if(unionarr.size() == 0 || unionarr.lastElement() != arr2[j]) {
					unionarr.add(arr2[j]);
				}
				j++;
			}
			
		}
		
		while(i < n1) {
			if(unionarr.size() == 0 || unionarr.lastElement() != arr1[i]) {
				unionarr.add(arr1[i]);
			}
			i++;
		}
		
		while(j < n2) {
			if(unionarr.size() == 0 || unionarr.lastElement() != arr2[j]) {
				unionarr.add(arr2[j]);
			}
			j++;
		}
		System.out.println();
		unionarr.stream().forEach(ele -> System.out.print(ele+" "));
		
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

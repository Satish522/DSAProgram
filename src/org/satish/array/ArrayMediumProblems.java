package org.satish.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.satish.array.util.DSAUtil;

public class ArrayMediumProblems {

	public static void main(String[] args) {
		int arr[] = DSAUtil.generateRandomeArray(10);
		int sortedArr[] = DSAUtil.generateRandomeSortedArray(10);
		checkPairIndexWithGivenSum(arr, 14);
		
		
	}

	private static void checkPairIndexWithGivenSum(int[] arr, int sum) {
		bruteforceCheckPairIndexWithGivenSum(arr, sum);
		
		betterCheckPairIndexWithGivenSum(arr, sum);
		
		optimalCheckPairIndexWithGivenSum(arr, sum);
	}

	private static void optimalCheckPairIndexWithGivenSum(int[] arr, int sum) {
		// Sort arreay and two pointer both end increase or decrease according to target sum
		Arrays.sort(arr);
		System.out.println("\n Optimal approach number pair in array ");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		int rem = 0;
		int i =0 , j = arr.length-1;
		while(i < j) {
			int targetSum = arr[i] + arr[j];
			if(targetSum == sum) {
				System.out.println("Better approach ==> Number pairs are :  "+arr[i]+", "+ arr[j]);
				break;
			} else if(targetSum < sum)
				i++;
			else if(targetSum > sum) 
				j--;
			
		}
		
	}

	private static void betterCheckPairIndexWithGivenSum(int[] arr, int sum) {
		// Use hashing approach
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			
			int other = sum - arr[i];
			if(map.containsKey(other)) {
				System.out.println("Better approach ==> Number pairs are :  "+arr[i]+", "+ other);
				break;
			} 
			map.put(arr[i], i);
			
		}
		
	}

	private static void bruteforceCheckPairIndexWithGivenSum(int[] arr, int sum) {
		// Dual loop to find the index
		System.out.println("\n Check number pair in array ");
		Arrays.stream(arr).forEach(ele -> System.out.print(ele+" "));
		for(int i =0; i < arr.length; i++) {
			
			for(int j = i+1; j < arr.length; j++ ) {
				
				int targetSum = arr[i]+arr[j];
				
				if(targetSum == sum) {
					System.out.println("Number pairs are :  "+arr[i]+", "+ arr[j]);
					break;
				}
			}
		}
		
		
	}

}

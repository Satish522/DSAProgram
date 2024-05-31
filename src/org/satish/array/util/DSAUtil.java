package org.satish.array.util;

import java.util.Random;

public class DSAUtil {
	
	public static int[] generateRandomeArray(int size) {
		int arr[] = new int[size];
		for(int i=0; i<size-1;i++) {
			arr[i] = new Random().nextInt(1,size);
		}
		return arr;
	}
}

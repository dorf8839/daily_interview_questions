package com.company;

import java.util.Arrays;

public class Main {
	//The below code runs in O(N*log(N)) time.
	//Function to count the number of inversions during the merge process
	private static int mergeAndCount(int[] arr, int l, int m, int r){
		//Left subarray
		int[] left = Arrays.copyOfRange(arr, l, m+1);

		//Right subarray
		int[] right = Arrays.copyOfRange(arr, m+1, r+1);

		int i = 0, j = 0, k = l, swaps = 0;

		while(i < left.length && j < right.length){
			if(left[i] <= right[j]){
				arr[k++] = left[i++];
			}else{
				arr[k++] = right[j++];
				swaps += (m + 1) - (l + i);
			}
		}
		while(i < left.length){
			arr[k++] = left[i++];
		}
		while(j < right.length){
			arr[k++] = right[j++];
		}
		return swaps;
	}

	//Merge sort function
	private static int mergeSortAndCount(int[] arr, int l, int r){
		//Keeps track of the inversion count at a particular node of the recursion tree
		int count = 0;

		if(l < r){
			int m = (l + r) / 2;

			//Total inversion count = left subarray count
			//+ right subarray count + merge count

			//Left subarray count
			count += mergeSortAndCount(arr, l, m);

			//Right subarray count
			count += mergeSortAndCount(arr, m+1, r);

			//Merge count
			count += mergeAndCount(arr, l, m, r);
		}
		return count;
	}

    public static void main(String[] args) {
    	int[] arr = {1,20,6,4,5};
		System.out.println("Original Array:");
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		//This will modify the original array as shown by the print functions.  If you only want to count
		//inversions, create a copy of the original array to plug into the mergeSortAndCount function
		System.out.println("The number of inversions is " + mergeSortAndCount(arr, 0, arr.length - 1));
		System.out.println("Modified Array:");
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();

//    	//The below code runs in O(N^2) time.  Better solution is above using the outer methods
////	    int[] input = {2,4,1,3,5};
////	    int[] input = {1,2,3,4,5};
//	    int[] input = {5,4,3,2,1};
//	    int[] dp = new int[input.length];
//	    dp[0] = input[0];
//	    int count = 0;
//	    for(int i = 1; i < input.length; i++){
//	        for(int j = 0; j < dp.length; j++){
//	            if(dp[j] > input[i]){
//	                count++;
//                }
//            }
//	        dp[i] = input[i];
//        }
//        System.out.println("The number of inversions is " + count);
    }
}

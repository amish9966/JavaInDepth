package com.java.assignments;

import java.util.Arrays;

public class BasicsDemo {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int temp = 0;
		for (int i = 0,middle=arr.length>>>1; i <middle ; i++) {
			temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
		System.out.println(Arrays.toString(arr));
		
	
		int dividend=24;
		int count=0;
		for(int i=0,len=arr.length;i<len;i++) {
			if(dividend%arr[i]==0) {
				count++;
			}
		}
	}

	void swapLeft() {
		int[] arr = { -3, 2, -4, 5, 7, -9 };

		for (int i = 0; i < arr.length; i++) {

		}

	}

}

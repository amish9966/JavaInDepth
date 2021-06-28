package com.java.assignments;

import java.util.*;

public class Solution {
	

	public static void main(String[] args) {
		String[] strArray={"[1,2,3]","[4,5,6,7,8]"};
		String[] strArray1 = strArray[0].substring(1, strArray[0].length()-1).split(",");
		String[] strArray2 = strArray[1].substring(1, strArray[1].length()-1).split(",");

		int maxArrLength = Math.max(strArray1.length, strArray2.length);

		int[] resultIntArray = new int[maxArrLength];

		for (int i=0; i < maxArrLength; i++) {
		    if (strArray1.length>i) resultIntArray[i] += Integer.valueOf(strArray1[i]);
		    if (strArray2.length>i) resultIntArray[i] += Integer.valueOf(strArray2[i]);
		}

		System.out.println(Arrays.toString(resultIntArray));
	}

}

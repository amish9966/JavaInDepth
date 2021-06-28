package com.java.assignments;

import java.util.*;

public class TestCollectionsLexicographically {
	
	public static void main(String[] args) {
		 PriorityQueue<String> queue=new PriorityQueue<String>();
	        queue.add("Amit");
	        queue.add("Vijay");
	        queue.add("Karan");
	        queue.add("Rahul");
	        queue.add("Jai");
	        ArrayList<String> arr=new ArrayList<String>();
	        System.out.println("iterating the list elements:");
	        while(!queue.isEmpty()) {
	        	arr.add(queue.poll());
	        }
	        Iterator<String> itr=arr.iterator();
	        while(itr.hasNext()) {
	        	System.out.println(itr.next());
	        }
	}
}

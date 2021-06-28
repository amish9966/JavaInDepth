package com.java.assignments;

public class Test {
	
	public static void main(String[] args) {
		String s="reverse";
		System.out.println(reverseString(s));
		swap(10,20);
		System.out.println();
		System.out.println(checkVowelIsPresent(s));
		printFibo(13);
		Object o=new Object();
	}
	
	static String reverseString(String s) {
		String reverseString="";
		if(s!=null && !s.isEmpty()) {
			for(int i=s.length()-1;i>=0;i--) {
				reverseString=reverseString+s.charAt(i);
			}
			
		}
		return reverseString;
	}
	
	static void swap(int x,int y) {
		x=x+y;
		y=x-y;
		x=x-y;
		System.out.printf("x: %d  y: %d",x,y);
	}
	
	static boolean checkVowelIsPresent(String s)
	{
		s=s.toLowerCase();
		boolean flag=false;
		for(int i=0;i<s.length();i++) {
			char sChar=s.charAt(i);
			switch(sChar) {
			case 'a':
				flag=true;
				break;
			case 'e':
				flag=true;
				break;
			case 'i':
				flag=true;
				break;
			case 'o':
				flag=true;
				break;
			case 'u':
				flag=true;
				break;
			default:
				break;
			}
			
			if(flag) {
				break;
			}
			
		}
		return flag;
	}
	
	static boolean checkPrime(int i) {
		
		if(i==0 && i==1) {
			return false;
		}else if(i==2) {
			return true;
		}
		else {
			for(int j=2;j<=i/2;j++) {
					
				if(i%j==0) {
					return false;
				}
				
			}
			
		}
		return true;
		
	}
	
	   static int n1=0,n2=1,n3=0;      
	     static void printFibo(int count){      
	        if(count>0){      
	             n3 = n1 + n2;      
	             n1 = n2;      
	             n2 = n3;      
	             //System.out.print(" "+n3);     
	             printFibo(count-1);      
	         }else {
	        	 System.out.print(" "+n3); 
	         }
	     } 
	
}

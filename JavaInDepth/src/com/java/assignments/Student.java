package com.java.assignments;

public class Student {
	
	byte b=12;
	byte _b=1_2; // underscore is introduced above Java 7 versions
	byte bMax=Byte.MAX_VALUE;
	byte bMin=Byte.MIN_VALUE;
	int i=128;
	int _i=1_2_8;
	int iMax=Integer.MAX_VALUE;
	int iMin=Integer.MIN_VALUE;
	private int z;
	
	void compute() {
		System.out.println("_b:"+_b);
		System.out.println("bMin:"+bMin);
	}
	public Student(int z){
		this.z=z;
	}
	boolean equals(Student s1) {
		return s1.z==z;
	}

}

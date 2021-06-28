package com.java.assignments;

 class StudentUtil {

	public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
		// your code GPA-- grade point average
		 double[] gpaList = new double[studentIdList.length];
		int i = 0;
		for (char[] j : studentsGrades) {
			double gpa = 0;
			for (char k : j) {
				switch (k) {
				case 'A':
					gpa = gpa + 4;
					break;
				case 'B':
					gpa = gpa + 3;
					break;
				case 'C':
					gpa = gpa + 2;
					break;
				}
			}
			gpaList[i] = gpa / j.length;
			i++;
		}
		return gpaList;
	}

	public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
		// perform parameter validation. Return null if passed parameters are not valid
		if (lower < 0 || higher < 0 || studentIdList.length == 0 || studentsGrades.length == 0 || lower >= higher) {
			return null;
		}
		// invoke calculateGPA
		double[] gpaList = calculateGPA(studentIdList, studentsGrades);

		// construct the result array and return it. You would need an extra for loop to
		// compute the size of the resulting array
		int count=0;
		for(int i=0;i<gpaList.length;i++) {
			if(lower<gpaList[i] && gpaList[i]<higher) {
				count++;
			}
		}
		int[] result=new int[count];
		count=0;
		for(int i=0;i<gpaList.length;i++) {
			if(lower<gpaList[i] && gpaList[i]<higher) {
				result[count]=studentIdList[i];
				count++;
			}
		}
		return result;
	}

}

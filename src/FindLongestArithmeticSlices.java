/*
 * This is an easy version https://leetcode.com/problems/arithmetic-slices/
	
	Arithmetic sequence definition:
	A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
	
	For example, these are arithmetic sequence:
	1, 3, 5, 7, 9
	7, 7, 7, 7
	3, -1, -5, -9
	
	The following sequence is not arithmetic.
	1, 1, 2, 5, 7
	
	Problem:
	A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
	
	A slice (P, Q) of array A is called arithmetic if the sequence:
	A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
	
	The function should return the longest arithmetic slice in the array A.
	
	Examples:
	A = [1, 2, 3, 4]
	return: 4, the longest arithmetic slice is [1,2,3,4].
	
	B = [3,4,6,8,13,14]
	return 3, the longest arithmetic slice is [4,6,8]
 */

public class FindLongestArithmeticSlices {
	
	static int findLongestArithmeticSlices(int[] A) {
		int n = A.length;
		if (n < 3) return -1;
		
		int[] C = new int[n];
		int max = 0;
		
		if (A[2] - A[1] == A[1] - A[0])
			C[2] = 1;
		
		for (int i = 3; i < n; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2])
				C[i] = C[i - 1] + 1;
			
			max = Math.max(C[i], max);
		}
		
		return max + 2;
	}

	public static void main(String[] args) {
		int[] test_1 = new int[] {1,2,3,4};
		System.out.println(findLongestArithmeticSlices(test_1));
		int[] test_2 = new int[] {3,4,6,8,13,14};
		System.out.println(findLongestArithmeticSlices(test_2));
	}

}

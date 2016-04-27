package leetcode;

/**
	263. Ugly Number - https://leetcode.com/problems/ugly-number/ 
	
	Write a program to check whether a given number is an ugly number.

	Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
	
	Note that 1 is typically treated as an ugly number.
	
 * @author nnoco
 *
 */
public class UglyNumber {
	public static void main(String[] args) {
		boolean result = new UglyNumber().isUgly(2147483647);
		
		System.out.println(result);
	}
	
	public boolean isUgly(int num) {
		if(num == 1) return true;
		
		for(long i = 0, p2 = 1; p2 <= num ; i++, p2 = (long)Math.pow(2, i)) {
			for(long j = 0, p3 = 1; p2*p3 <= num ; j++, p3 = (long)Math.pow(3, j)) {
				for(long k = 0, p5 = 1, product = p2*p3; product <= num; k++, p5 = (long)Math.pow(5, k), product = p2*p3*p5) {
//					System.out.println(i + ", " + j + ", " + k + " = " + product);
					if(product == num) return true;
				}
			}
		}
		
		return false;
    }
}

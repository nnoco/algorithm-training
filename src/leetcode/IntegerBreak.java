package leetcode;

/**
343. Integer break - https://leetcode.com/problems/integer-break/

Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: you may assume that n is not less than 2.

Hint:

There is a simple O(n) solution to this problem.
You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
 * @author nnoco
 *
 */
public class IntegerBreak {
	public static void main(String[] args) {
		IntegerBreak ib = new IntegerBreak();
		
		for(int i = 0 ; i < 20 ; i++) {
			System.out.println(i + " : " + ib.integerBreak(i));
		}
	}
	
	public int integerBreak(int n) {
		if(n > 3) {
			int quotioent = n / 3;
			int remainder = n % 3;
			int power = (int)Math.pow(3, quotioent - 1);
			
			return power * new int[]{3, 4, 6}[remainder];
		} else {
			return n == 2 ? 1 : 2;
		}
    }
	
}

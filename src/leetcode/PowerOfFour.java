package leetcode;

/**
 342. Power of four - https://leetcode.com/problems/power-of-four/
 
 Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?

 * @author nnoco
 *
 */
public class PowerOfFour {
	public static void main(String[] args) {
		boolean result = new PowerOfFour().isPowerOfFour(4*4*4*4*4*4*4*4*4*4);
		
		for (int i = 0 ; i < 32 ; i++) {
			System.out.println(i + " " + (int)Math.pow(2, i));
		}
		
		System.out.println(1 << 30);
	}
	
	// log 변환
	// 4^x = num
	// -> log_10(4^x) = log_10(num)
	// 2x * log_10(2) = log_10(num)
	// x = log_10(num) / (2 * log_10(2))
	// x가 epsilon보다 작거나 같은지 체크 
	public boolean isPowerOfFour(int num) {
		return Math.log(num) / (2 * Math.log(2)) % 1 <= Math.ulp(0);
	}
}

package leetcode;

/**
231. Power of two - https://leetcode.com/problems/power-of-two/
Given an integer, write a function to determine if it is a power of two.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * @author nnoco
 *
 */
public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		return n > 0 && (1 << 30) % n == 0;
    }
	
	// 진수 변환, log 적용(epsilon 고려)
	// 그냥 brute force
}

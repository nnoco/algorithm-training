package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
	202. Happy Number - https://leetcode.com/problems/happy-number/
	
	Write an algorithm to determine if a number is "happy".

	A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
	
	Example: 19 is a happy number
	
	1^2 + 9^2 = 82
	8^2 + 2^2 = 68
	6^2 + 8^2 = 100
	1^2 + 0^2 + 0^2 = 1
	
 * @author nnoco
 *
 */
public class HappyNumber {
	public boolean isHappy(int n) {
        Set<Integer> calculated = new HashSet<Integer>();
        
        while(n != 1) {
            if(calculated.contains(n)) {
                return false;
            }
            
            calculated.add(n);
            
            char[] digits = Integer.toString(n).toCharArray();
            n = 0;
            
            for(char digit : digits) {
                n += (int)Math.pow((int)digit - '0', 2);    
            }
        }
        
        return true;
    }
}

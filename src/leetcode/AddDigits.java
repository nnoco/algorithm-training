package leetcode;


/**
	258. Add Digits - https://leetcode.com/problems/add-digits/
	
	Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

	For example:
	
	Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
	
	Follow up:
	Could you do it without any loop/recursion in O(1) runtime?
	
	어떻게 재귀/루프 없이하지..? ;;
 * @author nnoco
 *
 */
public class AddDigits {
	public static void main(String[] args) {
		int result = new AddDigits().addDigits(11398);
		System.out.println(result);
	}
	public int addDigits(int num) {
		char[] digits = Integer.toString(num).toCharArray();
		
		int sum = 0;
		
		for(char digit : digits) {
			sum += digit - '0';
		}
		
		return sum < 10 ? sum : addDigits(sum);
    }
}

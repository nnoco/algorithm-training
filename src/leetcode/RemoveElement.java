package leetcode;

import java.util.Arrays;

/**
	[E]27. Remove Element - https://leetcode.com/problems/remove-element/
	
	Given an array and a value, remove all instances of that value in place and return the new length.

	Do not allocate extra space for another array, you must do this in place with constant memory.
	
	The order of elements can be changed. It doesn't matter what you leave beyond the new length.
	
	Example:
	Given input array nums = [3,2,2,3], val = 3
	
	Your function should return length = 2, with the first two elements of nums being 2.
 * @author nnoco
 *
 */
public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int count = nums.length;
		for(int i = 0, len = count; i < len; i++) {
			if(nums[i] == val) {
				count--;
				
				for(int j = i; j < count; j++) {
					nums[j] = nums[j+1];
				}
				
				nums[count] = ~val;
				i--;
			}
		}
		
		return count;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1,1,3,4,5,5,5,6,7,8,8,10};// {3,3};{3, 2,2,3};
		int result = new RemoveElement().removeElement(nums, 3);
				
		for(int num : Arrays.copyOf(nums, result)) {
			System.out.println(num);
		}
	}
}

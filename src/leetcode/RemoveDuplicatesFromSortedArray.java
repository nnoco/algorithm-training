package leetcode;

import java.util.Arrays;

/**
	[E] 26. Remove Duplicates from Sorted Array- https://leetcode.com/problems/remove-duplicates-from-sorted-array/
	
	Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

	Do not allocate extra space for another array, you must do this in place with constant memory.
	
	For example,
	Given input array nums = [1,1,2],
	
	Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * @author nnoco
 *
 */
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int count = nums.length;
		int cursor = -1;
		for(int i = 0, len = count-1; i < len; i++) {
			if(nums[i] == nums[i+1]) {
				count--;
				
				if(cursor == -1) {
					cursor = i+1;
				}
			} else if(nums[i] != nums[i+1] && cursor != -1) {
				nums[cursor] = nums[i+1];
				cursor++;
			}
		}
		
		return count;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1,1,3,4,5,5,5,6,7,8,8,10};
		int result = new RemoveDuplicatesFromSortedArray().removeDuplicates(nums);
				
		for(int num : Arrays.copyOf(nums, result)) {
			System.out.println(num);
		}
	}
}

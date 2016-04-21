package leetcode;

import java.util.Arrays;

/**
	1. Two Som - https://leetcode.com/problems/two-sum/
	
	Given an array of integers, return indices of the two numbers such that they add up to a specific target.

	You may assume that each input would have exactly one solution.
	
	Example:
	Given nums = [2, 7, 11, 15], target = 9,
	
	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
	
	괜히 잔꾀부린다고 정렬하고.. target보다 크면 제외하다가 더 꼬여서 그냥 O(n^2)로..;;
	근데 같은 Two Sum 문제 중에 정렬된 입력값이 주어지는 문제도 있다. 근데 유료
	
 * @author nnoco
 *
 */
public class TwoSum {
	public static void main(String[] args) {
		int[] result = new TwoSum().twoSum(new int[]{-3, 4, 3, 90}, 0);
		
		System.out.println(Arrays.toString(result));
	}
	
	public int[] twoSum(int[] nums, int target) {
		int[] result = null;
		int sum;
		
		loop:
		for(int i=0; i<nums.length; i++) {
			for(int k=0; k<nums.length; k++) {
				if(i==k) continue;
				sum = nums[i] + nums[k];
				
				if (sum == target) {
					result = new int[]{i, k};
					break loop;
				}
			}
		}
		
		
		return result;
    }
}

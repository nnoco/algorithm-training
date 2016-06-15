package leetcode;

/**
	334.Increasing Triplet Subsequence - https://leetcode.com/problems/increasing-triplet-subsequence/ 
	
	 Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

	Formally the function should:
	Return true if there exists i, j, k 
	such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
	Your algorithm should run in O(n) time complexity and O(1) space complexity.
	
	Examples:
	Given [1, 2, 3, 4, 5],
	return true.
	
	Given [5, 4, 3, 2, 1],
	return false.
 * @author nnoco
 *
 */

public class IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) {
		for(int min = 0; min < nums.length; min++) {
			for(int max = nums.length-1 ; max > min ; max--) {
				for(int mid = min+1; mid < max; mid++) {
					if(nums[min] < nums[mid] && nums[mid] < nums[max]) return true;
				}
			}
		}
		
		return false;
    }
	
	public static void main(String[] args) {
		int[] nums = {
				2,1,5,0,4,6
		};
		boolean result = new IncreasingTripletSubsequence().increasingTriplet(nums);
		
		System.out.println(result);
	}
}

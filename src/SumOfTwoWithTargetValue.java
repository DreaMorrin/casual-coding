/*
 * Given a list of integers and a target number, print out all possibility combinations
 */

import java.util.*;

public class SumOfTwoWithTargetValue {
	
	static List<List<Integer>> sumOfTwo(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> lists = new ArrayList<>();
		
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			if (nums[start] + nums[end] == target) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(nums[start]);
				list.add(nums[end]);
				lists.add(list);
				start++;
				end--;
			}
			else if (nums[start] + nums[end] < target) {
				start++;
			}
			else {
				end--;
			}
			
			while (start > 0 && nums[start-1] == nums[start]) { start++; }
			while (end < nums.length - 1 && nums[end + 1] == nums[end]) { end--; }
		}
		
		return lists;
	}
	
	public static void main(String[] args) {
		int[] x = {3,2,5,-1,4,-8,10,-4,-1,-2,7,8,4,2,8,2,1,4,-4,-3};
		int target = 5;
		System.out.println(sumOfTwo(x, target));
	}
}

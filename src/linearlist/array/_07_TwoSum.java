package linearlist.array;

import java.util.HashMap;
import java.util.Map;

public class _07_TwoSum {

	public static void main(String[] args) {
		int[] nums = {5,6,100,4, 200,7,8,9, 1, 3, 2};
		int target = 4;
		int[] result = twoSum1(nums, target);
		for (int i : result) {
			System.out.println(i);
		}
	}

	/**
	 * 再给定的数组中寻找两个元素之和为目标元素
	 * @param nums		给定的数组
	 * @param target	目标元素
	 * @return	返回两个元素的下标
	 */
	//暴力搜索	time:O(n^2),space:O(1)
	private static int[] twoSum1(int[] nums,int target) {
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(target - nums[i] == nums[j]){
					return new int[]{i,j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	//hashtable	time:O(n),space:O(n)
	private static int[] twoSum2(int[] nums,int target) {
		
		/*
		 * 把数组里面的元素放入map中，map的key存储元素值，value存储该元素再数组中的下标
		 * 在此过程中：如果当前map中存在target-nums[i]，
		 * 立刻返回当前元素的下标和map中相应元素的下标，使得再暴力搜索中查找元素的时间复杂度
		 * 从O(n)降低到O(1).
		 */
		
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(target-nums[i])){
				return new int[]{map.get(target-nums[i]),i};
			}
			map.put(nums[i], i);
		}
		
		throw new IllegalArgumentException("No two sum solution");
	}
	
	
}

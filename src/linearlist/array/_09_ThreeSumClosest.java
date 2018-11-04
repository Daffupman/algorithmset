package linearlist.array;

import java.util.Arrays;

public class _09_ThreeSumClosest {

	/*
	 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number,
	 * target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
	 * For example, given array S = {-1 2 1 -4}, and target = 1.
	 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	 */
	
	/*
	 * 一些思考：
	 * 在有序的数组查找元素，使用二分思想，可高效率。此外利用二分思想，low和high指针之和可以随着目标数
	 * 而灵活变化，大于目标数，后移high指针，反之，迁移low指针
	 */
	
	public static void main(String[] args) {
		int[] nums = {0,2,1,-3};
		int target = 1;
		System.out.println(threeSumClosest1(nums,target));
	}

	

	/*
	 * 基本思路：
	 * 在有序的情况下，选择三个元素求和，使之逼近目标元素
	 */
	private static int threeSumClosest2(int[] nums, int target) {
		
		//排好序
		Arrays.sort(nums);
		
		int result = nums[0]+nums[1]+nums[nums.length-1];
		
		for(int i = 0; i < nums.length-2; i++){
			int currentNum = nums[i];
			//对当前元素之后的元素，采用二分法思想，求三数和，寻找最靠近的和
			int low = i+1,
				high = nums.length-1;
			while(low < high){
				int sum = nums[i]+nums[low]+nums[high];
				if(sum > target){
					high--;
				} else {
					low++;
				}
				if(Math.abs(target-sum)<Math.abs(result-sum)){
					result = sum;
				}
			}
		}
		
		return result;
	}

	//三指针：O(n^​2) runtime,
	public static int threeSumClosest1(int[] nums,int target) {
		//使数组有序
		Arrays.sort(nums);
		
		//最接近target的三数之和
	    int result = nums[0]+nums[1]+nums[nums.length-1];
	    for(int i=0; i<nums.length-2; i++){
	    	//对后面的元素利用二分思想
	    	int low = i+1,
	    		high = nums.length-1;
	    	
	    	while(low<high){
	    		int sum = nums[i]+nums[low]+nums[high];
	    		if( sum < target)
	    			low++;
	    		else
	    			high--;
	    		if(Math.abs(sum-target) < Math.abs(result-target)){
	    			result = sum;
	    		}
	    	}
	    }
	    return result;
	}
	
}

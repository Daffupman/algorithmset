package linearlist.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _10_4Sum {

	/*
	 * Given an array S of n integers, are there elements a,b,c, and d in S such that a+b+c+d = target?
	 * Find all unique quadruplets in the array which gives the sum of target.
	 * Note:
	 * • Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
	 * • The solution set must not contain duplicate quadruplets.
	 */
	
	/*
	 * 无论使2Sum,3Sum,3SumClosest,4Sum还是其他，都体现了二分思想的重要性，尤其是有序的集合中
	 * 提高了搜索效率，其中kSum()的提取使得方法更加通用
	 */
	
	public static void main(String[] args) {
		int[] nums = {0,1,5,0,1,5,5,-4};
		List<List<Integer>> result =  fourSum(nums,11);
		for (List<Integer> res : result) {
			System.out.println(res.toString());
		}
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		//使数组有序化
        Arrays.sort(nums);
        
        return kSum(nums, 0, 4, target);
    }
    /**
     * 在给定的数组里，求k个数之和为target，把这k个数返回
     * @param nums		给定的数组
     * @param start		开始的下标
     * @param k			k个数
     * @param target	k个数的和
     * @return
     */
    private static List<List<Integer>> kSum (int[] nums, int start, int k, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //求两数之和，此时采用二分思想，问题转化为TwoSum,求取两数之和为target
        if(k == 2) { 
            int left = start, right = len - 1;
            while(left < right) {
                int sum = nums[left] + nums[right];
                if(sum == target) {
                    List<Integer> path = new ArrayList<Integer>();
                    path.add(nums[left]);
                    path.add(nums[right]);
                    res.add(path);
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < target) { //move left
                    left++;
                } else { //move right
                    right--;
                }
            }
        } else if(k > 2){
            for(int i = start; i < len - (k - 1); i++) {
            	//去除和前面元素重复的情况,当前数的后面的元素可能与当前数相等
                if(i > start && nums[i] == nums[i - 1]) continue;
                //优化开始----------------------------------------------------------
                //当前数最大的情况，还是小于target，说明当前数太小，跳过后续步骤，直接考虑当前数的下一个数
                if(nums[i]+(k-1)*nums[nums.length-1] < target){
                	continue;
                }
                //当前数的k倍大于target，说明当前数太大，停止循环，不需要再往后寻找，因为后面的数只可能变大
                if(nums[i]*k > target){
                	break;
                }
                //当前数的k倍等于target，此时当前数处于边界情况
                if(nums[i]*k == target){
                	//如果从当前数开始的连续的k个数一样，那么直接返回结果
                	if(i+(k-1) < nums.length && nums[i+(k-1)] == nums[i]){
                		List<Integer> temp = new ArrayList<Integer>();
                		for (int j = 0; j < k; j++) {
							temp.add(nums[i]);
						}
                		res.add(temp);
                        return res;
                	}
                }
                //优化结束----------------------------------------------------------
                List<List<Integer>> temp = kSum(nums, i + 1, k - 1, target - nums[i]);
                //把当前数加入当前结果集
                for(List<Integer> t : temp) {
                    t.add(0, nums[i]);
                }             
                //把当前结果集加入最终结果集
                res.addAll(temp);
            }
        } else {
        	throw new RuntimeException("k不得小于2");
        }
        return res;
    }
	
}

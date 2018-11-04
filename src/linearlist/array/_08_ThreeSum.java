package linearlist.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _08_ThreeSum {

	/*
	 * Given an array S of n integers, are there elements a,b,c in S such that a + b + c = 0? Find all unique
	 * triplets in the array which gives the sum of zero.
	 * Note:
	 * • Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
	 * • The solution set must not contain duplicate triplets.
	 * For example, given array S = {-1 0 1 2 -1 -4}.
	 * A solution set is:
	 * (-1, 0, 1)
	 * (-1, -1, 2)
	 */
	
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> result = threeSum1(nums);
		for (List<Integer> i : result) {
			System.out.println(i.toString());
		}
	}

	//暴力解法：O(n^​4) runtime, O(n) space
	//三层循环，遍历所有的情况。但需要注意的是，我们需要把重复的情况去除掉，就是 [1, -1 ,0] 和 [0, -1, 1] 是属于同一种情况的。
	// Time Limit Exceeded
	public static List<List<Integer>> threeSum1(int[] nums) {
		//存储list集合，list集合存储的是三个和数之和为0
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    for (int i = 0; i < nums.length; i++) {
	        for (int j = i + 1; j < nums.length; j++)
	            for (int k = j + 1; k < nums.length; k++) {
	                if (nums[i] + nums[j] + nums[k] == 0) {
	                	//存储三个数之和为0
	                    List<Integer> temp = new ArrayList<Integer>();
	                    temp.add(nums[i]);
	                    temp.add(nums[j]);
	                    temp.add(nums[k]); 
	                    //判断结果中是否已经有 temp 。
	                    if (!isInList(res, temp)) {
	                        res.add(temp);
	                    }
	                }
	            }
	    }
	    return res;

	}

	public static boolean isInList(List<List<Integer>> l, List<Integer> a) {
	    for (int i = 0; i < l.size(); i++) {
	        //判断两个 List 是否相同
	        if (isSame(l.get(i), a)) {
	            return true;
	        }
	    }
	    return false;
	}

	public static boolean isSame(List<Integer> a, List<Integer> b) {
	    Collections.sort(a);
	    Collections.sort(b);
	    //排序后判断每个元素是否对应相等
	    for (int i = 0; i < a.size(); i++) {
	        if (a.get(i) != b.get(i)) {
	            return false;
	        }
	    }
	    return true;
	}
	
	//主要思想是，遍历数组，用 0 减去当前的数，作为 sum ，然后再找两个数使得和为 sum。
	//O(n^​2) runtime, O(n) space
	public static List<List<Integer>> threeSum2(int[] nums) {
		//先排序
		Arrays.sort(nums);
		//存储结果
		List<List<Integer>> result = new LinkedList<>();
		
		for(int i = 0; i < nums.length-2; i++){
			//i要么是第0个元素，要么该元素与前一个元素不同（去除重复元素）
			if( i == 0 || ( i > 0 && nums[i] != nums[i-1] )){
				//对后面的元素，利用二分查找
				//设置头
				int low = i+1,
					high = nums.length-1,
					sum = 0 - nums[i];
				while(low < high){
					//如果此时的头指针和指针所指向的元素之和为sum，则加入result集合，
					//如果小于sum，low++，大于sum，high--
					if(nums[low] + nums[high] == sum){
						result.add(Arrays.asList(nums[i],nums[low],nums[high]));
						//同时剔除重复元素
						while( low<high && nums[low] == nums[low+1] ) low++;
						while( low<high && nums[high] == nums[high-1] ) high--;
						low++; high--;
					}else if(nums[low] + nums[high] < sum){
						low++;
					}else{
						high--;
					}
				}
			}
		}
		
		return result;
		
	}
	
	
}

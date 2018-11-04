package linearlist.array;

import java.util.HashSet;
import java.util.Set;

public class _06_LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] nums = {3,2,1,0,-1,-2,-3};
//		System.out.println(longestConsecutive1(nums));
		System.out.println(longestConsecutive2(nums));
	}

	/**
	 * 获取数组中的最大连续子列
	 * @param nums	目标数组
	 * @return	返回最大连续子列的长度
	 */
	//未通过，Time Limit Exceeded
	public static int longestConsecutive1(int[] nums) {
		//记录当前最大子列的长度
        int longest = 1;
        
        if(nums.length == 0)
        	return 0;
        
        //遍历数组
        for(int i = 0; i < nums.length; i ++){
        	//该数组当前元素
            int forwardNum = nums[i];
            int backwardNum = nums[i];
            //当前元素的连续子列的长度
            int count = 1;
            //如果在nums中存在下一个元素，长度加一
            while(contains(nums,++forwardNum)){
                count++;
            }
            //如果在nums中存在上一个元素，长度加一
            while(contains(nums,--backwardNum)){
            	count++;
            }
            	
            //更新最大子列长度
            longest = count > longest ? count:longest;
        }
        return longest;
    }
	
	//该数组中是否存在target
    public static boolean contains(int[] nums,int target){
        for(int num : nums){
            if(num == target)
                return true;
        }
        return false;
    }
	
    /*
     * 此方法和方法一的比较：
     * 	方法一，由于是数组的原因，指针指向下一个元素之后，便不再考虑之前的元素
     * 		    所以当前元素需要向两边延申，
     * 	方法二，当前元素是和整个set里面的元素比较，又不考虑负方向的增长，相比之下，提高效率。
     */
	private static int longestConsecutive2(int[] nums){
		
		//数组为空，返回0
		if(nums.length == 0){
            return 0;
        }
		
		//把数组里的元素加入进set集合，由于set的特性，不存在重复元素
		Set<Integer> numSet = new HashSet<>();
		for (int num : nums) {
			numSet.add(num);
		}
		
		//当前最大连续子列
		int longestStreak = 1;
		
		//遍历numSet
		for (Integer num : numSet) {
			//只有当set中有元素大于当前元素时，才执行，这样可以只考虑增加的情况，提高效率
			if(!numSet.contains(num-1)){
				int currentNum = num;
				int currentStreak = 1;
				while(numSet.contains( currentNum+1 )){
					currentStreak ++;
					currentNum ++;
				}
				longestStreak = Math.max(currentStreak, longestStreak);
			}
		}
		
		return longestStreak;
	}
	
}

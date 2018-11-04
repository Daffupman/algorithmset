package linearlist.array;

public class _02_RemoveDuplicatesFromSortedArrayII {


	/*
	 * 两种方法的比较：
	 * 本质上两种方法的想法是一样的，都是遍历数组，隔元素比较是否相等（由于允许相同的元素存在两个）
	 * 但是第二种方法拓展更方便一些，只要修改allowReapt参数就可以实现最多允许相同元素存在的次数。
	 * 当将allowReapeat值修改为1时，就是上一题的解法。
	 */
	
	public static void main(String[] args) {
		int[] array = {1,2,3,3,3,5,5,5,8};
		int len = removeDuplicates2(array);
		for(int i = 0; i<len; i++){
			System.out.print(array[i]+" ");
		}
	}
	
	/**
	 * 移除数组内元素，使得数组内的元素的重复不能超过两个
	 * @param nums		目标数组
	 * @return	返回符合要求的新数组的长度
	 */
	private static int removeDuplicates1(int[] nums){
		if(nums.length <= 2){
			return nums.length;
		}
		int index = 2;
		for(int i = 2; i < nums.length; i++){
			if(nums[i] != nums[index-2]){
				nums[index++] = nums[i];
			}
		}
		return index;
	}
	
	public static int removeDuplicates2(int[] nums) {
	    int i = 0;
	    //允许相同的元素出现的次数
	    int allowRepeat = 2 ;
	    for (int n : nums){
	    	if (i < allowRepeat || n > nums[i-allowRepeat]){
	    		nums[i++] = n;
	    	}
	    }
	    return i;
	}
	
}

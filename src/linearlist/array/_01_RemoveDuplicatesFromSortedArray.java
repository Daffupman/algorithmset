package linearlist.array;

public class _01_RemoveDuplicatesFromSortedArray {

	/*
	 * 一些思考：感觉上，指针i像是一个为新数组寻找合适元素的前锋，在他的辨别下，
	 * 只有合适的元素（与新数组里的元素不重复）才会纳入新数组的麾下。
	 */
	
	public static void main(String[] args) {
		int[] array = {1,1,3,3,5,5,6,7,8};
		int len = removeDuplicates(array);
		for(int i = 0; i<len; i++){
			System.out.print(array[i]+" ");
		}
	}

	/**
	 * 给定一个有序的数组，去除重复元素，
	 * time:O(n),space:O(1)
	 * @param nums		给定的有序数组
	 * @return	返回新数组的长度
	 */
	private static int removeDuplicates(int[] nums) {
		//新数组的下标
		int index = 0;
		//从第二个数遍历数组
		for(int i = 1; i < nums.length; i ++){
			//如果指针i对应的数与指针index对应的数相等，那么加入新数组
			if(nums[index] != nums[i] ){
				nums[++index] = nums[i];
			}
		}
		return index+1;
	}
	
}
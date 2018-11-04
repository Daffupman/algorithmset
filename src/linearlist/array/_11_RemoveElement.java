package linearlist.array;

public class _11_RemoveElement {

	/*
	 * Given an array and a value, remove all instances of that value in place and return the new length.
	 * The order of elements can be changed. It doesn’t matter what you leave beyond the new length.
	 */
	
	public static void main(String[] args) {
		int[] nums1 = {4,1,2,3,4};
		int[] nums2 = {4,1,2,4,4,0,0};
		int val=4;
//		System.out.println(removeElement(nums1, val));
		System.out.println(removeRareElement(nums2,4));
	}

	//双指针：Time complexity : O(n)
	//     Space complexity : O(1).
	public static int removeElement(int[] nums, int val) {
		//记录处理完成之后的数组指针，又称新指针
		int i = 0;
		
		//遍历整个数组
		for (int j = 0; j < nums.length; j++) {
			//如果当前值与val不一样，新指针后移
			if(nums[j] != val){
				nums[i++] = nums[j];
			}
		}
		return i;
    }
	
	//双指针：只有很少的元素需要移除时，效率高
	//Time complexity : O(n)
	//Space complexity : O(1)
	public static int removeRareElement(int[] nums,int val){
		//如果发现当前元素与目标元素相等，使用最后一个元素替换
        //结果数组的长度
        int len = nums.length;
        for(int i = 0; i < len; i++){
            //确保最后一个元素与目标元素不等
            while(len > 0 && nums[len-1] == val){
                len--;
            }
            //使用最后一个元素替换的时候，同时需要判断当前长度是否大于i，
            //大于i的原因：如果指针不在结果数组的范围便不再考虑。
            if(len > i && nums[i] == val && nums[len-1] != val){
                nums[i] = nums[len-1];
                len--;
            }
        }
        return len;
	}
	
}

package linearlist.array;


public class _12_NextPermutation {

	//Implement next permutation, which rearranges numbers into the lexicographically next greater permu-tation of numbers.
	//If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascend-ing order).
	//The replacement must be in-place, do not allocate extra memory.
	
	public static void main(String[] args) {
		int[] nums = {1,5,1};
		nextPermutation(nums);
		for (int i : nums) {
			System.out.print(i+"\t");
		}
	}

	//Time complexity : O(n). In worst case, only two scans of the whole array are needed.
	//Space complexity : O(1). No extra space is used. In place replacements are done
	public static void nextPermutation(int[] nums) {
        /*
         *下一个排列组合的算法思路：
         *1.从尾部开始寻找第一个破环数组有序的元素，并把那个元素命名为partitionNumber
         *2.再从尾部开始寻找一个大于partitionNumber的元素，并把那个元素命名为changeNumber
         *3.交换partitionNumber和changeNumber
         *4.把partitionNumber右侧的所有元素交换位置
         */
        
        //从右往左寻找第一个破环数组有序的元素
        //i指针为partitionNumber的指针
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i --;
        }
        if(i>=0){
            //j为changeNumber的指针
            int j = nums.length-1;
            while(j>=0 && nums[j]<=nums[i]){
                j --;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }
    
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void reverse(int[] nums,int start){
        int low = start,high = nums.length-1;
        while(low<high){
            swap(nums,low,high);
            low++;
            high--;
        }
    }

}

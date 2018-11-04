package linearlist.array;

public class _03_SearchInRotatedSortedArray {

	/**
	 * 变种的二分法搜索：
	 * 在指针low和high不等的情况下：
	 * 1.判断array[mid]与target是否相等，相等则返回其下标，不等，走2；
	 * 2.再使用条件array[low]<array[mid],界定单调区间，
	 * 	 true则代表左边是单调区间，走3，false则代表右边是单调区间，走4；
	 * 3.判断target是否在这个单调区间，true则high=mid，false则low=mid+1,走1
	 * 4.判断target是否在这个单调区间，true则high=low=mid+1，false则low=mid,走1
	 */
	
	public static void main(String[] args) {
		int array[] = {4,5,0,1,2};
		System.out.println(search(array,1));
	}
	
	/**
	 * 在给定的数组里面搜索元素
	 * @param nums		该数组(无重复元素)是一个有序的，但是它按着某一轴转动过
	 * @param target	目标元素
	 * @return		返回目标元素的下标
	 * time:O(logn)
	 */
	private static int search(int[] nums,int target){
		int low = 0,
			mid = 0,
			high = nums.length - 1;
		while(low <= high){
			mid = (low + high) / 2;
			if(nums[mid] == target){
				return mid;
			}
			//-------------------------
			//简单的优化
			if(nums[low] == target){
				return low;
			}
			if(nums[high] == target){
				return high;
			}
			//-------------------------
			//前往单调区间
			if(nums[low] <= nums[mid]){
				if(target >= nums[low] && target < nums[mid] ){
					//如果元素在单调区间内，则把high指针移向该区间
					high = mid - 1;
				} else {
					//否则，把low指针移走该区间
					low = mid + 1;
				}
			} else {
				if(target > nums[mid] && target <= nums[high]){
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}
	
	//普通二分法，针对已经排好序的数组
	private static int binarySearch(int[] array,int target){
		int low = 0,
			high = array.length-1;
		while(low <= high){
			int mid = (low + high)/2;
			System.out.println("low:"+low+",high:"+high+",mid:"+mid+"\n");
			if(array[mid] == target){
				return mid;
			}
			if(array[mid] < target){
				low = mid + 1;
			}
			if(array[mid] > target){
				high = mid - 1;
			}
		}
		return -1;
	}
	
}

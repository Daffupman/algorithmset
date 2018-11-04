package linearlist.array;

public class _04_SearchInRotatedSortedArrayII {

	/*
	 * 此题与上一题的区别在于，数组内的元素可重复。本来是可以通过条件：array[low] < array[mid]，
	 * 断定某个区域不受rotate影响，是有序的。但此题已经不可用。
	 * 在low，high，mid三处元素一样时，上题方法就无法处理，这时我们只能让边界指针low前进，
	 * 直到元素不等。
	 * 
	 * https://blog.csdn.net/linhuanmars/article/details/20588511
	 */
	
	public static void main(String[] args) {
		int array[] = {1,3,1,1,1};
		System.out.println(search1(array,3));
	}
	
	/**
	 * 在给定的有序数组中，寻找目标元素，但是该数组按某个轴转动过，并且数组中的元素可重复多次
	 * @param nums		给定的按某个轴转动的有序数组，数组内元素可重复多次
	 * @param target	目标元素
	 * @return	返回该数组中是否存在目标元素
	 * time:O(n)
	 */
	private static boolean search1(int[] nums,int target){
		int low = 0,
			high = nums.length - 1;
		int mid = 0 ;
		while(low <= high){
			mid = (low + high)/2;
			if(nums[mid] == target){
				return true;
			}
			if(nums[low] < nums[mid]){
				//该区域是有序的
				if(target >= nums[low] && target < nums[mid]){
					//target在这个有序的区域内,high指针移进该区域
					high = mid - 1;
				} else {
					//low指针移除该区域
					low = mid + 1;
				}
			} else if(nums[low] > nums[mid]) {
				if (target >= nums[mid] && target <= nums[high]){
					//target在这个有序的区域内，low指针移进该区域
					low = mid + 1;
				} else {
					//high指针移除该区域
					high = mid - 1;
				}
			} else {
				low ++;
			}
		}
		return false;
	}
	
	/*
	 * 此方法是对上一个方法的小小优化
	 * 1.在low，mid，high三处的值均判断是否为target
	 * 2.如果target小于low处的值且大于high处的值，那么这个数不存在，
	 * 	 分析如下：例数组[3,4,5,1,2],显而易知，数组不会存在target，又如[3,4,5,0,1],[1,2,3,4,5]
	 */
	public static boolean search(int[] array,int target){
		int low = 0,
			high = array.length - 1;
		int mid = 0;
		while(low <= high) {
			mid = (low + high)/2;
			/* ----- 优化1开始 ----- */
			if(array[mid] == target){
				return true;
			}
			if(array[low] == target){
				return true;
			}
			if(array[high] == target){
				return true;
			}
			/* ----- 优化1结束 ----- */
			
			/* ----- 优化2结束 ----- */
			if(target > array[high] && target < array[low]){
				return false;
			}
			/* ----- 优化2结束 ----- */
			
			if(array[low] < array[mid]){
				if(target >= array[low] && target <= array[mid]){
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if(array[low] > array[high]){
				if(target >= array[mid]){
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				low ++;
			}
		}
		
		return false;
	}
}

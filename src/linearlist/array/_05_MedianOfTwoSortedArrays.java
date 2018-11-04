package linearlist.array;

public class _05_MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = {1,3};
		int[] nums2 = {2};
		System.out.println(findMedianSortedArrays(nums1,nums2));
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int totalLength = nums1.length + nums2.length;
		if(totalLength%2 != 0){
			//两数组的长度之和为奇数
			return findKthSortedArrays(nums1, nums2, totalLength/2+1);
		} else {
			//两数组的长度之和为偶数
			return (findKthSortedArrays(nums1, nums2, totalLength/2)
				+ findKthSortedArrays(nums1, nums2, totalLength/2+1))/2;
		}
	}

	/**
	 * 在有序的两个数组中找到第k大的元素
	 * @param nums1		有序数组nums1
	 * @param nums2		有序数组nums2
	 * @param Kth		第Kth大
	 * @return	返回第Kth大的元素
	 * time:O(m+n)
	 */
	public static double findKthSortedArrays(int[] nums1, int[] nums2, int Kth) {
		//分别指向数组A，B第一个位置的指针
		int ptrA = 0,
			ptrB = 0;
		//当前是第k大的元素，位次变量
		int k = 0;
		int lenA = nums1.length;
		int lenB = nums2.length;
		
		//不存在第k大的元素，k大于nums1和nums2的长度之和
		if(Kth > lenA + lenB || Kth <= 0){
			return -1;
		}
		
		while(true){
			if(nums1.length==0){
				return nums2[Kth-1];
			}
			if(nums2.length==0){
				return nums1[Kth-1];
			}
			//如果nums1的当前元素小于等于nums2的当前元素
			if(nums1[ptrA] <= nums2[ptrB]){
				//nums1指针后移
				ptrA ++;
				//位次变量加一
				k ++;
				//找到了第k大的元素，返回该元素
				if(k == Kth)
					return nums1[ptrA-1];
				//如果nums1的元素都小于nums2的元素，返回nums2[Kth-ptrA-1]
				if( ptrA == lenA){
					return nums2[Kth-ptrA-1];
				}
			}else{
				ptrB ++;
				k ++;
				if(k == Kth)
					return nums2[ptrB-1];
				if( ptrB == lenB){
					return nums1[Kth-ptrB-1];
				}
			}
			
		}
	}
}

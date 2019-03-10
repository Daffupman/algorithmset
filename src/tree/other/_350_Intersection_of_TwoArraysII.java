package tree.other;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @program: algorithmset
 * @description:
 * @author: Daffupman
 * @create: 2019-03-10 15:19
 **/
public class _350_Intersection_of_TwoArraysII {

	public int[] intersect(int[] nums1, int[] nums2) {

		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int num : nums1) {
			if(!map.containsKey(num)) {
				//map中还没有i这个key
				map.put(num,1);
			} else {
				map.put(num, map.get(num)+1);
			}
		}

		//存放并集结果
		ArrayList<Integer> list = new ArrayList<>();
		for (int num : nums2) {
			if(map.containsKey(num)) {
				list.add(num);
				map.put(num, map.get(num)-1);
				if(map.get(num) == 0) {
					map.remove(num);
				}
			}
		}

		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		int[] res = (new _350_Intersection_of_TwoArraysII()).intersect(nums1, nums2);
		for (int item : res) {
			System.out.println(item);
		}
	}

}

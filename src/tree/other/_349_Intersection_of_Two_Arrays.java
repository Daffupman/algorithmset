package tree.other;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @program: algorithmset
 * @description:
 * @author: Daffupman
 * @create: 2019-03-10 14:41
 **/
public class _349_Intersection_of_Two_Arrays {

	//借助集合的元素不可重复性，先将nums1里的元素去重，
	//遍历num2的时候再判断是否存在，存在就放入list中，并把set中的相同的元素移除
	public int[] intersection(int[] nums1, int[] nums2) {

		TreeSet<Integer> set = new TreeSet<>();
		for (int num1 : nums1) {
			set.add(num1);
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int num2 : nums2) {
			if(set.contains(num2)) {
				list.add(num2);
				//移除的话可以去除重复的情况
				set.remove(num2);
			}
		}

		int[] res = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums1 = {4,9,5},
			  nums2 = {9,4,9,8,4};
		int[] res = (new _349_Intersection_of_Two_Arrays()).intersection(nums1, nums2);
		for (int item : res) {
			System.out.println(item);
		}
	}

}

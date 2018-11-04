package linearlist.array;

import java.util.ArrayList;
import java.util.List;

public class _13_PermutationSequence {

	//The set [1,2,3,?,n] contains a total of n! unique permutations.
	//By listing and labeling all of the permutations in order, We get the following sequence (ie, for n = 3):
	
	/*
	 * https://www.cnblogs.com/grandyang/p/4358678.html
	 */
	
	public static void main(String[] args) {
		System.out.println(getPermutation(4,9));
	}

	public static String getPermutation(int n, int k) {
		//思路：根据位次选择排列组合
        //由1,2,...,n组成的list
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            numbers.add(i);
        }
        //n位数的可能性
        int[] factorial = new int[n];
        factorial[0] = 1;
        int sum = 1;
        for(int i = 1; i < n; i++){
            sum *= i;
            factorial[i] = sum; 
        }
        //存储需要的排列组合
        StringBuilder sb = new StringBuilder();
        
        //位次减一就是下标
        k--;
        
        //根据位次，获取需要的排列组合
        for(int i = 1; i <= n; i++){
            int index = k/factorial[n-i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index*factorial[n-i];
        }
        return String.valueOf(sb);
	}
	
}

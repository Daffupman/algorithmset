package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Daffupman
 * @date 2018/11/13 19:44
 */
public class _10_IntegertoRoman {

    /**
     * Given an integer, convert it to a roman numeral.
     * Input is guaranteed to be within the range from 1 to 3999.
     */
    public static void main(String[] args){
        System.out.println("MCMXCIV"+":"+romanToInt("MCMXCIV"));
    }

    /**
     * 思路：从右往左，左边的字母代表的数大于等于右边字母代表的数，加法处置，反之减法处理
     */
    public static int romanToInt(String s) {
        //字母对应的数字存储在Map中
        Map<Character,Integer> map = new HashMap(){
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int length = s.length();
        int result = 0;
        int preValue = 0;
        //从右往左遍历字符串
        for(int i = length-1; i >= 0; i--){
            char key = s.charAt(i);
            int value = map.get(key);
            if(value >= preValue){
                result += value;
            } else {
                result -= value;
            }
            preValue = value;
        }
        return result;
    }

}

package string;

/**
 * @author Daffupman
 * @date 2018/11/12 17:13
 */
public class _08_LongestCommonPrefix {

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     */

    public static void main(String[] args){
        String[] str = {"flower","flow","flight"};
        String res = longestCommonPrefix(str);
        System.out.println(res);
    }

    /**
     * 思路：
     * 选定第一个字符串，遍历第一个字符串，逐个比较，如果其余的字符串
     * 与之相等，则存入结果字符串
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";

        //存放结果字符串
        String res = new String();
        //遍历第0个字符串
        for (int i = 0; i < strs[0].length(); i++) {
            //取出当前的字符
            char c = strs[0].charAt(i);
            //遍历之后的字符串
            for (int j = 1; j < strs.length; j++) {
                //当
                if(i>=strs[j].length() || strs[j].charAt(i)!=c){
                    return res;
                }
            }
            res += Character.toString(c);
        }
        return res;
    }

}

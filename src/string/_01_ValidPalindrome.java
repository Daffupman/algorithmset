package string;

/**
 * @author Daffupman
 * @date 2018/11/11 19:20
 */
public class _01_ValidPalindrome {

    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring
     * cases.
     * For example,
     * "A man, a plan, a canal: Panama" is a palindrome.
     * "race a car" is not a palindrome.
     * Note: Have you consider that the string might be empty? This is a good question to ask during an
     * interview.
     * For the purpose of this problem, we define empty string as valid palindrome.
     */

    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    /**
     * 思路：
     * 一边寻找，一边判断
     * 从左边找字母或数字，再从右边找字母或数字，只要不等就是false
     */
    public static boolean isPalindrome(String s){
        if(s == null)   return false;
        if(s == "")     return true;

        int left = 0,right = s.length()-1;

        while(left < right){
            //从左边开始寻找第一个字母
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left ++;
            }
            if(left >= right)   break;
            //从右边开始寻找第一个字母A man, a plan, a canal: Panama
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right --;
            }
            if(left >= right)   break;

            if(Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))){
                return false;
            }
        }

        return true;
    }

//    //fucked code, waste time
//    public static boolean isPalindrome(String s) {
//        if(s.isEmpty()){
//            return true;
//        }
//        //字母小写化，去重非字母元素
//        s = s.toLowerCase();
//        StringBuilder sb = new StringBuilder(s.length());
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if(ch >='a'&& ch <= 'z'){
//                sb.append(ch);
//            }
//        }
//        s = sb.toString();
//
//        for (int i = 0; i < s.length()/2+1; i++) {
//            if(s.charAt(i) != s.charAt(s.length()-1-i)){
//                return false;
//            }
//        }
//
//        return true;
//    }

}

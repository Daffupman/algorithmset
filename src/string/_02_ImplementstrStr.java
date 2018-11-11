package string;

/**
 * @author Daffupman
 * @date 2018/11/11 20:52
 */
public class _02_ImplementstrStr {

    /**
     * Implement strStr().
     * Return the index of the first occurrence of needle in haystack,
     * or -1 if needle is not part of haystack.
     */

    public static void main(String[] args){
        String haystack = "qdsfabba";
        String needle = "bba";
        System.out.println(strStr(haystack,needle));
    }

    public static int strStr(String haystack, String needle) {

        int len1 =  haystack.length(),
                len2 = needle.length();

        if(len1 < len2){
            return -1;
        } else if(len2 == 0){
            return 0;
        }

        int threshold = len1 -len2;
        for (int i = 0; i <= threshold; i++) {
            if(haystack.substring(i,i+len2).equals(needle)){
                return i;
            }
        }
        return -1;
    }

}

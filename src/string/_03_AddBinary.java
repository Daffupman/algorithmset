package string;

/**
 * @author Daffupman
 * @date 2018/11/12 15:54
 */
public class _03_AddBinary {

    /**
     * Given two binary strings, return their sum (also a binary string).
     */

    public static void main(String[] args){
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a,b));
    }

    /**
     * 思路：模仿十进制的加法，位数上相加超过2就取模，并记录到carry中
     */
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int alen = a.length()-1,
                blen = b.length()-1,
                carry = 0;
        while (alen >= 0 || blen > 0){
            int sum = carry;
            if(blen >= 0) sum += b.charAt(blen--) - '0';
            if(alen >= 0) sum += a.charAt(alen--) - '0';
            sb.append(sum % 2);
            carry = sum / 2 ;
        }
        if(carry != 0)  sb.append(carry);
        return sb.reverse().toString();
    }
    
}

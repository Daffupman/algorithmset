package string;

/**
 * @author Daffupman
 * @date 2018/11/13 20:34
 */
public class _11_RomanToInteger {

    public static void main(String[] args){
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};//千
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};//百
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};//十
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};//个
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

}

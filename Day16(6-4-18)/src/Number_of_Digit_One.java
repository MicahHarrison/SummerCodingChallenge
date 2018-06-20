
import static org.junit.Assert.*;

public class Number_of_Digit_One {

    /*Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

    Example:

    Input: 13
    Output: 6
    Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.*/
    public static void main(String[] args) {
        int test = 13;
        System.out.println(countDigitOne(test));
    }
    public static int countDigitOne(int n) {
        int result = 0;
        Integer i = 0;
        while (!(i > n)) {
            String istring = (i.toString());
            char[] ichars = istring.toCharArray();
            for (char cur: ichars) {
                if (cur == "1".charAt(0)) {
                    result++;
                }
            }
            i++;
        }
        return result;
    }

}

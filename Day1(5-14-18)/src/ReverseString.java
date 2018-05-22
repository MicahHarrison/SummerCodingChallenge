
import ucb.junit.textui;
import org.junit.Test;
import static org.junit.Assert.*;


public class ReverseString {
    //Write a function that takes a string as input and returns the string reversed.
    //
    //Example:
    //Given s = "hello", return "olleh".
    public static void main(String[] args) {
        assertEquals("olleh", reverseS("hello"));
    }

    public static String reverseS(String args) {
        int len = args.length();
        if (len < 1) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = len - 1; i > -1; i--) {
            result.append(args.charAt(i));
        }
        return result.toString();
    }
}

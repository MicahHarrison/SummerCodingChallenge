import java.util.HashMap;

import static org.junit.Assert.*;

public class Longest_Substring_with_At_Least_K_Repeating_Characters {
    /*Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

    Example 1:

    Input:
    s = "aaabb", k = 3

    Output:
            3

    The longest substring is "aaa", as 'a' is repeated 3 times.
            Example 2:

    Input:
    s = "ababbc", k = 2

    Output:
            5

    The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.*/
    public static void main(String[] args) {
        String test = "bbaaacdb";
        int k = 2;
        assertEquals(5, longestSubstring(test,k));
    }
    public static int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        StringBuilder result = new StringBuilder();
        StringBuilder currents = new StringBuilder();
        HashMap<Character,Integer> charcount = new HashMap<Character,Integer>();
        char[] input = s.toCharArray();
        for (char cur: input) {
            currents.append(cur);
            if (!charcount.containsKey(cur)) {
                charcount.put(cur, 1);
            } else {
                charcount.put(cur, charcount.get(cur) + 1);
            }
            boolean addtoresult = true;
            for (Integer i : charcount.values()) {
                if (i < k) {
                    addtoresult = false;
                    break;
                }
            }
            if (addtoresult) {
                result.append(currents);
                currents = new StringBuilder();
            }
        }
        return result.toString().length();
    }
}

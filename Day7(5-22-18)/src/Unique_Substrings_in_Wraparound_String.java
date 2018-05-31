import java.util.*;

import static org.junit.Assert.*;
public class Unique_Substrings_in_Wraparound_String {
    public static void main(String[] args) {
        String zab = "cac";
        assertEquals(2 , findSubstringInWraproundString(zab));
    }
    public static int findSubstringInWraproundString(String p) {
        Set<String> result = new HashSet<>();
        char[] chars = p.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i ++) {
            stringBuilder.append(chars[i]);
            result.add(stringBuilder.toString());
            for (int j = i + 1; j < chars.length; j++) {
                stringBuilder.append(chars[j]);
                result.add(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
        }
        return result.size();
    }
}

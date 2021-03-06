

import java.util.Arrays;


import static org.junit.Assert.*;

public class Find_the_Duplicate_Number {

    /*Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

    Example 1:

    Input: [1,3,4,2,2]
    Output: 2

    Example 2:

    Input: [3,1,3,4,2]
    Output: 3

    Note:
    You must not modify the array (assume the array is read only).
    You must use only constant, O(1) extra space.
    Your runtime complexity should be less than O(n2).
    There is only one duplicate number in the array, but it could be repeated more than once.*/

    public static void main(String[] args) {
        int[] test = {1,3,4,2,2};
        assertEquals(2,findDuplicate(test));
    }

    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int i = 1;
        while (nums[i - 1] != nums[i]) {
            i++;
        }
        return nums[i];
    }

}

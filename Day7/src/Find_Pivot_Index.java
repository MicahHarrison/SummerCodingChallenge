import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;

public class Find_Pivot_Index {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        assertEquals(3, pivotIndex(nums));
    }
    public static int pivotIndex(int[] nums) {
        int leftsum = 0;
        int rightsum = 0;
        if (nums.length < 3) {
            return -1;
        }
        for (int i = 0; i < nums.length ; i++)
        {
            leftsum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                rightsum += nums[i - 1];
            }
            leftsum -= nums[i];
            if (leftsum == rightsum) {
                return i;
            }
        }
        return -1;
    }
}

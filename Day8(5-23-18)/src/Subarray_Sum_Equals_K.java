import static org.junit.Assert.*;


public class Subarray_Sum_Equals_K {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        assertEquals(2, subarraySum(nums, 2));
    }
    public static int subarraySum(int[] nums, int k) {
        int result = 0;
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++){
            int sum = 0;
            sum += nums[i];
            if (sum == k) {
                result += 1;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    result += 1;
                }
            }
        }
        return result;
    }
}

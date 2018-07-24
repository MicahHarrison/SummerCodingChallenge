
import com.sun.tools.javac.code.Attribute;

import java.util.*;

import static org.junit.Assert.*;

public class Three_Sum {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        List<List<Integer>> exresult = new ArrayList<>();
        List<Integer> triplet1 = new ArrayList<>();
        triplet1.add(0);
        triplet1.add(0);
        triplet1.add(0);
        exresult.add(triplet1);
        List<List<Integer>> result = threeSum(nums);

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int tempsum = nums[i] + nums[j] + nums[k];
                if (tempsum == 0) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                    if (!result.contains(triplet)) {
                        result.add(triplet);
                    }
                    while (j < k && nums[j] == nums[j+1]) j++;
                    while (j < k && nums[k] == nums[k-1]) k--;
                    j++;
                    k--;
                } else if (tempsum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
public class MostProfitAssigningWork {
//    We have jobs: difficulty[i] is the difficulty of the ith job, and profit[i] is the profit of the ith job.
//
//    Now we have some workers. worker[i] is the ability of the ith worker, which means that this worker can only complete a job with difficulty at most worker[i].
//
//    Every worker can be assigned at most one job, but one job can be completed multiple times.
//
//    For example, if 3 people attempt the same job that pays $1, then the total profit will be $3.  If a worker cannot complete any job, his profit is $0.
//
//    What is the most profit we can make?
//
//    Example 1:
//
//    Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
//    Output: 100
//    Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get profit of [20,20,30,30] seperately.
//            Notes:
//
//            1 <= difficulty.length = profit.length <= 10000
//            1 <= worker.length <= 10000
//    difficulty[i], profit[i], worker[i]  are in range [1, 10^5]
    public static void main(String[] args) {
        int[] difficulty = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};
        assertEquals(100, maxProfitAssignment(difficulty, profit, worker));
    }
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int result = 0;
        int maxpay = 0;
        int paydif = 0;
        for (int j = 0; j < profit.length; j++) {
            if (profit[j] > maxpay) {
                maxpay = profit[j];
                paydif = difficulty[j];
            }
        }
        for (int skill : worker) {
            if (skill >= paydif) {
                result += maxpay;
            } else {
                int mostjob = 0;
                for (int i = 0; i < difficulty.length; i++) {
                    if (difficulty[i] <= skill && profit[i] > mostjob) {
                        mostjob = profit[i];
                    }
                }
                result += mostjob;
            }
        }
        return result;
    }
}

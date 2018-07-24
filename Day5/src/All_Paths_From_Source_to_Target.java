
import java.util.ArrayList;
import java.util.List;
import ucb.junit.textui;
import org.junit.Test;
import static org.junit.Assert.*;

public class All_Paths_From_Source_to_Target {
//    Example:
//    Input: [[1,2], [3], [3], []]
//    Output: [[0,1,3],[0,2,3]]
//    Explanation: The graph looks like this:
//            0--->1
//            |    |
//            v    v
//            2--->3
//    There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
    public static void main(String[] args) {
        int[][] input = {{1,2}, {3}, {3}, {}};
        int[][] output = {{0,1,3},{0,2,3}};
        assertArrayEquals(output, allPathsSourceTarget(input).toArray());



    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result= new ArrayList<>();

        int dest = graph.length - 1;
        if (graph.length == 0 || graph[0].length == 0) {
            return result;
        }
        return path(graph, 0, dest);
    }
    public static List<List<Integer>> path(int[][] input, int from, int to) {
        List<List<Integer>> result= new ArrayList<>();
        if (from == to) {
            List<Integer> done = new ArrayList<>();
            done.add(to);
            result.add(done);
            return result;
        }
        for (int i: input[from]) {
            List<List<Integer>> temp = path(input, i, to);
            for (List path: temp) {
                List<Integer> first = new ArrayList<>();
                first.add(from);
                if ((int)path.get(path.size() - 1) == to) {
                    first.addAll(path);
                    result.add(first);
                }
            }
        }
        return result;
    }
}

import com.sun.source.tree.Tree;

import java.util.*;

import static org.junit.Assert.*;

public class Binary_Tree_Zigzag_Level_Order_Traversal {
//    Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
//    For example:
//    Given binary tree [3,9,20,null,null,15,7],
//             3
//            / \
//           9  20
//             /  \
//            15   7
//            return its zigzag level order traversal as:
//            [
//            [3],
//            [20,9],
//            [15,7]
//            ]
public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    TreeNode left = new TreeNode(9);
    TreeNode right = new TreeNode(20);
    TreeNode rightleft = new TreeNode(15);
    TreeNode rightright = new TreeNode(7);
    root.left = left;
    root.right = right;
    right.left = rightleft;
    right.right = rightright;
    System.out.println(Arrays.toString(zigzagLevelOrder(root).toArray()));


}
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> currque = new LinkedList<TreeNode>();
        Queue<TreeNode> otherque = new LinkedList<TreeNode>();
        boolean reverse = false;
        currque.add(root);
        ArrayList<Integer> curlevel = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        while (true) {
            while (!currque.isEmpty()) {
                TreeNode curr = currque.poll();
                curlevel.add(curr.val);
                if (curr.left != null) {
                    otherque.add(curr.left);
                }
                if (curr.right != null) {
                    otherque.add(curr.right);
                }
            }
            if (reverse) {
                Collections.reverse(curlevel);
            }
            result.add(curlevel);
            curlevel = new ArrayList<Integer>();
            reverse = !reverse;
            Queue<TreeNode> temp = currque;
            currque = otherque;
            otherque = temp;
            if (currque.isEmpty()) {
                break;
            }
        }
        return result;
    }
    public static int TreeLevel(TreeNode root) {
        return TreeLevelHelper(root, 0);
    }
    public static int TreeLevelHelper(TreeNode root, int level) {
        if (root == null) {
            return level - 1;
        }
        return Math.max(TreeLevelHelper(root.left, level + 1), (TreeLevelHelper(root.right, level + 1)));
    }
}


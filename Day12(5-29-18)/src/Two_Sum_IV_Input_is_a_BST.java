
import com.sun.source.tree.Tree;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Two_Sum_IV_Input_is_a_BST {

    /*Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

            Example 1:
    Input:
            5
            / \
            3   6
            / \   \
            2   4   7

    Target = 9

    Output: True*/

    public boolean findTarget(TreeNode root, int k) {
        if (root == null || (root.left == null && root.right == null)) {
            return false;
        }
        ArrayList<Integer> remainders = new ArrayList<>();
        return findTargetRemain(root, remainders, k);
    }

    public boolean findTargetRemain(TreeNode root, ArrayList remainders, int k) {
        if (root == null) {
            return false;
        }
        if (remainders.contains(root.val)) {
            return true;
        } else {
            int remainder = k - root.val;
            remainders.add(remainder);
            return findTargetRemain(root.left, remainders, k) || findTargetRemain(root.right, remainders, k);
        }
    }

}

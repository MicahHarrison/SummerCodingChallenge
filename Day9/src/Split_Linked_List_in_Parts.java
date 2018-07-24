
import com.sun.tools.javac.util.List;

import static org.junit.Assert.*;
public class Split_Linked_List_in_Parts {
    /*Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".

    The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.

    The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.

    Return a List of ListNode's representing the linked list parts that are formed.

    Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
    Example 1:
    Input:
    root = [1, 2, 3], k = 5
    Output: [[1],[2],[3],[],[]]
    Explanation:
    The input and each element of the output are ListNodes, not arrays.
    For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
    The first element output[0] has output[0].val = 1, output[0].next = null.
    The last element output[4] is null, but it's string representation as a ListNode is [].*/
    public static void main(String[] args) {
        ListNode test1 = new ListNode(1);
        ListNode test2 = new ListNode(2);
        ListNode test3 = new ListNode(3);
        ListNode test4 = new ListNode(4);
        ListNode test5 = new ListNode(5);
        ListNode test6 = new ListNode(6);
        ListNode test7 = new ListNode(7);
        ListNode test8 = new ListNode(8);
        ListNode test9 = new ListNode(9);
        ListNode test10 = new ListNode(10);
        test1.next = test2;
        test2.next = test3;
        test3.next = test4;
        test4.next = test5;
        test5.next = test6;
        test6.next = test7;
        test7.next = test8;
        test8.next = test9;
        test9.next = test10;

        ListNode[] expresult = new ListNode[3];
        ListNode extest1 = new ListNode(1);
        ListNode extest2 = new ListNode(2);
        ListNode extest3 = new ListNode(3);
        ListNode extest4 = new ListNode(4);
        ListNode extest5 = new ListNode(5);
        ListNode extest6 = new ListNode(6);
        ListNode extest7 = new ListNode(7);
        ListNode extest8 = new ListNode(8);
        ListNode extest9 = new ListNode(9);
        ListNode extest10 = new ListNode(10);
        extest1.next = extest2;
        extest2.next = extest3;
        extest3.next = extest4;
        extest5.next = extest6;
        extest6.next = extest7;
        extest8.next = extest9;
        extest9.next = extest10;
        expresult[0] = extest1;
        expresult[1] = extest5;
        expresult[2] = extest8 ;
        /*test4.next = test5;
        test7.next = test8;*/

        ListNode[] result = splitListToParts(test1, 3);
        assertTrue(ListNodeEquals(expresult,result));
    }
    public static boolean ListNodeEquals(ListNode[] A, ListNode[] B) {
        if (A.length != B.length) {
            return false;
        }
        for (int i = 0; i < A.length; i++) {
            ListNode currA = A[i];
            ListNode currB = B[i];
            while (currA != null && currB != null) {
                if (currA.val != currB.val) {
                    return false;
                } else {
                    currA = currA.next;
                    currB = currB.next;
                }
                if (!(currA == null && currB == null)) {
                    return false;
                }
            }

        }
        return true;
    }
    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        if (root == null) {
            return result;
        }
        int size = 0;
        ListNode curr = root;
        while (curr != null) {
            curr = curr.next;
            size += 1;
        }
        int each = size / k;
        int remainder = size % k;
        for (int i = 0; i < k; i++) {
            ListNode part = null;
            curr = null;
            for (int j = 0; j < each; j++) {
                if (j == 0 && root != null) {
                    curr = new ListNode(root.val);
                    part = curr;
                    root = root.next;
                } else if (root != null) {
                    curr.next = new ListNode(root.val);
                    curr = curr.next;
                    root = root.next;
                }
            }
            if (remainder != 0 && root != null) {
                if (curr == null) {
                    part = new ListNode(root.val);
                } else {
                    curr.next = new ListNode(root.val);
                }
                root = root.next;
                remainder -= 1;
            }
            result[i] = part;
        }
        return result;
    }
}

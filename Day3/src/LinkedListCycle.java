public class LinkedListCycle {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) {
                return null;
            }
            ListNode turtle = head;
            ListNode rabbit = head;
            boolean isCycle = false;
            while (turtle != null & rabbit != null) {
                turtle = turtle.next;
                if (rabbit.next == null) {
                    return null;
                }
                rabbit = rabbit.next.next;
                if (rabbit == turtle) {
                    isCycle = true;
                    break;
                }
            }
            turtle = head;
            if (!isCycle) {
                return null;
            }
            while (turtle != rabbit) {
                turtle = turtle.next;
                rabbit = rabbit.next;
            }
            return turtle;
        }
    }
}

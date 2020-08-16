package 题库;

/**
 * @Describe TODO
 */
public class _206_反转链表 {
    public ListNode  reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null,cur = head,tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = tmp;
        }
        return newHead;
    }

}

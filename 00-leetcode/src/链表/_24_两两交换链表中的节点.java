package 链表;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @Describe 24. 两两交换链表中的节点
 */
public class _24_两两交换链表中的节点 {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode thead = sentinel;
        while (head != null && head.next != null) {
            ListNode a = head;
            ListNode b = head.next;

            thead.next = b;
            a.next = b.next;
            b.next = a;

            thead = a;
            head = a.next;
        }
        return sentinel.next;
    }
}

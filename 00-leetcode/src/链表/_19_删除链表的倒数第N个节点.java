package 链表;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @Describe 19. 删除链表的倒数第N个节点
 */
public class _19_删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        while (p != null) {
            if (n < 0) {
                q = q.next;
            }
            n--;
            p = p.next;
        }
        if (n == 0) {
            return head.next;
        }
        q.next = q.next.next;
        return head;
    }
}

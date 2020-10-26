package 链表;

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @Describe 剑指 Offer 22. 链表中倒数第k个节点
 */
public class _剑指_Offer_22_链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || head.next==null) return head;
        ListNode fast = head;
        ListNode newHead = head;
        while (fast != null && (k--)>0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            newHead = newHead.next;
        }
        return newHead;
    }
}

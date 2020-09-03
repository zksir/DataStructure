package 链表;

/**
 * https://leetcode-cn.com/problems/insertion-sort-list/
 *
 * @Describe 147. 对链表进行插入排序
 */
public class _147_对链表进行插入排序 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = head, cur = head.next;
        while (cur != null) {
            if (cur.val > pre.val) {
                pre = pre.next;
                cur = cur.next;
            } else {
                ListNode p = dummy;//重新遍历链表
                while (p.next != cur && p.next.val < cur.val) {//遍历到cur节点对比
                    p = p.next;
                }
                pre.next = cur.next;
                cur.next = p.next;
                p.next = cur;
                cur = pre.next;
            }
        }
        return dummy.next;
    }
}

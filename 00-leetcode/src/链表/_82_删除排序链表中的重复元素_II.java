package 链表;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @Describe 82. 删除排序链表中的重复元素 II
 */
public class _82_删除排序链表中的重复元素_II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newhead = new ListNode(-1);
        ListNode tmp = newhead;

        while (head != null && head.next != null) {
            if (head.val == head.next.val) { //遇到相同的元素，整段删除
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                head = head.next;
            } else {
                tmp.next = head;
                tmp = tmp.next;
                head = head.next;

            }
        }
        tmp.next = head;
        return newhead.next;
    }
}

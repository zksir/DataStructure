package 链表;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * @Describe 234. 回文链表
 */
public class _234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next==null) return true;
        ListNode slow = head;
        ListNode fast = head;
        // 找到中间节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转后半段链表
//        ListNode cur = slow;
        ListNode revNode = null;
        while (slow != null) {
            ListNode tmp = slow.next;
            slow.next = revNode;
            revNode = slow;
            slow = tmp;
        }
        //前半段链表与后半段链表比较
        // 前半段链表的值和后半段的链表值依次进行对比，如果有对不上的立刻返回false
        while (revNode != null) {
            if (revNode.val != head.val) {
                return false;
            }
            revNode = revNode.next;
            head = head.next;
        }
        return true;
    }
}

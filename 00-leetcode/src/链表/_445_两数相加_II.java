package 链表;

/**
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 * @Describe 445. 两数相加 II
 */
public class _445_两数相加_II {
    /**
     * 思路：
     * 先反转链表
     * 然后计算两个链表的和
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node1 = reverse(l1);
        ListNode node2 = reverse(l2);
        int carry = 0;
        ListNode newHead = new ListNode(0);
        ListNode curr = newHead;
        while (node1 != null || node2 != null){
            int x = node1 != null ? node1.val : 0;
            int y = node2 != null ? node2.val : 0;
            int num = (x + y + carry) % 10;
            ListNode node = new ListNode(num);
            curr.next = node;
            curr = node;
            carry = (x + y + carry) / 10;
            if (node1 != null) node1 = node1.next;
            if (node2 != null) node2 = node2.next;
        }

        if (carry > 0) curr.next = new ListNode(carry);
        ListNode res = reverse(newHead.next);
        return res;
    }
    public ListNode reverse(ListNode head){
        if (head == null) return null;
        ListNode pre = null;
        while (head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

package 链表;

/**
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 * @Describe 1290. 二进制链表转整数
 */
public class _1290_二进制链表转整数 {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = (res << 1) + head.val;
            head = head.next;
        }
        return res;
    }
}

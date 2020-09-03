package 链表;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * @Describe 剑指 Offer 06. 从尾到头打印链表
 */
public class _剑指_Offer_06_从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        int[] res = new int[size];
        cur = head;
        while (size > 0) {
            size--;
            res[size] = cur.val;
            cur = cur.next;
        }
        return res;
    }
}

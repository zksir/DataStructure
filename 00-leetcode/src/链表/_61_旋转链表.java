package 链表;

/**
 * https://leetcode-cn.com/problems/rotate-list/
 *
 * @Describe 61. 旋转链表
 */
public class _61_旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
//        if (head == null || head.next == null) return head;
//        ListNode cur = head;
//        int len = 0;
//        //求链表长度
//        while (cur.next != null) {
//            cur = cur.next;
//            ++len;
//        }
//        k = k % len; // 去重
//        cur.next = head;//链表首尾相连成环
//        while (k < len) {// 找到打断位置
//            ++k;
//            cur = cur.next;
//        }
//        ListNode tmp = cur;
//        cur = cur.next;
//        tmp.next = null;
//
//        return head;

        if (head == null || head.next == null) {
            return head;
        }

        ListNode q=head,p = head;
        int len = 1;

        // 求出链表长度
        while (p.next != null) {
            p = p.next;
            len++;
        }

        p.next = head;   // 链表首尾相连成环
        p = head;
        k = len - (k % len);
        while (k > 0 && p != null) {
            q = p;              // 新尾节点
            p = p.next;    // 新头结点
            k--;
        }

        q.next = null;
        return p;
    }
}

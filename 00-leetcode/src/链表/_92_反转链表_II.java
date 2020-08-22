package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/
 * @Describe 92. 反转链表 II
 */
public class _92_反转链表_II {
    /**
     * 思路：
     * 第一步：找到待反转节点的前一个节点。
     * 第二步：反转m到n这部分。
     * 第三步：将反转的起点的next指向反转的后面一部分。
     * 第四步：将第一步找到的节点指向反转以后的头节点。
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
//        ListNode newHead = new ListNode(0);
//        newHead.next = head;
//        ListNode cur = newHead;//用来遍历链表m之前，m之后就要反转
//        //找到需要反转的那一段的上一个节点。
//        for (int i = 1; i < m; i++) {//遍历到m
//            cur = cur.next;//遍历链表
//        }
//
//        ListNode nextHead = cur.next;//需要反转的这段的起点
//        ListNode next = null;
//        ListNode pre = null;
//
//        for (int i = m; i <= n; i++) {//m到n区间的，反转链表
//            next = nextHead.next;
//            nextHead.next = pre;
//            pre = nextHead;
//            nextHead = next;
//        }
//        //将反转的起点的next指向next。
//        cur.next.next = next;
//        //需要反转的那一段的上一个节点的next节点指向反转后链表的头结点
//        cur.next = pre;
//        return newHead.next;

        ListNode newHead = new ListNode(-1);
        ListNode cur = head;
        newHead.next = head;
        int l = 0;
        while (l < m) {
            cur = cur.next;
            l++;
        }
        ListNode revNode = cur.next;
        ListNode tmp = null;
        ListNode next = null;
//        while (l < n-1){
//            tmp = revNode.next;
//            revNode.next = next;
//            next = revNode;
//            revNode = tmp;
//        }
        for (int i = m; i <= n; i++) {//m到n区间的，反转链表
            tmp = revNode.next;
            revNode.next = next;
            next = revNode;
            revNode = tmp;
        }
        cur.next.next = tmp;
        cur.next = next;
        return newHead.next;
    }

}

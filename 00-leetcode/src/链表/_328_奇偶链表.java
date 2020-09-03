package 链表;

/**
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * @Describe 328. 奇偶链表
 */
public class _328_奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while (odd.next!=null && even.next!=null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

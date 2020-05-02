package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author kaizhang
 *
 */
public class _206_反转链表 {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	/**
	 * 递归实现反转
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null; 
        return newHead;
    }
	
	/**
	 * 迭代实现反转
	 * @param head
	 * @return
	 */
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode newHead = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
        return newHead;
    }
}

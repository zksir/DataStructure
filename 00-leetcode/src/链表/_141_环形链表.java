package 链表;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * @author kaizhang
 *
 */
public class _141_环形链表 {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/**
	 * 思路：
	 * 快慢指针，while循环判断fast即可，如果fast或者fast.next先为空，则代表无环
	 * @param head
	 * @return
	 */
    public boolean hasCycle(ListNode head) {
    	if (head == null || head.next == null) return false;
    	
    	ListNode slow = head;
    	ListNode fast = head.next;
    	while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) return true;
		}
        return false;
    }
}

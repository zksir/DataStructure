package 链表;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @author kaizhang
 *
 */
public class _203_移除链表元素 {
	
    public ListNode removeElements(ListNode head, int val) {
    	// 哨兵+快慢指针法
        if (head == null) return head;
    	ListNode dummyHead = new ListNode(0);
    	ListNode pre = dummyHead;
    	ListNode cur = head;
    	while (cur != null) {
			if (cur.val == val) {
				pre.next = cur.next;
			} else {
                pre = cur;
				
			}
			cur = cur.next;
    	}

    	return dummyHead.next;
    }

	/**
	 * 直接遍历法
	 * 思路：
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements1(ListNode head, int val) {
		if (head == null) return null;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = dummy;
		while (cur.next != null) {
			if (cur.next.val == val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return dummy.next;
	}
}

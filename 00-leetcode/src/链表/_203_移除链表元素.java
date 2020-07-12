package 链表;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @author kaizhang
 *
 */
public class _203_移除链表元素 {
	
    public ListNode removeElements(ListNode head, int val) {
    	// 直接遍历法
//    	if (head == null) return head;
//    	ListNode dummyHead = new ListNode(0);
//    	dummyHead.next = head;
//        ListNode cur = dummyHead;
//    	while (cur.next != null) {
//    		if (cur.next.val == val) {
//    			cur.next = cur.next.next;
//			} else {
//				cur = cur.next;
//			}
//		}
//    	return dummyHead.next;
    	
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
}

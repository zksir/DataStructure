package 链表;
/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author kaizhang
 *
 */
public class _2_两数相加 {
	/**
	 * 思路：
	 * 	1.建立一个新链表，用来记录两个链表的每一位的和
	 * 	2.建立一个进位的变量，用来记录是否进位，进位是1，不进位是0
	 * 	3.两个链表同时遍历相加
	 *  4.返回新链表
	 * @param l1
	 * @param l2
	 * @return
	 */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode dummyHead = new ListNode(-1);
    	ListNode cur = dummyHead;//用来遍历链表
    	int carried = 0;
    	while (l1 != null || l2 != null) {//两个链表同时遍历相加
			int tmpL1 = (l1 != null) ? l1.val : 0;
			int tmpL2 = (l2 != null) ? l2.val : 0;
			int sum = tmpL1 + tmpL2 + carried;
			cur.next = new ListNode(sum % 10);
			carried = (int)(sum / 10);
			cur = cur.next;
			
			l1 = (l1 != null) ? l1.next : null;
			l2 = (l2 != null) ? l2.next : null;
		}
    	return dummyHead.next;
    }
}

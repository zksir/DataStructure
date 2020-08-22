package 链表;

import javax.sound.midi.Soundbank;

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
	 * 思路：要返回新节点，指向链表最后一位
	 * 	1.定义newHead,先讲head.next指向newHead(中间要拿tmp保存head.next)
	 * 	2.将newHead指向head
	 * 	3.将head指向head.next.next
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

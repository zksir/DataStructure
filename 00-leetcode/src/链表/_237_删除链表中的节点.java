package 链表;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @author kaizhang
 *
 */
public class _237_删除链表中的节点 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	/**
	 * 思路：
	 * 	1.当前节点的值等于下一个节点的值
	 *  2.当前节点的下一个元素等于下一个节点的下一个元素
	 * @param node
	 */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}

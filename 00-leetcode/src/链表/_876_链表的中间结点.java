package 链表;

public class _876_链表的中间结点 {
    public ListNode middleNode(ListNode head) {
    	if (head == null || head.next == null) return head;
    	ListNode cur = head;
    	int count = 0;
    	while (cur != null) {
			++count;
			cur = cur.next;
		}
    	int middle = (int)Math.ceil(count/2);
    	int end = 0;
    	ListNode middleNode = head;
    	while (middleNode != null) {
    		if (end < middle) {
    			end++;
    			middleNode = middleNode.next;
			} else {
				return middleNode;
			}
		}
    	return middleNode;
    }
}

package 链表;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @Describe 25. K 个一组翻转链表
 */
public class _25_K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int count = 0;
        ListNode cur = head;
        while(cur != null && count != k){
            cur = cur.next;
            count++;
        }
        if(count == k){
            cur = reverseKGroup(cur,k);//cur 是上一次反转后的头结点
            while(count >0){//基本的反转语句要掌握
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
                count--;
            }
            head = cur;
        }
        return head;
    }
}

package 链表;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @Describe 142. 环形链表 II
 */
public class _142_环形链表_II {
    /**
     * 思路
     * 为快慢指针首次相遇点，入环前距离为【D】，慢指针入环后走过的距离为【S1】，环剩下距离为【S2】
     * 1.慢指针 S = D + S1
     * 2.快指针 F = D + n(S1 + S2) + S1 其中n>=1,快指针起码走了一圈以上才可能相遇
     * 3.又因为 F = 2S 慢指针走一步，快指针走两步
     * 4.代入1，2 可得 2(D + S1) = D + n(S1 + S2) + S1
     * 各种移项可得 D = (n-1)S1 + nS2 = (n-1)(S1 + S2) + S2
     * 5.其中 n为快指针绕的圈数
     * n=1 D = S2
     * n=2 D = 一圈 + S2
     * n=3 D = 两圈 + S2
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        //获取首次相遇时候，slow的位置
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        //如果快指针走到尽头，没环
        if(fast == null || fast.next == null) return null;
        //快指针重新出发，相遇位置就是入口位置
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}

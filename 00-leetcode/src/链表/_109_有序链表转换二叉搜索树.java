package 链表;

/**
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * @Describe 109. 有序链表转换二叉搜索树
 */
public class _109_有序链表转换二叉搜索树 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode pre = head;
        ListNode slow = pre.next;
        ListNode fast = slow.next;
        //找到链表的中点
        while(fast!=null && fast.next!=null){
            pre = pre.next;
            slow = pre.next;
            fast = fast.next.next;
        }
        //将中点左边的链表分开
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

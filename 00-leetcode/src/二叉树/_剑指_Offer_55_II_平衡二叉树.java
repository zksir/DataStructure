package 二叉树;

/**
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 *
 * @Describe 剑指 Offer 55 - II. 平衡二叉树
 */
public class _剑指_Offer_55_II_平衡二叉树 {
    /**
     * 思路：后序遍历
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        int a = postorderTraversal(root);
        if (a == -1) return false;
        return true;
    }

    public int postorderTraversal(TreeNode root) {
        if (root == null) return 0;
        int l = postorderTraversal(root.left);
        if (l == -1) return -1;//如果左子树不平衡，直接跳出，不用判断右子树，直接返回-1
        int r = postorderTraversal(root.right);
        if (r == -1) return -1;
        return Math.abs(l - r) < 2 ? Math.max(l, r) + 1 : -1;//左子树和右子树的高度差大于1，就标记为-1
    }
}

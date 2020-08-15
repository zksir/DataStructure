package 二叉树;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * @Describe 110. 平衡二叉树
 */
public class _110_平衡二叉树 {
    /**
     * 思路：前序遍历，从底至顶（提前阻断）
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (getHeight(root) == -1) return false;
        return true;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1) return -1;
        if (Math.abs(rightHeight - leftHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

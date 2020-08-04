package 二叉树;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 * @Describe 99. 恢复二叉搜索树
 */
public class _99_恢复二叉搜索树 {
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        recoverTree(root.left);
        // 逻辑

        recoverTree(root.right);
    }
}

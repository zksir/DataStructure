package 二叉树;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * @Describe 101. 对称二叉树
 */
public class _101_对称二叉树 {
    /**
     * 递归:
     * 左子树 2 的左孩子 == 右子树 2 的右孩子
     * 左子树 2 的右孩子 == 右子树 2 的左孩子
     *
     * left 和 right 不等，或者 left 和 right 都为空
     * 递归的比较 left.left 和 right.right，递归比较 left.right 和 right.left
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }
    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true; // 两个节点都为空时，表示遍历结束
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;

        //再递归的比较 左节点的左孩子 和 右节点的右孩子
        //以及比较  左节点的右孩子 和 右节点的左孩子
        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }
}


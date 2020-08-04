package 二叉树;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * @Describe 剑指 Offer 33. 二叉搜索树的后序遍历序列
 */
public class _剑指_Offer_33_二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder) {

        return false;
    }
    public void postorderTraversal(TreeNode node) {
        if (node == null) return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
    }
}

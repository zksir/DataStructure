package 二叉树;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-in-and-post-traversal/
 *
 * @Describe 106. 从中序与后序遍历序列构造二叉树
 */
public class _106_从中序与后序遍历序列构造二叉树 {
    /**
     * 思路：
     * 中序遍历顺序：左、根、右
     * 后序遍历顺序：左、右、根
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        return helper(inorder, postorder);
    }

    private TreeNode helper(int[] in, int[] post) {
        if (in.length == 0 || post.length == 0) return null;
        TreeNode root = new TreeNode(post[post.length - 1]);//根节点
        //中序数组中找后序根节点的坐标
        for (int i = 0; i < in.length - 1; i++) {
            if (in[i] == post[post.length - 1]) {
                int[] inLeft = Arrays.copyOfRange(in, 0, i);
                int[] inRight = Arrays.copyOfRange(in, i + 1, in.length);
                int[] postLeft = Arrays.copyOfRange(post, 0, i);
                int[] postRight = Arrays.copyOfRange(post, i, post.length - 1);
                //递归处理中序数组左边，后序数组左边
                root.left = helper(inLeft,postLeft);
                //递归处理中序数组右边，后序数组右边
                root.right = helper(inRight,postRight);
            }
        }
        return root;
    }
}

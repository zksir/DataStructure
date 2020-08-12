package 二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * @Describe 114. 二叉树展开为链表
 */
public class _114_二叉树展开为链表 {
    /**
     * 思路：前序遍历
     * 这道题非常有意思，重点是理解原地算法：
     *      原地算法是指不仅包含O(1)的算法，还
     *      包括直接在原来的节点上改变指向，空间复杂度并没有要求的算法。
     * 前序遍历结束之后更新每个节点的左右子节点的信息，将二叉树展开为单链表。
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    private void preorderTraversal(TreeNode node, List<TreeNode> list) {
        if (node == null) return;
        // 做操作
        list.add(node);
        preorderTraversal(node.left, list);
        preorderTraversal(node.right, list);
    }
}

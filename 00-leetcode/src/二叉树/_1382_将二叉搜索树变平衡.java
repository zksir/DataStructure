package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/balance-a-binary-search-tree/
 *
 * @Describe 1382. 将二叉搜索树变平衡
 */
public class _1382_将二叉搜索树变平衡 {
    /**
     * 思路：
     * 1.利用中序遍历构建有序链表
     * 2.利用有序链表中间值，递归构建新树即是平衡树
     *
     * @param root
     * @return
     */
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);//有序数组
        return bulidBST(list, 0, list.size()-1);
    }

    //中序遍历
    public void inOrder(TreeNode node, List<Integer> list) {
        if (node != null) {
            inOrder(node.left, list);
            list.add(node.val);
            inOrder(node.right, list);
        }
    }

    //构建平衡树
    public TreeNode bulidBST(List<Integer> list, int start, int end) {
        if (start > end) return null;
        //中间节点
        int mid = start + (end - start >> 1);
        TreeNode root = new TreeNode(list.get(mid));
        root.left = bulidBST(list,start,mid-1);
        root.right = bulidBST(list,mid+1,end);
        return root;
    }
}


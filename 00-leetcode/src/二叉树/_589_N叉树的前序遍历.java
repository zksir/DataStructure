package 二叉树;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * @Describe 589. N叉树的前序遍历
 */
public class _589_N叉树的前序遍历 {
    List<Integer> list = new LinkedList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) return list;
        list.add(root.val);
//        for (Node child:root.children) {
//            preorder(child);
//        }
        root.children.forEach((child)->preorder(child));
        return list;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
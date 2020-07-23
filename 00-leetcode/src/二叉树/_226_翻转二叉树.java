package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * @author Scentea
 */
public class _226_翻转二叉树 {
	//前序
//    public TreeNode invertTree(TreeNode root) {
//    	if (root == null) return root;
//    	
//    	TreeNode tmp = root.left;
//    	root.left = root.right;
//    	root.right = tmp;
//    	
//    	invertTree(root.left);
//    	invertTree(root.right);
//    	return root;
//    }
	//中序
//    public TreeNode invertTree(TreeNode root) {
//    	if (root == null) return root;
//    	
//    	invertTree(root.left);
//    	
//    	TreeNode tmp = root.left;
//    	root.left = root.right;
//    	root.right = tmp;
//    	
//    	invertTree(root.left);
//    	return root;
//    }
	
	//后序
//	public TreeNode invertTree(TreeNode root) {
//		if (root == null) return root;
//		
//		invertTree(root.left);
//		invertTree(root.right);
//		
//		TreeNode tmp = root.left;
//		root.left = root.right;
//		root.right = tmp;
//
//		return root;
//	}	
	
	//层序遍历
    public TreeNode invertTree(TreeNode root) {
    	if (root == null) return root;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
    	return root;
    }
}

package com.zksir.tree;

import java.util.LinkedList;
import java.util.Queue;
import com.zksir.printer.BinaryTreeInfo;
import com.zksir.tree.BinaryTree.Node;

@SuppressWarnings("unchecked")
public class BinaryTree<E> implements BinaryTreeInfo {
	protected int size;
	protected Node<E> root;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		root = null;
		size = 0;
	}
	
	protected static class Node<E> {
		E element;
		Node<E> left;
		Node<E> right;
		Node<E> parent;
		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}
		
		public boolean isLeaf() {
			return left == null && right == null;
		}
		
		public boolean hasTwoChildren() {
			return left != null && right != null;
		}
		
		public boolean isLeftChild() {
			return parent != null && this == parent.left;
		}
		
		public boolean isRightChild() {
			return parent != null && this == parent.right;
		}
		
		public Node<E> sibling() {
			if (isLeftChild()) {
				return parent.right;
			}
			
			if (isRightChild()) {
				return parent.left;
			}
			
			return null;
		}
	}
		
	protected Node<E> createNode(E element, Node<E> parent) {
		return new Node<>(element, parent);
	}
	
	/**
	 * 前序遍历-递归方式
	 */
	public void preOrder(Visitor<E> visitor) {
		if (visitor == null) return;
		preOrder(root,visitor);
	}
	
	private void preOrder(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor.stop) return;
		visitor.stop = visitor.visit(node.element);
		preOrder(node.left, visitor);
		preOrder(node.right, visitor);
	}
	
	/**
	 * 中序遍历-递归方式
	 */
	public void inOrder(Visitor<E> visitor) {
		if (visitor == null) return;
		inOrder(root,visitor);
	}
	
	private void inOrder(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor.stop) return; // visitor.stop停止递归调用
		
		inOrder(node.left, visitor); // 这里面有可能visitor.stop是true,所以下面的if不能够省略 
		if (visitor.stop) return; // 打印层面
		visitor.stop = visitor.visit(node.element);
		inOrder(node.right, visitor);
	}
	
	/**
	 * 后序遍历-递归方式
	 */
	public void postOrder(Visitor<E> visitor) {
		if (visitor == null) return;
		postOrder(root,visitor);
	}
	
	private void postOrder(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor.stop) return; // visitor.stop停止递归调用
		
		postOrder(node.left, visitor);
		postOrder(node.right, visitor);// 这里面有可能visitor.stop是true,所以下面的if不能够省略
		
		if (visitor.stop) return;// 打印层面
		visitor.stop = visitor.visit(node.element);
	}
	
	/**
	 * 层序遍历
	 */

	public void levelOrder(Visitor<E> visitor) {
		if (root == null || visitor == null) return;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			
			if(visitor.visit(node.element)) return;
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}
	
	public static abstract class Visitor<E> {
		boolean stop;
		/**
		 * @return 如果返回true，就代表停止遍历
		 */
		public abstract boolean visit(E element);
	}

	@Override
	public Object root() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public Object left(Object node) {
		// TODO Auto-generated method stub
		return ((Node<E>)node).left;
	}

	@Override
	public Object right(Object node) {
		// TODO Auto-generated method stub
		return ((Node<E>)node).right;
	}

	@Override
	public Object string(Object node) {
		// TODO Auto-generated method stub
//		Node<E> myNode = (Node<E>)node;
//		String parentString = "null";
//		
//		if (myNode.parent != null) {
//			parentString = myNode.parent.element.toString();
//		}
//		return myNode.element + "_p(" + parentString + ")";
		return node;
	}
	

	protected Node<E> predecessor(Node<E> node) {
		if (node == null) return null;
		
		// 前驱节点在左子树中（left.right.right...）
		Node<E> pNode = node.left;
		if (pNode != null) {
			while (pNode.right != null) {
				pNode = pNode.right;
			}
			return pNode;
		}
		
		// 从父节点、祖父节点中寻找前驱节点
		while (node.parent != null && node == node.parent.left) {
			node = node.parent;
		}
		
		// node.parent == null
		// node == node.parent.left
		
		return node.parent;
	}
	
	protected Node<E> successor(Node<E> node) {
		if (node == null) return null;
		
		// 后驱节点在右子树中（right.left.left...）
		Node<E> pNode = node.right;
		if (pNode != null) {
			while (pNode.left != null) {
				pNode = pNode.left;
			}
			return pNode;
		}
		
		// 从父节点、祖父节点中寻找后驱节点
		while (node.parent != null && node == node.parent.right) {
			node = node.parent;
		}
		
		// node.parent == null
		// node == node.parent.right
		
		return node.parent;
	}
	
	/**
	 * 获取树的高度
	 * 迭代实现
	 * 层序遍历
	 * @return
	 */
	public int height() {
		if (root == null) return 0;
		
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		// 树的高度
		int height = 0;
		// 存储着每一层元素的数量
		int levelSize = 1;
		
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			levelSize--;
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
			
			if (levelSize == 0) {// 意味着即将要访问
				levelSize = queue.size();// 每当有一层最后一个元素遍历完，队列里的size就是下一层的元素个数。
				height++;
			}
		}
		return height;
	}
	
	/**
	 * 获取树的高度
	 * 递归实现
	 * 根据左右子树最大的高度进行递归
	 * @return
	 */
	public int height2() {
		return height(root);
	}
	
	private int height(Node<E> node) {
		if (node == null) return 0;
		
		return 1 + Math.max(height(node.left), height(node.right));
	}
	
	/**
	 * 思路：如果树不为空，开始层序遍历二叉树（用队列）
	 * 如果node.left!=null && node.right!=null,将node.left、node.right按顺序入队
	 * 如果node.left==null && node.right!=null,返回false
	 * 如果node.left!=null && node.right==null 或者 node.left==null && node.right == null
	 * 	那么后面遍历的节点应该都为叶子节点，才是完全二叉树
	 *  否则返回false
	 *  遍历结束，返回true
	 * @return
	 */
	public boolean isComplete() {
		if (root == null) return false;
		
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		boolean leaf = false;
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (leaf && !node.isLeaf()) return false;
			
			if (node.left != null) {
				queue.offer(node.left);
			} else if (node.right != null) {
				// node.left == null && node.right != null
				return false;
			}
			
			if (node.right != null) {
				queue.offer(node.right);
			} else {
				// node.left == null && node.right == null
				
				// node.left != null && node.right == null
				leaf = true;
			}
		}
		return true;
	}
	
	
}

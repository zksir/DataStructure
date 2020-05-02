package com.zksir;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import javax.xml.soap.Node;

import com.zksir.BinarySearchTree.Visitor;
import com.zksir.printer.BinaryTreeInfo;

@SuppressWarnings("unchecked")
public class BinarySearchTree<E> implements BinaryTreeInfo {
	private int size;
	private Node<E> root;
	private Comparator<E> comparator;
	
	public BinarySearchTree() {
		this(null);
	}
	
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		
	}
	
	public void add(E element) {
		elementNotNullCheck(element);
		
		// 添加第一个节点
		if (root == null) {
			root = new Node<>(element, null);
			size++;
			return;
		}
		
		// 添加的不是第一个节点
		// 找到父节点
		Node<E> node = root;
		Node<E> parent = root;
		int cmp = 0;
		while (node != null) {
			cmp = compare(element, node.element);
			parent = node;
			if (cmp > 0) {
				node = node.right;
			} else if (cmp < 0 ) {
				node = node.left;
			} else {
				node.element = element;
				return;
			}
		}
		
		Node<E> newNode = new Node<>(element, parent);
		if (cmp > 0) {
			parent.right = newNode;
		} else {
			parent.left = newNode;
		}
		size++;
	}
	
	public void remove() {
		
	}
	
	public boolean contains(E element) {
		return false;
	}
	
	/**
	 * @return 返回值等于0，代表e1和e2相等；返回值大于0，代表e1大于e2；回值小于0，代表e1小于e2；
	 */
	private int compare(E e1, E e2) {
		if (comparator != null) {
			return comparator.compare(e1, e2);
		}
		return ((Comparable<E>)e1).compareTo(e2);
	}
	
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}
	
	private static class Node<E> {
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
	}
	
	/**
	 * 前序遍历-递归方式
	 */
	public void preorderTraversal() {
		preorderTraversal(root);
	}
	
	private void preorderTraversal(Node<E> node) {
		if (node == null) return;
		System.out.println(node.element);
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}
	
	/**
	 * 中序遍历-递归方式
	 */
	public void inorderTraversal() {
		inorderTraversal(root);
	}
	
	private void inorderTraversal(Node<E> node) {
		if (node == null) return;
		inorderTraversal(node.left);
		System.out.println(node.element);
		inorderTraversal(node.right);
	}
	
	/**
	 * 后序遍历-递归方式
	 */
	public void postorderTraversal() {
		postorderTraversal(root);
	}
	
	private void postorderTraversal(Node<E> node) {
		if (node == null) return;
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.println(node.element);
	}

	/**
	 * 层序遍历
	 */

	public void levelOrderTraversal() {
		if (root == null) return;
		
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			System.out.println(node.element);
			
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
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
		Node<E> myNode = (Node<E>)node;
		String parentString = "null";
		
		if (myNode.parent != null) {
			parentString = myNode.parent.element.toString();
		}
		return myNode.element + "_p(" + parentString + ")";
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
	
//	public static interface Visitor<E> {
//		void visit(E element);
//	}
//	
	public static abstract class Visitor<E> {
		boolean stop;
		/**
		 * @return 如果返回true，就代表停止遍历
		 */
		public abstract boolean visit(E element);
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
				// node.left == null && node.right == null-
				
				// node.left != null && node.right == null
				leaf = true;
			}
		}
		return true;
	}
//	public boolean isComplete() {
//		if (root == null) return false;
//		
//		Queue<Node<E>> queue = new LinkedList<>();
//		queue.offer(root);
//		
//		boolean leaf = false;
//		while (!queue.isEmpty()) {
//			Node<E> node = queue.poll();
//			if (leaf && !node.isLeaf()) return false;
//
//			if (node.hasTwoChildren()) {
//				queue.offer(node.left);
//				queue.offer(node.right);
//			} else if (node.left != null && node.right == null) {
//				return false;
//			} else {
//				leaf = true;
//				if (node.left != null) {
//					queue.offer(node.left);
//				}
//			}
//		}
//		return true;
//	}
}

package com.zksir.tree;

import java.util.Comparator;

@SuppressWarnings("unchecked")
public class BST<E> extends BinaryTree<E> {
	private Comparator<E> comparator;
	
	public BST() {
		this(null);
	}
	
	public BST(Comparator<E> comparator) {
		this.comparator = comparator;
	}
	
	public void add(E element) {
		elementNotNullCheck(element);
		
		// 添加第一个节点
		if (root == null) {
			root = createNode(element, null);
			size++;
			afterAdd(root);
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
		
		Node<E> newNode = createNode(element, parent);
		if (cmp > 0) {
			parent.right = newNode;
		} else {
			parent.left = newNode;
		}
		size++;
		afterAdd(newNode);
	}
	
	public void remove(E element) {
		remove(node(element));
	}
	/**
	 * 添加node之后的调整
	 * @param node 新添加的节点
	 */
	protected void afterAdd(Node<E> node) { 
		
	}
	
	/**
	 * 删除node之后的调整
	 * @param node 被删除的节点 或者 用以取代被删除节点的子节点（当被删除节点的度为1）
	 */
	protected void afterRemove(Node<E> node) { }
	
	private void remove(Node<E> node) {
		if (node == null) return;
		size--;
		if (node.hasTwoChildren()) {// 度为2的节点
			// 找到后继节点
			Node<E> s = successor(node);
			// 用后继节点的值覆盖度为2节点的值
			node.element = s.element;
			// 删除后继节点
			node = s;
		}
		
		// 删除node节点（node的度必然是0或1）
		Node<E> replacement = node.left != null ? node.left : node.right;
		
		if (replacement != null) {// node是度为1的节点
			// 更改parent
			replacement.parent = node.parent;
			// 更改parent的left、right的指向
			if (node.parent == null) {// node是度为1并且是根节点
				root = replacement;
			} else if (node == node.parent.left) {
				node.parent.left = replacement;
			} else {// node == node.parent.right
				node.parent.right = replacement;
			}
			// 删除节点之后的处理
			afterRemove(replacement);
		} else if (node.parent == null) {// node是叶子节点，并且是根节点
			root = null;
			// 删除节点之后的处理
			afterRemove(node);
		} else {// node是叶子节点，但不是根节点 
			if (node == node.parent.right) {
				node.parent.right = null;
			} else {// node == node.parent.left
				node.parent.left = null;
			}
			// 删除节点之后的处理
			afterRemove(node);
		}
	}
	
	private Node<E> node(E element) {
		Node<E> node = root;
		while (node != null) {
			int cmp = compare(element,node.element);
			if (cmp == 0) return node;
			if (cmp > 0) {
				node = node.right;
			} else {
				node = node.left;
			}
		}
		return null;
	}
	
	public boolean contains(E element) {
		return node(element) != null;
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
	

}

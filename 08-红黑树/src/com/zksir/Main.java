package com.zksir;

import java.util.Comparator;

import com.zksir.printer.BinaryTrees;
import com.zksir.tree.AVLTree;
import com.zksir.tree.RBTree;

public class Main {
	
	static void test() {
		Integer data[] = new Integer[] {
				79, 88, 70, 4, 78, 31, 62, 52, 
			};
			
		AVLTree<Integer> bst = new AVLTree<Integer>();

		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		bst.remove(52);
		bst.remove(79);
		BinaryTrees.println(bst);
	}
	
	static void test1() {
		Integer data[] = new Integer[] {
				67, 52, 92, 96, 53, 95, 13, 63, 34, 82, 76, 54, 9, 68, 39
		};
		
		AVLTree<Integer> avl = new AVLTree<>();
		for (int i = 0; i < data.length; i++) {
			avl.add(data[i]);
//			System.out.println("【" + data[i] + "】");
//			BinaryTrees.println(avl);
//			System.out.println("---------------------------------------");
		}
		
//		for (int i = 0; i < data.length; i++) {
//			avl.remove(data[i]);
//			System.out.println("【" + data[i] + "】");
//			BinaryTrees.println(avl);
//			System.out.println("---------------------------------------");
//		}
		
		
		BinaryTrees.println(avl);
	}
	
	static void test2() {
		Integer data[] = new Integer[] {
				45, 35, 10, 97, 84, 89, 78, 72
		};
		
		RBTree<Integer> rb = new RBTree<>();
		for (int i = 0; i < data.length; i++) {
			rb.add(data[i]);
		}
		
		BinaryTrees.println(rb);
	}
	static void test3() {
		Integer data[] = new Integer[] {
				55, 87, 56, 74, 96, 22, 62, 20, 70, 68, 90, 50
		};
		
		RBTree<Integer> rb = new RBTree<>();
		for (int i = 0; i < data.length; i++) {
			rb.add(data[i]);
		}

		BinaryTrees.println(rb);

		for (int i = 0; i < data.length; i++) {
			rb.remove(data[i]);
			System.out.println("---------------------------------------");
			System.out.println("【" + data[i] + "】");
			BinaryTrees.println(rb);
		}
	}
	
	
	public static void main(String[] args) {
		test3();
	}


}

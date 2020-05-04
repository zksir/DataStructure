package com.zksir;

import java.util.Comparator;

import com.zksir.printer.BinaryTrees;
import com.zksir.tree.AVLTree;

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
	
	public static void main(String[] args) {
		test();
	}


}

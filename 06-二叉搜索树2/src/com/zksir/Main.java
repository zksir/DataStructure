package com.zksir;

import com.zksir.printer.BinaryTrees;
import com.zksir.tree.BST;

public class Main {
	static void test() {
		Integer data[] = new Integer[] {
				7, 4, 9, 2, 5, 8, 11, 3, 12, 1
			};
			
		BST<Integer> bst = new BST<Integer>();
		
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		
		BinaryTrees.println(bst);
		bst.remove(11);

		BinaryTrees.println(bst);
	}
	
	public static void main(String[] args) {
		test();
	}


}

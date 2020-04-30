package com.zksir;

import javax.xml.soap.Node;

import com.zksir.BinarySearchTree.Visitor;
import com.zksir.printer.BinaryTrees;

public class Main {

//	private static class PersonComparator implements Comparator<Person>{
//		public int compare(Person e1, Person e2) {
//			return e1.getAge() - e2.getAge();
//		}
//	}
//	
//	private static class PersonComparator2 implements Comparator<Person>{
//		public int compare(Person e1, Person e2) {
//			return e2.getAge() - e1.getAge();
//		}
//	}
	
	static void test1() {
		Integer data[] = new Integer[] {
				7, 4, 9, 2, 5, 8, 11, 3	
			};
			
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		
		BinaryTrees.println(bst);
	}
	
	static void test2() {
		Integer data[] = new Integer[] {
				7, 4, 9, 2, 5, 8, 11, 3	
			};
		BinarySearchTree<Person> bst3 = new BinarySearchTree<>();
		
		for (int i = 0; i < data.length; i++) {
			bst3.add(new Person(data[i]));
		}
		
		BinaryTrees.println(bst3);
	}
	
//	static void test3() {
//		Integer data[] = new Integer[] {
//				7, 4, 9, 2, 5, 8, 11, 3, 12, 1	
//			};
//		BinarySearchTree<Integer> bst3 = new BinarySearchTree<>();
//		
//		for (int i = 0; i < data.length; i++) {
//			bst3.add(data[i]);
//		}
//		
//		BinaryTrees.println(bst3);
//		bst3.levelOrder(new Visitor<Integer>() {
//			public void visit(Integer element) {
//				System.out.print("_" + element);
//			}
//			
//		});
//	}
	
//		/**
//		 * 匿名类用法，类似于JS中的闭包
//		 */
//		BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new Comparator<Person>() {
//			@Override
//			public int compare(Person o1, Person o2) {
//				return 0;
//			}
//		});
//		bst2.add(new Person(12));
//		bst2.add(new Person(15));

	static void test4() {
		Integer data[] = new Integer[] {
				7, 4, 9, 2, 1
			};
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		
		BinaryTrees.println(bst);
		
		bst.preOrder(new Visitor<Integer>() {
			public boolean visit(Integer element) {
				System.out.print(element + " ");
				return element == 2 ? true : false;
			}
		});
		
		System.out.println();
		bst.inOrder(new Visitor<Integer>() {
			public boolean visit(Integer element) {
				System.out.print(element + " ");
				return element == 4 ? true : false;
			}
		});
		
		System.out.println();
		bst.postOrder(new Visitor<Integer>() {
			public boolean visit(Integer element) {
				System.out.print(element + " ");
				return element == 4 ? true : false;
			}
		});
		
		System.out.println();
		bst.levelOrder(new Visitor<Integer>() {
			public boolean visit(Integer element) {
				System.out.print(element + " ");
				return element == 9 ? true : false;
			}
		});
		
	}
	
	static void test5() {
		Integer data[] = new Integer[] {
				7, 4, 9, 2, 5, 8, 11, 3, 12, 1	
			};
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		
		BinaryTrees.println(bst);
		
		System.out.println("树的高度为：" + bst.height());
		System.out.println("树的高度为：" + bst.height2());

	}
	
	static void test6() {

//		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
//		
//		for (int i = 0; i < 10; i++) {
//			bst.add((int)(Math.random() * 100));
//		}
		Integer data[] = new Integer[] {
				7, 4, 9, 2, 5
			};
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		
		BinaryTrees.println(bst);
		System.out.println(bst.isComplete());
	}
	
	public static void main(String[] args) {
		test6();
	}


}

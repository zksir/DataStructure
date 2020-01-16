package com.zksir;

public class Main {
    public static void main(String[] args) {
//        List<Integer> list = new LinkedList<>();
//        list.add(20);
//        list.add(1,10);
//        list.add(30);
//        list.add(list.size(),40);
//
//        list.remove(1);
//        System.out.println(list.toString());
//        System.out.println(list.get(0));
    	List<Integer> list = new ArrayList2<>();
    	for (int i = 0; i < 50; i++) {
			list.add(i);
		}
    	for (int i = 0; i < 50; i++) {
    		list.remove(0);
		}
		System.out.println(list);
    }
}

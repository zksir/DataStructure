package com.zksir;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
//        int a = list.remove(4);
//        System.out.println(a);
        list.add(5,60);
//        Assert.test(list.get(1) == 60);
        System.out.println(list.toString());
    }

}

package com.suanfa.lianbiao.circle;

import com.suanfa.lianbiao.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list=new CircleSingleLinkedList<Integer>();
        list.add(20);
        list.add(0,10);
        list.add(30);
        list.add(list.size(),40);

        list.remove(3);
        int i = list.indexOf(30);
        System.out.println(i);
        System.out.println(list);
    }
}

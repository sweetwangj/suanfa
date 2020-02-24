package com.suanfa.lianbiao.single;

import com.suanfa.lianbiao.List;
import com.suanfa.lianbiao.single.SingleLinkedList;

public class Test {
    public static void main(String[] args) {
        List<Integer> list=new SingleLinkedList<Integer>();
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

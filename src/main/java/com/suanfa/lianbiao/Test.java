package com.suanfa.lianbiao;

public class Test {
    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();
        linkedList.add(12);
        linkedList.add(23);
        linkedList.add(22);
        linkedList.add(2443);
        linkedList.add(2333);
        linkedList.add(2553);
        //linkedList.remove(0);
        linkedList.remove(linkedList.size()-1);
        System.out.println(linkedList);


    }
}

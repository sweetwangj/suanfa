package com.suanfa.lianbiao.circle;

public class 约瑟夫环问题 {
    public static void main(String[] args) {
        Josephus();
    }
    static void Josephus()
    {
        CircleLinkedList linkedList =new CircleLinkedList();
        for (int i = 1; i <=8 ; i++) {
            linkedList.add(i);
        }

        linkedList.reset();

        while (!linkedList.isEmpty())
        {
            //这个地方自定义调几次删除一个元素
            linkedList.next();
            linkedList.next();
            System.out.println(linkedList.remove());
        }

    }
}

package com.suanfa.stack;

public class MainTest {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(11);
        stack.push(22);
        stack.push(13);
        stack.push(55);
        stack.push(44);
        stack.push(23);

        System.out.println(stack);
        System.out.println(stack.top());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

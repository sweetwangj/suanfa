package com.suanfa.stack;

/**
 * 继承实现---也可以组合实现（能符合最少知道原则）
 * @param <E>
 */
public class Stack<E> extends ArrayList<E>{

    public void push(E element)
    {
        add(element);
    }

   public E pop()
    {
        E element = remove(size - 1);
        return element;
    }

   public E top()
    {
        return get(size-1);
    }
}

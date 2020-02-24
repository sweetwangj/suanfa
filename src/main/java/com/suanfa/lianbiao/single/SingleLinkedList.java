package com.suanfa.lianbiao.single;

import com.suanfa.lianbiao.AbstractList;

public class SingleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;

    public void clear() {
        size=0;
        first=null;
    }

    public E get(int index) {
        return node(index).element;
    }

    /**
     *  设置
     * @param index 下标
     * @param element 元素
     * @return 旧元素
     */
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old=node.element;
        node.element=element;
        return old;
    }

    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if(index==0)
        {
            first=new Node<E>(element,first);
        }else
        {
            Node<E> prev = node(index - 1);
            prev.next=new Node<E>(element,prev.next);
        }
        size++;
    }

    public E remove(int index) {
        //做一个校验
        rangeCheck(index);
        Node<E> node=first;
        if(index==0)
        {
          first=first.next;
        }else
        {
            Node<E> prev = node(index-1);
            node=prev.next;
            //通过链表前面指针 指向 后面的数据
            //prev.next=prev.next.next;
            prev.next=node.next;
        }
        size--;
        return node.element;
    }

    public int indexOf(E element) {
        if(element==null)
        {
            Node<E> node=first;
            for (int i = 0; i < size; i++) {
                if(node.element==null) return i;
                node=node.next;
            }
        }else
        {
            Node<E> node=first;
            for (int i = 0; i < size; i++) {
                if(element.equals(node.element)) return i;
                node=node.next;
            }
        }
        return  -1;
    }


    private static class Node<E>
    {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * 根据所给下标，取得所在位置 Node
     * @param index
     * @return
     */
    private Node<E> node(int index)
    {
        rangeCheck(index);
        //第一个节点
        Node<E> node=first;
        for (int i = 0; i <index ; i++) {
            node= node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        //size =3 [99,88,77]
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("size = ").append(size);
        stringBuilder.append(", [");
        Node<E> node=first;
        for (int i = 0; i <size ; i++) {
            if(i!=0)
            {
                stringBuilder.append(",");
            }
            stringBuilder.append(node.element);
            node=node.next;

        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


}

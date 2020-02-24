package com.suanfa.lianbiao;

public class LinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;

    public void clear() {
        size=0;
        first=null;
        last=null;
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
        if(index==size)//往最后面添加元素
        {

            Node<E> oldLast=last;
            last=new Node<E>(oldLast,element,null);
            if(oldLast==null)//这是链表中的第一个元素
            {
                first=last;
            }else
            {
                oldLast.next=last;
            }
        }else {
            Node<E> next=node(index);
            Node<E> prev=next.prev;
            Node<E> node=new Node<E>(prev,element,next);
            next.prev=node;

            if(prev==null)//index==0
            {
                first=node;
            }else
            {
                prev.next=node;
            }
        }

        size++;
    }

    public E remove(int index) {
        //做一个校验
        rangeCheck(index);
        if(index==size-1)
        {
            last=last.prev;
            last.next=null;
            size--;
            return last.element;
        }
        Node<E> node=first;
        if(index==0)
        {
            first=first.next;
        }else {
            node = node(index);
            node.prev.next=node.next.next;
            node.next.prev=node.prev.prev;
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
        Node<E> prev;
        E element;
        Node<E> next;

        public Node(Node<E> prev,E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (prev != null) {
                sb.append(prev.element);
            }else
            {
                sb.append("null");
            }
            sb.append("_").append(element).append("_");
            if (next != null)
            {
                sb.append(next.element);
            }else {
                sb.append("null");
            }
            return sb.toString();
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
        return getNode(index);
    }
    private Node<E> getNode(int index)
    {
        //第一个节点
        if(index < size>>1)
        {
            Node<E> node=first;
            for (int i = 0; i <index ; i++) {
                node= node.next;
            }
            return node;
        }else
        {
            Node<E> node=last;
            for (int i = size-1; i >index ; i--) {
                node= node.prev;
            }
            return node;
        }
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
            stringBuilder.append(node.toString());
            node=node.next;

        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


}

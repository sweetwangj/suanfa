package com.suanfa.lianbiao;
public class ArrayList<E> extends AbstractList<E>{
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAP=2;
    public ArrayList(int cap)
    {
        cap=(cap>DEFAULT_CAP)?cap:DEFAULT_CAP;
        elements= (E[]) new Object[cap];
    }
    public ArrayList()
    {
        this(DEFAULT_CAP);
    }

    public E get(int index)
    {
        if(index<0|| index>=size)
        {
            throw new  IndexOutOfBoundsException("index"+ index +"size" +size);
        }
        return elements[index];
    }

    public E set(int index, E element) {
        return null;
    }

    public int size()
    {
        return size;
    }

    /**
     * 添加
     * @param element
     */
    public void add(E element)
    {
       add(size,element);
    }

    /**
     * 打印
     * @return
     */
    @Override
    public String toString() {
        //size =3 [99,88,77]
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("size = ").append(size);
        stringBuilder.append(", [");
        for (int i = 0; i <size ; i++) {
            if(i!=0)
            {
                stringBuilder.append(",");
            }
            stringBuilder.append(elements[i]);
            //还需要做一次减法运算
          /*  if(i!=size-1)
            {
                stringBuilder.append(",");
            }*/
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /**
     * 删除指定位置的元素--实际上把后面的元素 向前移动覆盖原来位置的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index<0|| index>=size)
        {
            throw new  IndexOutOfBoundsException("index"+ index +"size" +size);
        }
        E oldValue=elements[index];
        for (int i = index+1; i <=size-1 ; i++) {
          elements[i-1] = elements[i];
        }
         elements[--size]=null;
        return oldValue;
    }

    /**
     * 指定位置添加元素
     * @param index 下标
     * @param element 元素
     */
    public void add(int index,E element)
    {
        rangeCheckForAdd(index);
        //处理关于容量的问题
        ensureCapacity(size+1);
        //从下标大的开始先向后移动
        for (int i = size-1; i >=index ; i--) {
            elements[i+1]=elements[i];
        }
        elements[index]=element;
        size++;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity=elements.length;
        if(oldCapacity>=capacity) return;
        //扩容1.5倍
        int newCapacity=oldCapacity+(oldCapacity>>1);
        E newElements[] = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i]=elements[i];
        }
        //把新的地址指向原来的数组
        elements=newElements;
        System.out.println(oldCapacity+" 扩容为 "+newCapacity);
    }

    public void clear()
    {
        for (int i = 0; i <size ; i++) {
            elements[i]=null;
        }
        size=0;
    }

    public int indexOf(E element)
    {
        if(element==null)
        {
            for (int i = 0; i <size ; i++) {
                if(elements[i]==null) return i;
            }
        }else
        {
            for (int i = 0; i <size ; i++) {
                if(element.equals(elements[i])) return i;
            }
        }
        return -1;
    }

    /**
     * 动态数组缩容
     *
     */
    private void trim()
    {
        int capacity=elements.length;
        int newCapacity=capacity>>1;
        //容量大于一半不需要扩容 或者已经小于默认容量了也不需要扩容
        if(size >= newCapacity || capacity<=DEFAULT_CAP) return;
        E newElements[] = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i]=elements[i];
        }
        //把新的地址指向原来的数组
        elements=newElements;

    }
}

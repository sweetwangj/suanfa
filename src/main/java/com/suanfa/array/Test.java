package com.suanfa.array;

public class Test {
    public static void main(String[] args) {
        ArrayList<Person> personArrayList=new ArrayList<Person>();
        personArrayList.add(new Person("hahah","12"));
        personArrayList.add(new Person("xixi","14"));
        personArrayList.clear();
        System.gc();


    }

    static void test()
    {
        ArrayList arrayList=new ArrayList();
        arrayList.add(11);
        arrayList.add(22);
        arrayList.add(33);
        arrayList.add(44);
        arrayList.add(11);
        arrayList.add(22);
        arrayList.add(22);


        //arrayList.remove(arrayList.size()-1);
        //arrayList.add(2,100);
        //System.out.println(arrayList.toString());

        //泛型
        ArrayList<Integer> integerArrayList=new ArrayList<Integer>();
        integerArrayList.add(12);
        integerArrayList.add(13);
        System.out.println(integerArrayList.toString());

        ArrayList<Person> personArrayList=new ArrayList<Person>();
        personArrayList.add(new Person("hahah","12"));
        personArrayList.add(new Person("xixi","14"));
        System.out.println(personArrayList.toString());

    }
}

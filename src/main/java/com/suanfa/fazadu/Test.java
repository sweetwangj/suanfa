package com.suanfa.fazadu;

/**
 * 斐波那契数列(前两个数个等于后一个数) 两种解法
 * 0 1 1 2 3 5 8 13 21 ....
 *
 * 求第n个数是多少
 */
public class Test {
    public static void main(String[] args) {
        //System.out.println(fbi1(40));
        System.out.println(fbi2(40));
        System.out.println(fbi3(40));
    }

    /**
     * 递归存在性能问题
     * @param n
     * @return
     */
    static int fbi1(int n)
    {
        if(n<=1) return n;
        return fbi1(n-1)+fbi1(n-2);
    }


    static int fbi2(int n)
    {
        if(n<=1) return n;
        int first=0;
        int second=1;
        for (int i = 0; i <n-1 ; i++) {
            int sum=first+second;
            //后一个现在变成下次做加法时的first
            first=second;
            //把当前循环的结果赋值给下一次做加法的second
            second=sum;
        }
        //最终的 结果 存在second中
        return second;
    }

    static int fbi3(int n)
    {
        if(n<=1) return n;
        int first=0;
        int second=1;
        while (n-- > 1){
           //second=first+second;
           second+=first;
           first=second-first;
        }
        //最终的 结果 存在second中
        return second;
    }

}

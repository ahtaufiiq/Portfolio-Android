package com.ataufiq;

public class SwapValue {
    private int a,b,c;

    public SwapValue(int j,int k){
        // save j
        // save k
        a=j;
        b=k;
        //print a dan b
        System.out.println(a);
        System.out.println(b);
        //c =j
        c=a;
        //a =b
        a=b;
        //b =c
        b=c;
        System.out.println(a);
        System.out.println(b);
    }
}

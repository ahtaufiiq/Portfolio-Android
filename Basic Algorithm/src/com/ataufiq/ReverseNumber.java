package com.ataufiq;

public class ReverseNumber {

    int r,rev;

    public ReverseNumber(int n) {
        while(n>0)
        {
            r=n%10;
            rev=rev*10+r;
            n=n/10;
        }
        System.out.println("Reverse: "+rev);
    }
}

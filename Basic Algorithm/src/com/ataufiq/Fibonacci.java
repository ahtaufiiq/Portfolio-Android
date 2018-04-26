package com.ataufiq;

public class Fibonacci {

    int first=0,second=1,next;

    public Fibonacci(int n) {

        for (int i=0;i<n;i++){
            System.out.print(first+", ");
            next= first+second;
            first=second;
            second=next;
        }

    }
}

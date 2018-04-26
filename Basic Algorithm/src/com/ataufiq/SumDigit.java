package com.ataufiq;

public class SumDigit {

    int count;
    int digit,total;
    public SumDigit(int n) {

        //ulangi sampai n =0

        while (n>0){
            digit=n%10;
            n/=10;
            total+=digit;
            count++;
        }
        System.out.println(total);


    }
}

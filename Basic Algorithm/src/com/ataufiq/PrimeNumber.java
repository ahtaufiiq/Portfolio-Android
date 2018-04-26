package com.ataufiq;

public class PrimeNumber {

    public PrimeNumber(int n) {

        //jika 1 not prime
        if (n==1){
            System.out.println("prima terekcil adalah 2");
        }
        //Ulangi sebanyak n
        for (int i =2; i<n;i++) {
            // if n%i ==0 not prime
            if (n%i==0){
                System.out.println("Not Prime");
                break;
            }
            if ((n-1)==i){
                System.out.println("Prime");
            }
        }
    }
}

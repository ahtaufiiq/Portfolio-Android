package com.ataufiq;

public class NumberPattern {

    public NumberPattern(int n) {

        //pengulangan sebanyak n
        for (int i =1;i<=n;i++) {
            // pengulangan j<i
            for (int j=1;j<=i;j++) {
                //print j
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}

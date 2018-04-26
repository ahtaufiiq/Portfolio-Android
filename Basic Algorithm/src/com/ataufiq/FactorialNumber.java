package com.ataufiq;

public class FactorialNumber {
    int hasil=1;

    public FactorialNumber(int n) {

        //Ulangi sebanyak n
        for(int i = 1; i<=n;i++) {
            //hasil = hasil*n
            hasil*=i;
        }
        System.out.println(hasil);
    }

}

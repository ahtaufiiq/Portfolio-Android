package com.ataufiq;

public class StairCase {

    public void staircase(int n) {

        //Ulangi sebanyak n
        for (int i =1; i<=n;i++){

            for (int k =n;k>i;k--){
                System.out.print(" ");
            }
            for (int j=1; j<=i;j++){
                System.out.print("#");
            }
            System.out.println();
        }

    }
}

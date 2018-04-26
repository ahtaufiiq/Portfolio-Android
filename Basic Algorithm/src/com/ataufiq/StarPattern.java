package com.ataufiq;

public class StarPattern {
    public StarPattern() {
    }

    public StarPattern(int n) {

        //ulangi sebanyak n
        for (int i=1;i<=n;i++) {
            //ulangi sebanyak n-1 sesuai i
            for (int j=n-1;j>=i;j--){
                System.out.print(" ");
            }
            //ulangi sebanyak (i*2)-1 sesuai i
            for (int k =1;k<=(i*2)-1;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public void segitigaKebalik(int n){

        //perulangan sebanyak n & i =n
        for (int i =n;i>0;i++){
            //print spasi i >n
            for (int j=i;j>n;j++){
                System.out.print(" ");
            }
            //print sebanyak (n*2-1)
            for (int k=i*2-1;k>0;k--){
                System.out.print("*");
            }
        }

    }
}

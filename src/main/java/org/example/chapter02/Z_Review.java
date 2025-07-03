package org.example.chapter02;

public class Z_Review {
    public static void main(String[] args) {
        /*

            *****
            ****
            ***
            **
            *

            별은 하나씩 감소 5 -> 1

         */

        // 예제 1
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }


        /*
           *****
           .****
           ..***
           ...**
           ....*

           공백 하나씩 증가 0 -> 4
           별은 하나씩 감소 5 -> 1
       */

        // 예제 2
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < i; j++){
                System.out.print(" ");
            }
            for(int k = 0; k < 5 - i; k++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}

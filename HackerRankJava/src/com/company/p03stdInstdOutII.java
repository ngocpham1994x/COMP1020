package com.company;

import java.util.*;

public class p03stdInstdOutII {
    public static void main(){
        Scanner scan3 = new Scanner(System.in);
        int i = scan3.nextInt();
        double d = scan3.nextDouble();
        scan3.nextLine();
        String s = scan3.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}

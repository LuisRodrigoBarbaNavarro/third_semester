package com.second.unit;

import java.util.Scanner;

public class Example5 {

    //LUIS RODRIGO BARBA NAVARRO

    static String isEven (long n) {
        if (n == 0) return "par";
        if (n == 1) return "impar";
        return isEven(n - 2);
    }
    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Introduzca un número: ");
        long n = console.nextLong();
        System.out.println(n + " es un número " + isEven(n) + ".");
        console.close();
    }

}

package com.second.unit;
import java.util.*;

public class Example1 {

    //LUIS RODRIGO BARBA NAVARRO - CON RECURSIVIDAD

    static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else if (n > 1) {
            return n * factorial(n - 1);
        }
        return 1;
    }
    public static void main(String [] args) {
        int n;
        Scanner console = new Scanner(System.in);
        System.out.println("Introduzca un número: ");
        n = console.nextInt();
        System.out.println("El factorial de " + n + " es " + factorial(n));
        console.close();
    }

}

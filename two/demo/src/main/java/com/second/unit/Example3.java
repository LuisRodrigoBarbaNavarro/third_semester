package com.second.unit;

import java.util.*;

public class Example3 {

    //LUIS RODRIGO BARBA NAVARRO - SIN RECURSIVIDAD

    static long factorial(int n) {
        long r = n;
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else {
            while (n > 1) {
                r *= n - 1;
                n--;
            }
        }
        return r;
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

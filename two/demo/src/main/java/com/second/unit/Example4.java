package com.second.unit;

import java.util.Scanner;

public class Example4 {

    //LUIS RODRIGO BARBA NAVARRO

    static int sum(int n) {
        if (n > 0)
            return n + sum(n - 1);
        else
            return 0;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Introduzca un número: ");
        int n = console.nextInt();
        System.out.println("La suma de los primero números naturales es: " + sum(n));
        console.close();
    }

}
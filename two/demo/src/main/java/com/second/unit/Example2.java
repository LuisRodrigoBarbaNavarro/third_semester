package com.second.unit;

import java.util.Scanner;

public class Example2 {

    //LUIS RODRIGO BARBA NAVARRO

    static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n > 1) {
            return fibonacci(n - 1) + fibonacci(n - 2);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Introduzca el límite de la sucesión: ");
        int n = console.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.printf(fibonacci(i) + ", ");
        }
        console.close();
    }

}
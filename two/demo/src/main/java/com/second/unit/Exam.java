package com.second.unit;

public class Exam {

    //LUIS RODRIGO BARBA NAVARRO - Examen

    static int serie(int n, boolean flag) {
        if (n <= 25) {
            System.out.printf(n + ", ");
            if (flag) n = serie(n + 2,flag = false);
            else n = serie(n + 3, flag = true);
        }
        return n;
    }

    public static void main(String[] args) {
        serie(2, false);
    }

}
package com.third.unit;

import java.util.Scanner;

/* LUIS RODRIGO BARBA NAVARRO */

class Stack 
{

    static final int MAX = 5;
    int top = -1;
    int stack[] = new int[MAX];
 
    boolean isEmpty()
    {
        return (top == -1);
    }

    boolean isFull()
    {
        return (top == (MAX - 1));
    }
 
    void push(int x)
    {
        if (isFull() == true) 
        {
            System.out.println("Pila llena.");
        }
        else 
        {
            stack[++top] = x;
            System.out.println("\n" + x + " se ha ingresado.");
        }
    }
 
    void pop()
    {
        if (isEmpty() == true) 
        {
            System.out.println("Pila vacía.");
        }
        else
        {
            System.out.println("\n" + stack[top--] + " se ha eliminado.");
        }
    }

    void print()
    {
        System.out.println("\n" + "Contiene los siguientes elementos: ");
        for(int i = top; i > -1; i--)
        {
            System.out.println(stack[i]);
        }
    }

}

public class Example1 
{
    static String messages[] = 
    {
        "\nMenú de opciones: ",
        "  + Verificar si la pila está llena - [1]",
        "  + Verificar si la pila está vacía - [2]",
        "  + Insertar elemento en la pila - [3]",
        "  + Eliminar elemento en la pila - [4]",
        "  + Recorrer pila - [5]",
        "  + Finalizar programa - [6]"
    };

    public static void main( String[] args )
    {
        boolean flag = false;
        Stack stack = new Stack();
        Scanner console = new Scanner(System.in);
        do 
        {
            for (int i = 0; i < messages.length; i++)
            {
                System.out.println(messages[i]);
            }
            System.out.printf("Opción: ");
            int key = console.nextInt();
            switch (key) {
                case 1:
                    if (stack.isFull() == true) System.out.println("\n"+"La pila está llena.");
                    else System.out.println("\n"+"La pila no está llena.");
                    break;
                case 2:
                    if (stack.isEmpty() == true) System.out.println("\n"+"La pila está vacía.");
                    else System.out.println("\n"+"La pila no está vacía.");
                    break;
                case 3:
                    System.out.printf("\n"+"Ingrese el elemento: ");
                    int n = console.nextInt();
                    stack.push(n);
                    break;
                case 4:
                    stack.pop();
                    break;
                case 5:
                    stack.print();
                    break;
                case 6:
                    flag = true;
                    break;
                default:
                    System.out.println("\n"+"La opción es inválida.");
                    break;
            }
        } while (!flag);
        console.close();
    }
}
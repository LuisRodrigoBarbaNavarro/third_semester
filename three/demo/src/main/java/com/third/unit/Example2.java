package com.third.unit;

import java.util.Scanner;

/* LUIS RODRIGO BARBA NAVARRO */

class Queue 
{

    Scanner console = new Scanner(System.in);

    private static final int MAX = 5;
    private int last = -1;
    private int queue[] = new int[MAX];
 
    boolean isEmpty()
    {
        return (last < 0);
    }

    boolean isFull()
    {
        return (last >= (MAX - 1));
    }

    void search()
    {
        boolean found = false;
        if (isEmpty() == true)
        {
            System.out.printf("\n" + "No se encontró el elemento porque la cola está vacía." + "\n");
        }
        else
        {
            System.out.printf("\n" + "Ingrese el elemento a buscar: ");
            int n = console.nextInt();
            for (int i = 0; i <= last; i++)
            {
                if (queue[i] == n) found = true;
            }
            if (found == true)  System.out.printf("\n" + "El elemento sí existe." + "\n");
            else  System.out.printf("\n" + "El elemento no existe." + "\n");
        }
    }

    void enqueue()
    {
        if (isFull() == true) 
        {
            System.out.println("\n" + "Cola llena.");
        }
        else 
        {
            System.out.printf("\n" + "Ingrese el elemento: ");
            int n = console.nextInt();
            queue[++last] = n;
            System.out.println("\n" + n + " se ha ingresado.");
        }
    }

    void edit()
    {
        if (isEmpty() == true)
        {
            System.out.println("\n" + "Cola vacía.");
        }
        else
        {
            boolean found = false; int position = 0;
            System.out.printf("\n"+"Ingrese el elemento a modificar: ");
            int n = console.nextInt();
            for (int i = 0; i <= last; i++) 
            {
                if (queue[i] == n) 
                {
                    found = true;
                    position = i;
                }
            }
            if (found == true)
            {
                System.out.println("El dato "+ n +" existe en la cola");
                System.out.printf("\n" + "Ingrese el nuevo elemento: ");
                int temp = console.nextInt();
                queue[position] = temp;
                System.out.println("\n" + "El dato ha sido actualizado.");
            }
            else
            {
                System.out.println("El dato "+ n +" no existe en la cola.");
            }
        }
    }

    void dequeue()
    {
        if (isEmpty() == true) 
        {
            System.out.println("\n" + "Cola vacía.");
        }
        else
        {
            System.out.println("\n" + queue[0] + " se eliminó.");
            for (int i = 0; i < last; i++) queue[i] = queue[i + 1];
            last--;
        }
    }

    void print()
    {
        if (isEmpty() == true) 
        {
            System.out.println("\n" + "Cola vacía.");
        } else 
        {
            System.out.println("\n" + "Contiene los siguientes elementos: ");
            for(int i = 0; i <= last; i++) System.out.print(queue[i] + " <- ");
            System.out.println();
        }
    }

}

public class Example2 
{

    static String messages[] = 
    {
        "\nMenú de opciones: ",
        "  + Verificar si la cola está llena - [1]",
        "  + Verificar si la cola está vacía - [2]",
        "  + Buscar elemento específico en la cola - [3]",
        "  + Insertar elemento en la cola - [4]",
        "  + Editar elemento en la cola - [5]",
        "  + Eliminar elemento en la cola - [6]",
        "  + Recorrer cola - [7]",
        "  + Finalizar programa - [8]"
    };

    public static void main( String[] args )
    {
        Scanner console = new Scanner(System.in);
        boolean flag = false;
        Queue queue = new Queue();
        do 
        {
            for (int i = 0; i < messages.length; i++) System.out.println(messages[i]);
            System.out.printf("Opción: ");
            int key = console.nextInt();
            switch (key) 
            {
                case 1:
                    if (queue.isFull() == true) System.out.println("\n"+"La cola está llena.");
                    else System.out.println("\n" + "La cola no está llena.");
                    break;
                case 2:
                    if (queue.isEmpty() == true) System.out.println("\n" + "La cola está vacía.");
                    else System.out.println("\n" + "La cola no está vacía.");
                    break;
                case 3:
                    queue.search();
                    break;
                case 4:
                    queue.enqueue();
                    break;
                case 5:
                    queue.edit();
                    break;
                case 6:
                    queue.dequeue();
                    break;
                case 7:
                    queue.print();
                    break;
                case 8:
                    flag = true;
                    break;
                default:
                    System.out.println("\n"+"La opción es inválida, inténtelo de nuevo.");
                    break;
            }
        } while (!flag);
        console.close();
    }
}

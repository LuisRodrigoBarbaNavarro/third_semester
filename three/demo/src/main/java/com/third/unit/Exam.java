package com.third.unit;

import java.util.Scanner;

/* LUIS RODRIGO BARBA NAVARRO */

class LinkedListClass
{

    Scanner console = new Scanner(System.in);

    Node head, last;

    static class Node 
    {
   
        int data;
        Node next;
   
        Node(int data)
        {
            this.data = data;
            next = null;
        }

    }

    public void insert(int data)
    {
        
        Node new_node = new Node(data);
   
        if (check(data) != true)
        {
            if (head == null)
            {
                head = new_node;
                new_node.next = null;
                last = head;  
            }
            else
            {
                last.next = new_node;
                new_node.next = null;
                last = new_node;
            }

            System.out.println("\n" + data + " se ha ingresado.");
        } 
        else
        {
            System.out.println("No se puede insertar un dato repetido.");
        }

    }

    public void print()
    {

        System.out.println("\n" + "Lista simplemente enlazada: ");

        if (head != null) 
        {
            Node current_node = head;
            while (current_node != null)
            {
                System.out.print(current_node.data + " -> ");
                current_node = current_node.next;
            }
            System.out.println();
        }
        else System.out.println("\n" + "No hay datos.");

    }

    public void search()
    {

        boolean found = false;
        if (head != null) 
        {
            Node current_node = head;
            System.out.printf("\n" + "Ingrese el nodo a buscar: ");
            int data = console.nextInt();
            while (current_node != null)
            {
                if (current_node.data == data)
                {
                    System.out.println("Nodo encontrado.");
                    found = true;
                }
                current_node = current_node.next;
            }
            if (found == false) System.out.println("El nodo no existe.");
        }
        else System.out.println("\n" + "No hay datos.");

    }

    public boolean check(int data)
    {

        boolean found = false;
        if (head != null) 
        {
            Node current_node = head;
            while (current_node != null)
            {
                if (current_node.data == data) found = true;
                current_node = current_node.next;
            }
        }
        else found = false;
        return found;

    }

    public void edit()
    {

        boolean found = false;
        if (head != null) 
        {
            Node current_node = head;
            System.out.printf("\n" + "Ingrese el nodo a modificar: ");
            int data = console.nextInt();
            while (current_node != null)
            {
                if (current_node.data == data)
                {
                    found = true;
                    System.out.println("Nodo encontrado.");
                    System.out.printf("\n" + "Ingrese el nuevo nodo: ");
                    int temp = console.nextInt();
                    if (check(temp) != true)
                    {
                        current_node.data = temp;
                        System.out.println("Nodo modificado satisfactoriamente.");
                    }
                    else System.out.println("No se puede insertar un dato repetido.");
                }
                current_node = current_node.next;
            }
            if (found == false) System.out.println("El nodo no existe.");
        }
        else System.out.println("\n" + "No hay datos.");

    }

    public void delete()
    {

        boolean found = false;
        if (head != null) 
        {
            Node current_node = head, previous = null;
            System.out.printf("\n" + "Ingrese el nodo a eliminar: ");
            int data = console.nextInt();
            while (current_node != null)
            {
                if (current_node.data == data)
                {
                    found = true;
                    System.out.println("Nodo removido.");
                    if (current_node == head)
                    {
                        head = head.next;
                    }
                    else if (current_node.next == null)
                    {
                        last = previous;
                        last.next = null;
                    }
                    else
                    {
                        previous.next = current_node.next;
                    }
                }
                previous = current_node;
                current_node = current_node.next;
            }
            if (found == false) System.out.println("El nodo no existe.");
        }
        else System.out.println("\n" + "No hay datos.");
    }

}

public class Exam 
{
    static String messages[] = 
    {
        "\nMenú de opciones: ",
        "  + Insertar nodo en la lista - [1]",
        "  + Modificar nodo en la lista - [2]",
        "  + Eliminar nodo en la lista - [3]",
        "  + Buscar nodo específico en la lista - [4]",
        "  + Imprimir lista - [5]",
        "  + Finalizar programa - [6]"
    };

    public static void main( String[] args )
    {
        Scanner console = new Scanner(System.in);
        boolean flag = false;
        LinkedListClass list = new LinkedListClass();
        do 
        {
            for (int i = 0; i < messages.length; i++) System.out.println(messages[i]);
            System.out.printf("Opción: ");
            int key = console.nextInt();
            switch (key) 
            {
                case 1:
                    System.out.printf("\n" + "Ingrese el elemento: ");
                    int x = console.nextInt();
                    list.insert(x);
                    break;
                case 2:
                    list.edit();
                    break;
                case 3:
                    list.delete();
                    break;
                case 4:
                    list.search();
                    break;
                case 5:
                    list.print();
                    break;
                case 6:
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
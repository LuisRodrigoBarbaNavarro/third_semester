package com.third.unit;

import java.util.Scanner;

/* LUIS RODRIGO BARBA NAVARRO */

class DoublyLinkedList
{
    private Scanner console = new Scanner(System.in);

    private Node head;
    private boolean flag;

    private class Node
    {
        private int data;
        private Node previous;
        private Node next;

        Node (int data) 
        { 
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    public void push (int data)
    {
        Node new_node = new Node(data);
        
        if (head == null)
        {
            head = new_node;
        }
        else
        {
            Node current_node = head;
            while (current_node.next != null)
            {
                current_node = current_node.next;
            }
            current_node.next = new_node;
            new_node.previous = current_node;      
        }

        System.out.println("\n" + data + " se ha ingresado.");
    }

    public void displayForward ()
    {
        System.out.println();

        Node current_node = head;
        if (head != null)
        {
            while (current_node != null)
        {
            System.out.print("<- " + current_node.data + " -> ");
            current_node = current_node.next;
        }
            System.out.println();
        }
        else
        {
            System.out.println("No existen nodos dentro de la lista.");
        }
    }

    public void displayReverse ()
    {
        System.out.println();

        Node current_node = head;
        if (head != null)
        {
            while (current_node.next != null) current_node = current_node.next;
            while (current_node != null) {
                System.out.print("<- " + current_node.data + " -> ");
                current_node = current_node.previous;
            }
            System.out.println();
        }
        else
        {
            System.out.println("No existen nodos dentro de la lista.");
        }
    }

    public void search ()
    {
        System.out.println();

        Node current_node = head; flag = false;
        if (head != null)
        {
            System.out.print("Nodo a buscar: ");
            int data = console.nextInt();
            while (current_node != null)
            {
                if (current_node.data == data)
                {
                    flag = true;
                    System.out.println("Se encontró el nodo.");
                }   
                current_node = current_node.next; 
            }
            if (flag == false) System.out.println("No se encontró el nodo.");
        }
        else
        {
            System.out.println("No existen nodos dentro de la lista.");
        }
    }

    public void modify ()
    {
        System.out.println();

        Node current_node = head; flag = false;
        if (head != null)
        {
            System.out.print("Nodo a modificar: ");
            int data = console.nextInt();
            while (current_node != null)
            {
                if (current_node.data == data)
                {
                    flag = true;
                    System.out.print("Nodo nuevo: ");
                    int temp = console.nextInt();
                    current_node.data = temp;
                    System.out.println("Se modificó el nodo.");
                }   
                current_node = current_node.next; 
            }
            if (flag == false) System.out.println("No se encontró el nodo.");
        }
        else
        {
            System.out.println("No existen nodos dentro de la lista.");
        }
    }

    public void delete ()
    {
        System.out.println();

        Node current_node = head; flag = false;
        if (head != null)
        {
            System.out.print("Nodo a eliminar: ");
            int data = console.nextInt();
            while (current_node != null)
            {
                if (current_node.data == data)
                {
                    flag = true;
                    if (current_node.previous == null && current_node.next == null)
                    {
                        head = null;
                    }
                    if (current_node == head)
                    {
                        head = current_node.next;
                        head.previous = null;
                    }
                    if (current_node.next != null)
                    {
                        current_node.next.previous = current_node.previous;
                    }
                    if (current_node.previous != null)
                    {
                        current_node.previous.next = current_node.next;
                    }
                    System.out.println("Se eliminó el nodo.");
                }  
                current_node = current_node.next; 
            }
            if (flag == false) System.out.println("No se encontró el nodo.");
        }
        else
        {
            System.out.println("No existen nodos dentro de la lista.");
        }
    }

}

public class Example5
{
    static String messages[] = 
    {
        "\nMenú de opciones: ",
        "  + Insertar nodo en la lista - [1]",
        "  + Imprimir lista (Primero a último) - [2]",
        "  + Imprimir lista (Último a primero) - [3]",
        "  + Buscar nodo específico en la lista - [4]",
        "  + Modificar nodo específico en la lista - [5]",
        "  + Eliminar nodo específico en la lista - [6]",
        "  + Finalizar - [7]"
    };

    public static void main( String[] args )
    {
        Scanner console = new Scanner(System.in);
        boolean flag = false;
        DoublyLinkedList list = new DoublyLinkedList();
        do 
        {
            for (int i = 0; i < messages.length; i++) System.out.println(messages[i]);
            System.out.printf("Opción: ");
            int key = console.nextInt();
            switch (key) 
            {
                case 1:
                    System.out.printf("\n" + "Ingrese el elemento: ");
                    list.push(console.nextInt());
                    break;
                case 2:
                    list.displayForward();
                    break;
                case 3:
                    list.displayReverse();
                    break;
                case 4:
                    list.search();
                    break;
                case 5:
                    list.modify();
                    break;
                case 6:
                    list.delete();
                    break;
                case 7:
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

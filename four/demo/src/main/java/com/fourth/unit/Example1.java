package com.fourth.unit;

import java.util.Scanner;

/* BARBA NAVARRO LUIS RODRIGO - 20490687 */
class Node 
{

    int value;
    Node left;
    Node right;

    Node (int value)
    {
        this.value = value;
        right = null;
        left = null;
    }

}

class BinaryTree
{

    Node root;

    public BinaryTree () { root = null; }
    
    public void insert (int value)
    {

        Node current = new Node (value);

        if (root == null) root = current;
        else
        {

            Node auxiliary = root;
            Node parent;
            while (true) 
            {
                parent = auxiliary;
                if (value < auxiliary.value)
                {
                    auxiliary = auxiliary.left;
                    if (auxiliary == null)
                    {   
                        parent.left = current;
                        return;
                    }
                }
                else
                {
                    auxiliary = auxiliary.right;
                    if (auxiliary == null)
                    {   
                        parent.right = current;
                        return;
                    }
                }
            }
        }

    }

    public boolean is_empty () { return root == null; }

    public Node delete (Node root, int key)
    {

        if (root == null) return null;
        else if (root.value > key) root.left = delete(root.left, key);
        else if (root.value < key) root.right = delete(root.right, key);
        else 
        {
            if (root.left != null && root.right != null) {
                Node auxiliary = root;
                Node minimum_node_right = minimum_value(auxiliary.right);
                root.value = minimum_node_right.value;
                root.right = delete(root.right, minimum_node_right.value);
 
            }
            else if (root.left != null) root = root.left;
            else if (root.right != null) root = root.right;
            else root = null;
        }
        return root;

    }

    public  Node minimum_value(Node root)
    {

        if (root.left == null) return root;
        else  return minimum_value(root.left);
        
    }

    public Node search (Node root, int value)
    {

        if (root == null || root.value == value)
            return root;
    
        if (root.value < value)
            return search(root.right, value);
    
        return search(root.left, value);

    }

    public void inorder (Node root)
    {

        if (root != null)
        {
           inorder(root.left);
           System.out.println(root.value);
           inorder(root.right); 
        }

    }

    public void preorder (Node root)
    {

        if (root != null)
        {
           System.out.println(root.value);
           preorder(root.left);
           preorder(root.right); 
        }

    }

    public void postorder (Node root)
    {

        if (root != null)
        {
           postorder(root.left);
           postorder(root.right);
           System.out.println(root.value);
        }

    } 

}

public class Example1 
{
    
    static Scanner console = new Scanner(System.in);
 
    public static void main (String [] args) { app(); }

    public static void app ()
    {

        int option, value;
        BinaryTree three = new BinaryTree();
  
        do
        {
            System.out.println("\nArbol Binario\n");
            System.out.println("1.- Agregar nodo al árbol");
            System.out.println("2.- Buscar nodo en el árbol");
            System.out.println("3.- Recorrer InOrden el árbol");
            System.out.println("4.- Recorrer PreOrden el árbol");
            System.out.println("5.- Recorrer PostOrden el árbol");
            System.out.println("6.- Eliminar nodo en el árbol");
            System.out.println("7.- Salida\n");
            System.out.print("Selecciona opcion: ");
            
            option = console.nextInt();
            
            switch (option)
            {
                case 1: 
                    System.out.println("Agregar: ");	
                    System.out.print("Introducir dato: ");
                    value = console.nextInt();
                    if (three.search(three.root, value) != null) System.out.println("No se permiten valores repetidos.");
                    else three.insert(value);
                    break;

                case 2:
                    System.out.println("Buscar");	
                    System.out.print("Introducir dato: ");
                    value = console.nextInt();
                    if (three.search(three.root, value) == null) System.out.println("El nodo no se ha encontrado.");
                    else System.out.println("El nodo se ha encontrado.");
                    break;

                case 3:
                    System.out.println("Recorrido InOrden: ");	
                    if(!three.is_empty()) three.inorder(three.root);
                    else System.out.println("El árbol está vacío.");	
                    break;

                case 4:
                    System.out.println("Recorrido PreOrden: ");	
                    if(!three.is_empty()) three.preorder(three.root);
                    else System.out.println("El árbol está vacío.");
                    break;

                case 5:
                    System.out.println("Recorrido PostOrden: ");	
                    if(!three.is_empty()) three.postorder(three.root);
                    else System.out.println("El árbol está vacío.");	
                    break;
                
                case 6:
                    System.out.println("Borrar: ");	
                    System.out.print("Introducir dato: ");
                    value = console.nextInt();
                    if (three.search(three.root, value) != null)
                    {
                        Node new_root = three.delete(three.root, value);
                        three.root = new_root;
                    }
                    else System.out.println("El nodo no se ha encontrado o el árbol está vacío.");
                    break;
                
                case 7:
                    System.out.println("La aplicación ha finalizado.");
                    break;
            }

        } while(option != 7);

    }
}

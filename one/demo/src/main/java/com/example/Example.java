package com.example;
import java.util.Scanner;
public class Example
{
    static class Book
    {
        String fullname;
        String lastname;
        int age;
    }
    public static void main(String [] args)
    {
        Book [] register = new Book [3];
        Scanner console = new Scanner(System.in);
        for(int i = 0; i < 3; i++)
        {
          Book record = new Book();
          System.out.println("Give me fullname: " + (i+1));
          String tempFullname = console.next();
          record.fullname = tempFullname;
          System.out.println("Give me lastname: " + (i+1));
          String tempLastname = console.next();
          record.lastname = tempLastname;
          System.out.println("Give me age: " + (i+1));
          int tempAge = console.nextInt();
          record.age = tempAge;
          register [i] = record;
        }
        for(int i = 0; i < 3; i++)
        {
            System.out.println(
            "Fullname: " + register[i].fullname + "\n" +
            "Lastname: " + register[i].lastname + "\n" +
            "Age: " + register[i].age 
            );
        }
        System.out.println("Finish with 0");
        console.close();
    }
}


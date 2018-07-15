package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choose;
        int[] mass = new int[10];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < mass.length; i++) {
            mass[i] = ((int)(Math.random() * 200) - 100);
            System.out.print(mass[i] + "|");
        }
        System.out.println("\nВыбор задания: 1 - нахождение Min и Max эл-тов | 2 - замена нулями");
        choose = in.nextInt();
        switch (choose){
            case 1:
        searchMinMax(mass);
        break;
            case 2:
        replaceOnZero(mass);
        default:
        break;}
    }
    public static void searchMinMax(int[] mass)
    {
        int indexMin = 0, indexMax = 0;
        for (int i=0; i<mass.length; i++)
        {
            if(mass[i] > mass[indexMax])
                indexMax = i;
            else if(mass[i] < mass[indexMin])
                indexMin = i;
        }

        System.out.println("\nMin: " + mass[indexMin] + " Max: " + mass[indexMax]);
        mass[indexMax] = 0;
        mass[indexMin] = 0;
        for (int i=0; i<mass.length; i++)
            System.out.print(mass[i] + "|");
    }
    public static void replaceOnZero(int[] mass)
    {
        int choose;
        Scanner in = new Scanner(System.in);
        System.out.println("Выбор операций с массивом: 1 - замена нулями отрицательных эл-тов | 2 - замена нулями всех эл-тов, больших заданного | 3 - замена нулями всех эл-тов между n1 и n2");
        choose = in.nextInt();
        switch (choose){
            case 1:
                for (int i=0; i<mass.length; i++){
                    if(mass[i] < 0)
                        mass[i] = 0;
                    System.out.print(mass[i] + "|");
                }
                break;
            case 2:
                int n;
                System.out.println("Введите число: ");
                n = in.nextInt();
                for (int i=0; i<mass.length; i++)
                {
                    if(mass[i] > n)
                        mass[i] = 0;
                    System.out.print(mass[i] + "|");
                }
                break;
            case 3:
                int n1, n2;
                while(true) {
                    System.out.println("Введите интервал (не менее 0 и не более 10)");
                    n1 = in.nextInt();
                    n2 = in.nextInt();
                    if(n1 < n2)
                        break;
                }
                for (int i=n1; i<n2; i++){
                    mass[i] = 0;
                }
                for (int i=0; i<mass.length; i++)
                    System.out.print(mass[i] + "|");
                break;
        }
    }
}



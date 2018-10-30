package com.company;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        /*
        KreisVererb kreis = new KreisVererb(1, 1, 3);
        System.out.println("The circle initiated with x,y=1 & r=3. Current Circle: " + kreis.toString());
        kreis.setRadius(5);
        System.out.println("Increased the radius to 5. Current Radius: " + kreis.getRadius());
        */

        /*
        KreisAgg k = new KreisAgg(1, 1, 5);
        System.out.println(k.toString() + ", V: " + k.flaechenInhalt());

        Rechteck r = new Rechteck(1, 1, 3, 5);
        System.out.println(r.toString() + ", V: " + r.flaechenInhalt());*/


        IArea[] areas = new IArea[3];
        areas[0] = new Rechteck(1, 1, 3, 5);
        areas[1] = new KreisAgg(1, 1, 6);
        areas[2] = new Rechteck(1, 1, 2, 2);
        for (int i = 0; i < 3; i++)
        {
            System.out.println(areas[i].toString() + ", V: " + areas[i].flaechenInhalt());
        }
        //pascalschesDreieck();
    }

    //Prints pascal's triangle
    public static void pascalschesDreieck()
    {
        System.out.print("Insert the height: ");
        // read the height
        Scanner scan = new Scanner(System.in);
        final int height = scan.nextInt();

        // Erzeugung eines 1-dim. Feldes mit null-Zeigern
        int[][] dreieck = new int[height][];

        for (int i = 0; i < dreieck.length; i++) {
            // Erzeugung der i-ten Zeile der Länge i
            dreieck[i] = new int[i+1];
            // Belegung der Felder und Ausgabe
            for(int j = 0; j < i+1; j++) {
                //Berechnung der Zahl
                int cur = 0;
                //if we have a line above
                if (i > 0)
                {
                    //if the one above exists -> add
                    if (j < dreieck[i-1].length)
                        cur += dreieck[i-1][j];

                    //if the one above left exists -> add
                    if (j - 1 >= 0)
                        cur += dreieck[i-1][j-1];
                }
                else //else set to 1
                {
                    cur = 1;
                }
                dreieck[i][j] = cur;

                System.out.print(dreieck[i][j]);
                if (j < i)
                    System.out.print(" ");
            }
            // Zeilenumbruch
            System.out.println();
        }
    }
}
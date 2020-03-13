package com.company;

public class Main {

            int i ;
            int j ;
            static int row;
            static int col;
            public void wall() {
                for (i = 1; i < 16; i++) {
                    for (j = 0; j <= 24; j++) {
                        if (j == 0 || j == 24)
                            System.out.print("|");
                        else
                            System.out.print(" ");
                    }
                    System.out.println();
                }
                for (j = 1; j <= 24; j++)
                    System.out.print("-");
            }

            public static void cell1(int i ,int j){
            int row = i;
            int col = j;
            System.out.print("*");
            }


             public static void cell2(int i ,int j){
             int row = i;
             int col = j;
             System.out.print("*");

             }
    public static void cell3(int i ,int j){
        int row = i;
        int col = j;
        System.out.print("*");

    }

    public static void cell4(int i ,int j){
        int row = i;
        int col = j;
        System.out.print("*");

    }






    public static void main(String[] args) {
                int i ;
                int j ;

                Main t2 = new Main();
                cell1(2,4);
                cell2(2,5);
                cell2(3,4);
                cell2(3,5);
                t2.wall();



            }




    }


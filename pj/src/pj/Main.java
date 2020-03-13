package pj;

//import


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
不排除存在bug的可能
只是我暂时没有发现
输入指令的大小写很重要

 */

public class Main {
    private static game a;
    private static game b;
    private static int [][][]type=new int[4][4][4];
    private static int[][]map1=new int[20][30];


    public static void main(String[] args) {



        System.out.printf("------------------------------------------------------------\n"
                + "|                                                          |\n"
                + "|   -------    -----   -------    -----    ---    ----     |\n"
                + "|      |      |           |      |     :    |    |         |\n"
                + "|      |      |-----      |      |-----     |     ----     |\n"
                + "|      |      |           |      |    \\     |         |    |\n"
                + "|      |       -----      |      |     \\   ---    ----     |\n"
                + "|                                                          |\n"
                + "| ---------------------------------------------------------|\n"
                + "|                                                          |\n"
                + "|                >> input  S  to start                     |\n"
                + "|                >> input  N  to quit                      |\n"
                + "|                >> input  R  to check the list            |\n"
                + "|                >> input  Z  to save                      |\n"
                + "|                >> input  B  to load game                 |\n"
                + "|                >> input  H  to get help                  |\n"
                + "|                                                          |\n"
                + "|                                                          |\n"
                + "------------------------------------------------------------\n");
        //打印主界面



        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 30; j++) {
                a.getMap1()[i][j] = 0;
            }
        }




        while (a.getCmd() != 'N') {
            switch (a.cmd){
                case 'r':
                case 'R':  {
                    java.io.File file=new java.io.File("pj\\stores.txt");
                    try{
                        if(!file.exists()){
                            file.getParentFile().mkdir();
                            file.createNewFile();
                        }
                        int i =0;

                        Scanner input = new Scanner(file);
                        while (input.hasNext()&&i<6){
                            String b = input.next();
                            System.out.println(i+1+": "+b);
                            i++;


                        }
                        input.close();

                    }catch (FileNotFoundException e){
                        e.printStackTrace();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
                break;
                //打印排行榜
                case 'h':
                case 'H':  System.out.println("请戳客服qq：1229519046");
                    break;
                case 'B':{
                    a=new game();
                    java.io.File file=new java.io.File("pj\\GAME.txt");
                    try {
                        if (!file.exists()) {
                            file.getParentFile().mkdir();
                            file.createNewFile();
                        }
                        Scanner input = new Scanner(file);


                        if (input.hasNextInt()) {
                            a.setX(input.nextInt());
                            a.setY(input.nextInt());
                            a.setState(input.nextInt());
                            a.setScore(input.nextInt());
                            for (int q = 0; q < 20; q++) {
                                for (int p = 0; p < 30; p++) {
                                    map1[q][p] = input.nextInt();
                                }
                            }
                            a.setMap1(map1);

                            for (int i = 0; i < 4; i++) {
                                for (int j = 0; j < 4; j++) {
                                    for (int k = 0; k < 4; k++) {
                                        type[i][j][k] = input.nextInt();
                                    }
                                }
                            }
                            a.setType1(type);
                        }
                        input.close();

                    }catch (FileNotFoundException e){
                        e.printStackTrace();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    a.printmap();
                }
                break;
                //读档
                case 'Y':
                case 'S':
                    b=new game();
                   // a=new game();
                    a=b;
                    a.printmap();
                    break;
                //开始新游戏
                case 'Z':{
                java.io.File file=new java.io.File("pj\\GAME.txt");
                try{
                    if(!file.exists()){
                        file.getParentFile().mkdir();
                        file.createNewFile();
                    }
                    PrintWriter out =new PrintWriter(file);
                    out.println(a.getX());
                    out.println(a.getY());
                    out.println(a.getState());
                    out.println(a.getScore());
                    for (int q = 0; q < 20; q++) {
                        for (int p = 0; p < 30; p++) {
                            map1[q][p] = a.getMap1()[q][p];
                            out.println(map1[q][p]);

                        }
                    }
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            for (int k = 0; k < 4; k++) {
                                type[i][j][k] = a.getType1()[i][j][k];
                                out.println(type[i][j][k]);
                            }
                        }
                    }
                    out.close();

                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
                System.out.println("存档成功！");
            }
            break;
            //存档
            default:
                break;
            }

            switch (a.cmd){
                case 's':
                case 'x':
                case 'w':
                case 'a':
                case 'd':
                    a.move(a.cmd);
                    a.clean();
                    a.printmap();
                    a.out();
                    break;
            }
            //基本操作指令
        }

    }
}

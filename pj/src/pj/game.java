package pj;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.Serializable;

public class game {

    static block now = new block() ;
    private  static block next ;
    private static  int[]arr;

    public game(){
        newBlock(now ,6,0);
    }

    //打印界面
    public static void printmap(){

        int[][]map;
        map=getmap(y,x);
        int[][]temp=new int[30][30];
        int tempY=y;


        for ( int i = 1 ; i <= Height ; i ++){
            for( int  j = 2 ; j <= Width ; j ++ ){
                if( map[i][j] != 1 )
                    map[i][j] = map1[i][j];
                temp[i][j]=map[i][j];
            }
        }


        while (valid2(tempY,x))
            tempY++;
        {
            while ((!valid2(tempY +1, x))) {

                for (int i = 1; i <= Height; i++) {
                    for (int j = 2; j <= Width; j++) {
                        if (getmap(tempY-1, x)[i][j] == 1&&temp[i][j]!=1) {
                            temp[i][j] = 2;
                        }
                    }
                }
                break;
            }
        }


        for (int i = 1; i <= Height; i++) {
            for (int j = 2; j <= Width; j++) {
                map[i][j]=temp[i][j];
            }
        }


        for( int i = 1 ; i <= Height ; i ++ ){
            System.out.print(" ");
            System.out.print(":");
            for(int j = 2 ; j <= Width ; j ++ ){
                switch (map[i][j]){
                    case 0:System.out.print(" ");
                    break;
                    case 1:System.out.print("*");
                    break;
                    case 2:System.out.print("+");
                }
            }
            System.out.print(":");
            System.out.println();
        }
        System.out.print(" ");

        for (int j = 1;j <= Width +1  ; j ++){
            System.out.print("—");
        }
        System.out.println();

        System.out.println();
        System.out.println("next block is:");
        for(int a=0;a<=3;a++){
            for (int b = 0;b<=3;b++){
                switch (next.type[0][a][b]){
                    case 0:System.out.print(" ");
                        break;
                    case 1:System.out.print("*");
                        break;
                    case 2:System.out.print("+");
                }
            }
            System.out.println();
        }
        System.out.println("score:" + getScore()+"\n");

        System.out.println("\nplease enter\n(a for left ,d for right)\n(s for under,w for turn)\n(x for down fast,"+
                "N for quit)\n(S for replay,Z for save)");


    }

    public static int getScore(){
        return score;
    }

    public static int[][] getMap1(){
        return map1;
    }



    public static int[][] getmap(int y , int x){
        int[][]map=new int[30][30];
        int i,j;

        for ( i = 1 ; i <= Height ; i ++ ){
            for( j = 2 ; j <= Width+1 ; j ++ ){
                if(j == x && i == y)
                    map[i][j]=block[0][0];
                else if (j == x + 1 && i == y)
                    map[i][j]=block[0][1];
                else if (j == x + 2 && i == y)
                    map[i][j]=block[0][2];
                else if (j == x + 3 && i == y)
                    map[i][j]=block[0][3];
                else if(j == x && i == y + 1 )
                    map[i][j]=block[1][0];
                else if (j == x + 1 && i == y + 1 )
                    map[i][j]=block[1][1];
                else if (j == x + 2 && i == y + 1 )
                    map[i][j]=block[1][2];
                else if (j == x + 3 && i == y + 1 )
                    map[i][j]=block[1][3];
                else if(j == x && i == y + 2)
                    map[i][j]=block[2][0];
                else if (j == x + 1 &&i == y + 2)
                    map[i][j]=block[2][1];
                else if (j == x + 2 && i == y + 2)
                    map[i][j]=block[2][2];
                else if (j == x + 3 && i == y + 2)
                    map[i][j]=block[2][3];
                else if(j == x && i == y + 3)
                    map[i][j]=block[3][0];
                else if (j == x + 1 &&i == y + 3)
                    map[i][j]=block[3][1];
                else if (j == x + 2 && i == y + 3)
                    map[i][j]=block[3][2];
                else if (j == x + 3 && i == y + 3)
                    map[i][j]=block[3][3];
                else
                    map[i][j]=0;
            }
        }
        return map;
    }


    public static void holdBlock(){


        for(int i = 0 ; i < 4 ; i ++){
            if(map1[y][x+i] != 1)
                map1[y][x+i] = block[0][i];
        }

        for(int i = 0 ; i < 4 ; i ++){
            if(map1[y+1][x+i] != 1)
                map1[y+1][x+i] = block[1][i];
        }

        for(int i = 0 ; i < 4 ; i ++){
            if(map1[y+2][x+i] != 1)
                map1[y+2][x+i] = block[2][i];
        }
        for(int i = 0 ; i < 4 ; i ++){
            if(map1[y+3][x+i] != 1)
                map1[y+3][x+i] = block[3][i];
        }


        now=next;
        new game();


    }

    public void newBlock(block z,int x,int y){
        this.x = x ;
        this.y = y ;
        state = 1 ;
        type1 =z.type;
        block=type1[0];
        next = new block();

    }


    private static int[][] block=new int[4][4];
    private static int[][][]type1=new int[4][4][4];
    private static int[][]map1 = new int[30][30];
    private static int Height = 15;
    private static int Width = 16;
    private static int state  ;
    static char cmd;
    private static int x ;
    private static int y ;
    private static Scanner input = new Scanner( System.in );
    private static int score;
    private static ArrayList<Integer> stores = new ArrayList<>();


    //实现旋转
    public static int turn(int state){

        switch (state){
            case 1: block = type1[0];

                break;
            case 2: block = type1[1];

                break;
            case 3: block = type1[2];

                break;
            case 4: block = type1[3];
                break;
        }
        return state;
    }



    //获取命令
    public static int getCmd(){
        cmd = input.next().charAt(0);
        return cmd;
    }

    public static int getX(){
        return x;
    }

    public void setX(int x){
        this.x=x;
    }

    public static int getY(){
        return y;
    }

    public void setY(int y){
        this.y=y;
    }

    public static int getState(){
        return state;
    }

    public void setState(int state){
        this.state=state;
    }

    public void setScore(int score){
        this.score=score;
    }

    public static int[][][] getType1(){
        return type1;
    }

    public void setType1(int[][][]type1){
        this.type1=type1;
    }

    public void setMap1(int[][]map1){
        this.map1=map1;
    }





    //结束游戏
    public static void out() {
        for (int j = 0; j <= 16; j ++) {

            if (map1[1][j] == 1) {
                System.out.println( "game over!\n"+"your final score is"+" "+score );
                stores.add(score);
                java.io.File file=new java.io.File("pj\\stores.txt");
                try{

                    if(!file.exists()){
                        file.getParentFile().mkdir();
                        file.createNewFile();
                    }
                    Scanner input = new Scanner(file);
                    while (input.hasNextInt()){
                        int b = input.nextInt();
                        stores.add(b);

                    }
                    input.close();

                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
                arr =new int[stores.size()];

                for(int i=0;i<stores.size();i++){
                    arr[i]=stores.get(i);}
                Arrays.sort(arr);
                int []arr1=new int[arr.length];

                for(int b =0;b<arr1.length;b++){
                    arr1[arr.length-1-b]=arr[b];
                }

                java.io.File file1 = new java.io.File("pj\\stores.txt");
                try{

                    if(!file1.exists()){
                        file1.getParentFile().mkdir();
                        file1.createNewFile();
                    }
                    PrintWriter out =new PrintWriter(file);

                    for(int i = 0 ;i < arr1.length;i++){
                        int a = arr1[i];
                        out.println(a);}
                    out.close();

                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
                System.out.println("START A NEW GAME?\n"+"PLEASE INPUT Y OR N");
            }
        }
    }


    //消行
    public static void clean(){
        int a ;
        int c = 0;

        for ( int i = 1 ; i <= Height ; i ++){
            a=0;

            for( int j = 2; j <= Width ; j ++){
                if( map1[i][j] == 1){
                    a ++;
                }

                if(a==15) {
                    c=c+1;
                    for (int b = i; b >= 1; b--) {
                        map1[b] = map1[b - 1];
                    }
                    for (j = 2; j <= Width; j++) {
                        map1[1][j] = 0;
                    }
                }
            }
        }
        score+=Math.pow((int)2,(int)c-1)*c*10;
    }



    public static boolean valid0(int y1 , int x1) {
        int[][] map;
        map = getmap(y,x);
        boolean valid0 = true;

        for (int j = 0; j <= 15; j++) {

            if (map[j][2] == 1) {
                valid0 = false;
            }
        }

        if (x1 >= 0) {

            if (    (getmap(y1, x1)[y1 ][x1] == 1 && map1[y1 ][x1] == 1) ||
                    (getmap(y1, x1)[y1 + 1][x1] == 1 && map1[y1 + 1][x1] == 1) ||
                    (getmap(y1, x1)[y1 + 2][x1] == 1 && map1[y1 + 2][x1] == 1) ||
                    (getmap(y1, x1)[y1 + 3][x1] == 1 && map1[y1 + 3][x1] == 1)  ) {
                valid0 = false;
            }

            else if (   (getmap(y1, x1 )[y1][x1 + 1] == 1 && map1[y1 ][x1 + 1] == 1) ||
                    (getmap(y1, x1 )[y1 + 1][x1 + 1] == 1 && map1[y1 + 1][x1 + 1] == 1) ||
                    (getmap(y1, x1 )[y1 + 2][x1 + 1] == 1 && map1[y1 + 2][x1 + 1] == 1)||
                    (getmap(y1, x1 )[y1 + 3][x1 + 1] == 1 && map1[y1 + 3][x1 + 1] == 1)) {
                valid0 = false;
            }


            else if (   (getmap(y1, x1 )[y1][x1 + 2] == 1 && map1[y1 ][x1 + 2] == 1) ||
                    (getmap(y1, x1 )[y1 + 1][x1 + 2] == 1 && map1[y1 + 1][x1 + 2] == 1) ||
                    (getmap(y1, x1 )[y1 + 2][x1 + 2] == 1 && map1[y1 + 2][x1 + 2] == 1)||
                    (getmap(y1, x1 )[y1 + 3][x1 + 2] == 1 && map1[y1 + 3][x1 + 2] == 1)) {
                valid0 = false;
            }
        }
        return valid0;

    }


    public static boolean valid1(int y1 , int x1) {
        int[][] map ;
        map = getmap(y,x);
        boolean valid1 = true;

        for (int j = 1 ; j <= 15; j ++) {

            if (map[j][16] == 1) {
                valid1 = false;
            }

        }

        if(x1>0) {

            if (    (getmap(y1, x1)[y1 ][x1 + 2] == 1 && map1[y1 ][x1 + 2] == 1) ||
                    (getmap(y1, x1)[y1 + 1][x1 + 2] == 1 && map1[y1 + 1][x1 + 2] == 1) ||
                    (getmap(y1, x1)[y1 + 2][x1 + 2] == 1 && map1[y1 + 2][x1 + 2] == 1)||
                    (getmap(y1, x1)[y1 + 3][x1 + 2] == 1 && map1[y1 + 3][x1 + 2] == 1)) {
                valid1 = false;
            }

            else if (   (getmap(y1, x1)[y1][x1 + 1] == 1 && map1[y1][x1 + 1] == 1) ||
                    (getmap(y1, x1)[y1 + 1][x1 + 1] == 1 && map1[y1 + 1][x1 + 1] == 1) ||
                    (getmap(y1, x1)[y1 + 2][x1 + 1] == 1 && map1[y1 + 2][x1 + 1] == 1)||
                    (getmap(y1, x1)[y1 + 3][x1 + 1] == 1 && map1[y1 + 3][x1 + 1] == 1)) {
                valid1 = false;
            }

            else if (   (getmap(y1, x1)[y1][x1 + 3] == 1 && map1[y1][x1 + 3] == 1) ||
                    (getmap(y1, x1)[y1 + 1][x1 + 3] == 1 && map1[y1 + 1][x1 + 3] == 1) ||
                    (getmap(y1, x1)[y1 + 2][x1 + 3] == 1 && map1[y1 + 2][x1 + 3] == 1)||
                    (getmap(y1, x1)[y1 + 3][x1 + 3] == 1 && map1[y1 + 3][x1 + 3] == 1)) {
                valid1 = false;
            }
        }
        return valid1;
    }


    public static boolean valid2(int y1 , int x1) {
        boolean valid2=true;

        for(int a = 0 ; a < Width+1; a ++) {
            if (getmap(y1-1, x)[Height][a] == 1) {
                valid2 = false;
                break;
            }
        }

        if (x1 > -1) {

            if ((getmap(y1, x1)[y1 + 2][x1] == 1 && map1[y1 + 2][x1] == 1) ||
                    (getmap(y1, x1)[y1 + 2][x1 + 1] == 1 && map1[y1 + 2][x1 + 1] == 1) ||
                    (getmap(y1, x1)[y1 + 2][x1 + 2] == 1 && map1[y1 + 2][x1 + 2] == 1) ||
                    (getmap(y1, x1)[y1 + 2][x1 + 3] == 1 && map1[y1 + 2][x1 + 3] == 1)) {

                valid2 = false;

            } else if ((getmap(y1 - 1, x1)[y][x1] == 1 && map1[y1][x1] == 1) ||
                    (getmap(y1 - 1, x1)[y][x1 + 1] == 1 && map1[y1][x1 + 1] == 1) ||
                    (getmap(y1 - 1, x1)[y][x1 + 2] == 1 && map1[y1][x1 + 2] == 1) ||
                    (getmap(y1 - 1, x1)[y][x1 + 3] == 1 && map1[y1][x1 + 3] == 1)) {

                valid2 = false;

            } else if ((getmap(y1, x1)[y1 + 1][x1] == 1 && map1[y1 + 1][x1] == 1) ||
                    (getmap(y1, x1)[y1 + 1][x1 + 1] == 1 && map1[y1 + 1][x1 + 1] == 1) ||
                    (getmap(y1, x1)[y1 + 1][x1 + 2] == 1 && map1[y1 + 1][x1 + 2] == 1) ||
                    (getmap(y1, x1)[y1 + 1][x1 + 3] == 1 && map1[y1 + 1][x1 + 3] == 1)) {
                valid2 = false;
            } else if ((getmap(y1, x1)[y1 + 3][x1] == 1 && map1[y1 + 3][x1] == 1) ||
                    (getmap(y1, x1)[y1 + 3][x1 + 1] == 1 && map1[y1 + 3][x1 + 1] == 1) ||
                    (getmap(y1, x1)[y1 + 3][x1 + 2] == 1 && map1[y1 + 3][x1 + 2] == 1) ||
                    (getmap(y1, x1)[y1 + 3][x1 + 3] == 1 && map1[y1 + 3][x1 + 3] == 1)) {
                valid2 = false;
            }
        }




        return valid2;
    }


    public static boolean valid3() {

        //  int[][] map;
        // map = getmap(y, x);

        boolean valid3 = true;



        int temp = state;
        state= state % 4 + 1;
        turn(state);
        if(valid0(y,x)==false||valid1(y,x)==false||valid2(y,x)==false){
            state=temp;
            turn(temp);
            valid3=false;}
        else
            valid3=true;


        return valid3;
    }



    //移动
    public  void move(int ch){
        switch (ch){
            case 'a':if (valid0(y,x-1)){
                x--;
            }
                break;
            case 'd':if (valid1(y,x+1)){
                x++;
            }
                break;
            case 's':if (valid2(y+1,x)){
                y++;
            }
            else holdBlock();
                break;
            case 'w':{
                if (valid3()){
                    turn(state);
                }
                break;
            }
            case 'x':while(valid2(y+1,x)){
                y++;
            }
                break;
            case'q':{
                y=y+8;
                break;
            }
        }
    }

}



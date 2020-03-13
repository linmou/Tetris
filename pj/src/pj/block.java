package pj;
/*
用于存储方块的状态
 */

public class block {

    public block(){
        type=getType();
    }


    public static int[][][] type;

    public  int[][][]getType(){
        int number =getnumber();
        switch (number){
            case 1:this.type=getTypez1();
                break;
            case 2:this.type=getTypeo();
                break;
            case 3:this.type=getTypel1();
                break;
            case 4:this.type=getTypet();
                break;
            case 5:this.type=getTypeI();
                break;
            case 6:this.type=getTypez2();
                break;
            case 7:this.type=getTypel2();
                break;

        }
        return type;
    }



    public static int[][][] getTypez1(){

        int[][] blockz1 = { {0,1,1,0},
                {0,0,1,1},
                {0,0,0,0},
                {0,0,0,0}};
        int[][] blockz2 = { {0,0,1*1,0},
                {0,1,1,0},
                {0,1,0,0},
                {0,0,0,0}};
        int[][] blockz3 = { {0,0,0,0},
                {0,1,1,0},
                {0,0,1,1},
                {0,0,0,0}};
        int[][] blockz4 = {  {0,0,1,0},
                {0,1,1,0},
                {0,1,0,0},
                {0,0,0,0}};

        int[][][]typez1 = {blockz1,blockz2,blockz3,blockz4};
        return typez1;
    }

    public static int[][][] getTypez2(){

        int[][] blockz1 = { {0,0,1,1},
                {0,1,1,0},
                {0,0,0,0},
                {0,0,0,0}};
        int[][] blockz2 = { {0,0,1,0},
                {0,0,1,1},
                {0,0,0,1},
                {0,0,0,0}};
        int[][] blockz3 = { {0,0,0,0},
                {0,0,1,1},
                {0,1,1,0},
                {0,0,0,0}};
        int[][] blockz4 = { {0,1,0,0},
                {0,1,1,0},
                {0,0,1,0},
                {0,0,0,0}};

        int[][][]typez2 = {blockz1,blockz2,blockz3,blockz4};
        return typez2;
    }

    private static int[][][] getTypeo(){


        int[][] blocko1 = { {0,1,1,0},
                {0,1,1,0},
                {0,0,0,0},
                {0,0,0,0}};
        int[][] blocko2 =blocko1;
        int[][] blocko3 = blocko1;
        int[][] blocko4 =blocko1;

        int[][][]typeo = {blocko1,blocko2,blocko3,blocko4};
        return typeo;
    }


    private static int[][][] getTypel1(){

        int[][] blockl11 = { {0,1,0,0},
                {0,1,0,0},
                {0,1,1,0},
                {0,0,0,0} };
        int[][] blockl12 = { {0,0,0,0},
                {0,0,1,0},
                {1,1,1,0},
                {0,0,0,0} };
        int[][] blockl13 = { {0,1,1,0},
                {0,0,1,0},
                {0,0,1,0},
                {0,0,0,0} };
        int[][] blockl14 = { {0,1,1,1},
                {0,1,0,0},
                {0,0,0,0},
                {0,0,0,0} };

        int[][][]typel1 = {blockl11,blockl12,blockl13,blockl14};
        return typel1;
    }

    private static int[][][] getTypel2(){

        int[][] blockl21 = { {0,0,1,0},
                {0,0,1,0},
                {0,1,1,0},
                {0,0,0,0} };
        int[][] blockl22 = { {0,0,0,0},
                {0,1,1,1},
                {0,0,0,1},
                {0,0,0,0} };
        int[][] blockl23 = { {0,0,1,1},
                {0,0,1,0},
                {0,0,1,0},
                {0,0,0,0} };
        int[][] blockl24 = { {0,1,0,0},
                {0,1,1,1},
                {0,0,0,0},
                {0,0,0,0} };

        int[][][]typel2 = {blockl21,blockl22,blockl23,blockl24};
        return typel2;
    }

    private static int[][][] getTypet(){

        int[][] blockt1 = { {0,0,1,0},
                {0,1,1,1},
                {0,0,0,0},
                {0,0,0,0} };
        int[][] blockt2 = { {0,0,1,0},
                {0,0,1,1},
                {0,0,1,0},
                {0,0,0,0} };
        int[][] blockt3 = { {0,0,0,0},
                {0,1,1,1},
                {0,0,1,0},
                {0,0,0,0} };
        int[][] blockt4 = { {0,0,1,0},
                {0,1,1,0},
                {0,0,1,0},
                {0,0,0,0} };

        int[][][]typet = {blockt1,blockt2,blockt3,blockt4};
        return typet;
    }

    public static int[][][] getTypeI(){

        int[][] blockI1 = { {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0} };
        int[][] blockI2 = { {0,0,0,0},
                {1,1,1,1},
                {0,0,0,0},
                {0,0,0,0} };
        int[][] blockI3 = { {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0} };
        int[][] blockI4 = { {0,0,0,0},
                {1,1,1,1},
                {0,0,0,0},
                {0,0,0,0} };

        int[][][]typez = {blockI1,blockI2,blockI3,blockI4};
        return typez;
    }



    public static int getnumber(){
        int number =(int)(Math.random()*8);
        return number;
    }






}





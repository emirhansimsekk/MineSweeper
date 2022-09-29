/**
 * LAB 05 -- MINESWEEPER  (MAYIN TARLASI)
 *
 * This program generates a minesweeper board
 *
 * @author Emirhan Simsek
 *
 * @class BIL 122
 *
 * @date 23.04.2021   16.36
 *
 **/

import java.util.Random;


public class Minesweeper {

    boolean[][] mineField; // board with mines marked as true
    int rows; // number of rows of the board
    int cols; // number of columns of the board
    int numMines;
    int[][] clues;

    /*
     * Class Constructor
     *
     * @param int rows Number of rows of the board
     *
     * @param int cols Number of columns of the board
     *
     * @param int numMines Number of mines to be placed on the board
     *
     */
    Minesweeper(int rows, int cols, int numMines)
    {
        //TODO
        this.rows=rows;
        this.cols=cols;
        this.numMines=numMines;
        this.mineField=new boolean[rows][cols];
        this.clues=new int[rows][cols];
        generateBoard();
    }






    /*
     * Generates the mineField
     *
     * @param int numMines Number of mines to be placed on the mineField
     *
     * @return boolean[][] Game board with mines placed at random position
     */
    public void generateBoard()
    {
        //TODO
        Random r=new Random();

        int i,j;

        for(i=numMines;i>0;i--) //tum mayinlari yerlestirene kadar doner
        {
            int x=r.nextInt(rows); //mayinlarin konulacagi konumun rastgele olmasi icin. Konumun apsis degeri
            int y=r.nextInt(cols); //mayinlarin konulacagi konumun rastgele olmasi icin. Konumun ordinat degeri

            while(mineField[x][y]==true) //eger gelen konumda mayin varsa donguye girer ve maiyn olamayan yeri bulana kadar rastgele konum olusturur
            {
                x=r.nextInt(rows);
                y=r.nextInt(cols);
            }
            if(mineField[x][y]==false) //eger gelen konumda mayin yoksa o konuma mayini yerlestirir
            {
                mineField[x][y]=true;
            }
        }


    }
    /*
     * Creates the game
     *
     * @return int[][] The board with cell values computed
     */
    public int[][] generateClues()
    {
        int i,j;
        int[][] clues=new int[rows][cols];

        for(i=0;i<rows;i++)   //dizide dolanmak icin
        {
            for(j=0;j<cols;j++)//dizide dolanmak icin 
            {
                if(mineField[i][j]==true) //eger hucrede mayin varsa o hucrenin degerini -1 yapar
                {
                    clues[i][j]=-1;
                }
                else   //hucrede mayin yoksa o hucrenin komsularindaki mayin sayisini hucrenin degeri yapar
                {
                    clues[i][j]=countMines(i,j);
                }
            }
        }


        return clues;
    }

    /*
     * counts the number of adjacent mines to a given cell position
     *
     * @param int r row position
     *
     * @param int c column position
     *
     * @return int number of mines in the surrounding cells
     */
    public int countMines(int r, int c) {
        int count = 0;


        // if'lerin icindeki gelen konumun sinirlardan tasmamasi icin kontroller bulunmaktadir. 

        if((r-1)>0&&(c-1)>0&&(r-1)<rows&&(c-1)<cols&&mineField[r-1][c-1]==true)  //eger sol ust komsusunda mayin varsa count 1 artar 
        {
            count++;
        }
        if((r-1)>0&&(c)>0&&(r-1)<rows&&(c)<cols&&mineField[r-1][c]==true)  //eger ust komsusunda mayin varsa count 1 artar
        {
            count++;
        }
        if((r-1)>0&&(c+1)>0&&(r-1)<rows&&(c+1)<cols&&mineField[r-1][c+1]==true) //eger sag ust komsusunda mayin varsa count 1 artar
        {
            count++;
        }
        if((r)>0&&(c-1)>0&&(r)<rows&&(c-1)<cols&&mineField[r][c-1]==true)  //eger sol komsusunda mayin varsa count 1 artar 
        {
            count++;
        }
        if((r)>0&&(c+1)>0&&(r)<rows&&(c+1)<cols&&mineField[r][c+1]==true)  //eger sag komsusunda mayin varsa count 1 artar
        {
            count++;
        }
        if((r+1)>0&&(c-1)>0&&(r+1)<rows&&(c-1)<cols&&mineField[r+1][c-1]==true)  //eger sol alt komsusunda mayin varsa count 1 artar
        {
            count++;
        }
        if((r+1)>0&&(c)>0&&(r+1)<rows&&(c)<cols&&mineField[r+1][c]==true)  //eger alt komsusunda mayin varsa count 1 artar
        {
            count++;
        }
        if((r+1)>0&&(c+1)>0&&(r+1)<rows&&(c+1)<cols&&mineField[r+1][c+1]==true)  //eger sag alt komsusunda mayin varsa count 1 artar
        {
            count++;
        }


        return count;  //Son count degerini dondurur. Bu deger hucrenin komsularindaki toplam mayin sayisini gosterir
    }

    /*
     * prints the game mine is represented by *
     *
     * @param int[][] game The game board
     */
    public static void printClues(int[][] clues) {
        //TODO

    }



    public static void main(String[] args) {
        Minesweeper ms= new Minesweeper(4,4,10);
        // System.out.println(ms.generateClues());

    }

}
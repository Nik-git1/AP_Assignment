package Assignment_3;


import java.util.ArrayList;

public class MATRIX {
    int rows;
    int columns;
    int[][] matrix;
    static int count=0;
    int id;
    ArrayList<String> typelist;
    int size=0;

    public MATRIX( int[][] matrix, int rows, int columns) {
        this.matrix= new int[rows][columns];
        id=count;
        count++;
        this.matrix=matrix;
    }

    public MATRIX( int[][] matrix, int size) {
        this.matrix= new int[size][size];
        id=count;
        count++;
        this.matrix=matrix;
    }
    void display(){};

    public void getType() {
        for (int i=0;i<typelist.size();i++){
            System.out.println(typelist.get(i));
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void transpose() {
        if (size!=0) {
            int[][] transpose = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    transpose[j][i] = matrix[i][j];
                }
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.println( transpose[j][i]);
                }
            }


        }else
            System.out.println("cant perform on non square matrix");

    }
    public void addtranspose() {
        if (size!=0) {
            int[][] transpose = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    transpose[j][i] = matrix[i][j];
                }
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.println( transpose[i][j]+matrix[i][j]);
                }
            }

        }else
            System.out.println("cant perform on non square matrix");

    }





}

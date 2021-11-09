package Assignment_3;


import java.util.ArrayList;
import java.util.Random;

public class MATRIX {
    int rows;
    int columns;
    int[][] matrix;
    int[] diag;
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

    public MATRIX(int size, int[] matrix ){//for diagonal
        this.diag= new int[size];
        id=count;
        count++;
        this.diag=diag;
    }

    void display(){};
    void diag_display(){};

    public void getType() {
        for (int i=0;i<typelist.size();i++){
            System.out.println(typelist.get(i));
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getRows() {
        if (size!=0){
            rows=size;
        }
        return rows;
    }

    public int getColumns() {
        if (size!=0){
            columns=size;
        }
        return columns;
    }

    public int getSize() {
        return size;
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

    public String getTypelist() {
        return typelist.get(0);
    }

    public void setMatrix() {
        if (size != 0) {
            rows = size;
            columns = size;
        }
        ArrayList<String> forbidden = new ArrayList<String>();
        forbidden.add("Null");
        forbidden.add("Ones");
        forbidden.add("Identity");
        int flag = 1;
        for (int i = 0; i < forbidden.size(); i++) {
            if (typelist.contains(forbidden.get(i))) {
                flag = -1;
                System.out.println("Cant manipulate");
                break;
            }
            else if (typelist.contains("Diagonal matrix")) {
                flag = 2; }
        }

        if (typelist.contains("Singular Matrix")){
            for (int i=0;i<rows;i++){
                matrix[0][i]=0;
            }
        }
        if (flag == 2) {
            for (int i = 0; i < rows; i++) {
                diag[i]++;
            }
        }
        if (flag == 1) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (matrix[i][j] != 0) {
                        matrix[i][j]++;
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println(matrix[i][j]);
            }
        }

    }
}



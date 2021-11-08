package Assignment_3;


public class MATRIX {
    int rows;
    int columns;
    int[][] matrix;
    static int id;
    String type;
    int size;

    public MATRIX(int id, int[][] matrix, int rows, int columns) {
        this.matrix= new int[rows][columns];
        id++;
        this.id = id;
        this.matrix=matrix;
    }

    public MATRIX(int id, int[][] matrix, int size) {
        this.matrix= new int[size][size];
        id++;
        this.id = id;
        this.matrix=matrix;
    }


    void display() {
    }
}

package Assignment_4_q2;

public class rgb {
    int row;
    int col;
    static int count=0;
    Double[][][] matrix;
    int id;

    public rgb(int row, int col, Double[][][] matrix) {
        this.row = row;
        this.col = col;
        this.matrix = matrix;
        id = count;
        count++;
    }

    public Double[][][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Double[][][] matrix) {
        this.matrix = matrix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}

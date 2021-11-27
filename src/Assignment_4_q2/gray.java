package Assignment_4_q2;

public class  gray {
    int row;
    int col;
    static int count=0;
    Integer[][][] matrix;
    int id;

    public gray(int row, int col, Integer[][][] matrix) {
        this.row = row;
        this.col = col;
        this.matrix = matrix;
        id = count;
        count++;
    }

    public Integer[][][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Integer[][][] matrix) {
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

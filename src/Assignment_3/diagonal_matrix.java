package Assignment_3;

public class diagonal_matrix extends square{
    String type="Diagonal matrix";
    String type1 = "Symmetric";
    public diagonal_matrix(int[][] matrix, int size) {
        super(matrix, size);
        this.size=size;
        this.matrix=matrix;
        typelist.add(type);
    }
}

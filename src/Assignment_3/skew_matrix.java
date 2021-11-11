package Assignment_3;

public class skew_matrix extends square{
    private String type = "Skew Symmetric matrix";
    public skew_matrix(int[][] matrix, int size) {
        super(matrix, size);
        this.matrix=matrix;
        this.size=size;
        typelist.add(type);
    }
}

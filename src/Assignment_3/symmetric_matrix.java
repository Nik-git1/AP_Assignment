package Assignment_3;

public class symmetric_matrix extends square {
    private String type = "Symmetric matrix";

    public symmetric_matrix(int[][] matrix, int size) {
        super(matrix, size);
        this.matrix=matrix;
        this.size=size;
        typelist.add(type);
    }

}

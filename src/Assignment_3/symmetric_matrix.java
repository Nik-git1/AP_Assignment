package Assignment_3;

public class symmetric_matrix extends square {
    String type = "Symmetric Matrix";

    public symmetric_matrix(int[][] matrix, int size) {
        super(matrix, size);
        this.matrix=matrix;
        this.size=size;
        typelist.add(type);
    }

}

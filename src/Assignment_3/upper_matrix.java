package Assignment_3;

public class upper_matrix extends square{
    private String type = "Upper matrix";
    public upper_matrix(int[][] matrix, int size) {
        super(matrix, size);
        this.matrix=matrix;
        this.size=size;
        typelist.add(type);
    }
}

package Assignment_3;

public class upper_matrix extends square{
    String type = "Upper Matrix";
    public upper_matrix(int[][] matrix, int size) {
        super(matrix, size);
        this.matrix=matrix;
        this.size=size;
        typelist.add(type);
    }
}

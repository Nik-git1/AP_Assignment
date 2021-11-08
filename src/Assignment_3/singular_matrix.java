package Assignment_3;

public class singular_matrix extends square{
    String type = "Singular Matrix";
    public singular_matrix(int[][] matrix, int size) {
        super(matrix, size);
        this.matrix=matrix;
        this.size=size;
        typelist.add(type);
    }
}

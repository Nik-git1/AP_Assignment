package Assignment_3;

public class ones extends square{
    private String type = "Ones matrix";
    private String type1 = "Symmetric matrix";
    public ones(int[][] matrix, int size) {
        super(matrix, size);
        this.matrix=matrix;
        this.size=size;
        typelist.add(type);
        typelist.add(type1);
    }
}

package Assignment_3;

public class Null extends square{
    private String type="Null matrix";
    private String type1="Symmetric matrix";
    private String type2="Skew Symmetric matrix";
    public Null(int[][] matrix, int size) {
        super(matrix, size);
        this.matrix=matrix;
        this.size=size;
        typelist.add(type);
        typelist.add(type1);
        typelist.add(type2);
    }
}

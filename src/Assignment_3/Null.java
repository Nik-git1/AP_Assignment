package Assignment_3;

public class Null extends square{
    String type="Null";
    String type1="Symmetric";
    String type2="Skew-Symmetric";
    public Null(int[][] matrix, int size) {
        super(matrix, size);
        this.matrix=matrix;
        this.size=size;
        typelist.add(type);
        typelist.add(type1);
        typelist.add(type2);
    }
}

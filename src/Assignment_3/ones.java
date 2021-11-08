package Assignment_3;

public class ones extends square{
    String type = " Ones matrix";
    String type1 = "Symmetric";
    public ones(int[][] matrix, int size) {
        super(matrix, size);
        this.matrix=matrix;
        this.size=size;
        typelist.add(type);
        typelist.add(type1);
    }
}

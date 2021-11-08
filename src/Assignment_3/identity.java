package Assignment_3;

public class identity extends scalar{
    String type = "Identity";
    String type1 = "Symmetric";
    public identity(int[][] matrix, int size) {
        super(matrix, size);
        this.size=size;
        this.matrix=matrix;
        typelist.add(type);
        typelist.add(type1);
    }
}

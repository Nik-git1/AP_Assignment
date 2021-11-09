package Assignment_3;

public class singleton extends square{
    String type = "Singleton matrix";

    public singleton(int[][] matrix, int size) {
        super(matrix, size);
        this.matrix=matrix;
        this.size=size;
        typelist.add(type);
        if (matrix[0][0]==0){
            typelist.add("Null");
        }
    }
}

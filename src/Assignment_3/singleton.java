package Assignment_3;

public class singleton extends scalar{
    String type = "Singleton";

    public singleton(int[][] matrix, int size) {
        super(matrix, size);
        this.matrix=matrix;
        this.size=size;
        typelist.add(type);
    }
}

package Assignment_3;

public class scalar extends diagonal_matrix{
    String type="Scalar Matrix";
    String type1="symmetric";
    public scalar(int[][] matrix, int size) {
        super(matrix, size);
        this.size=size;
        this.matrix=matrix;
        typelist.add(type);

    }
}

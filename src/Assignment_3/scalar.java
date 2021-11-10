package Assignment_3;

public class scalar extends diagonal_matrix{
    String type="Scalar matrix";
    String type1="Symmetric matrix";
    public scalar(int[] diag, int size) {
        super(diag, size);
        this.size=size;
        this.diag=diag;
        typelist.add(type);

    }
}

package Assignment_3;

public class scalar extends diagonal_matrix{
    private String type="Scalar matrix";
    private String type1="Symmetric matrix";
    public scalar(int[] diag, int size) {
        super(diag, size);
        this.size=size;
        this.diag=diag;
        typelist.add(type);
        typelist.add(type1);

    }
}

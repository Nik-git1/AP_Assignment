package Assignment_3;

public class scalar extends diagonal_matrix{
    int val;
    String type="Scalar Matrix";
    String type1="symmetric";
    public scalar(int[] diag, int size) {
        super(diag, size);
        this.size=size;
        this.diag=diag;
        typelist.add(type);

    }
}

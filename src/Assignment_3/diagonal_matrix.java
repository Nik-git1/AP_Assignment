package Assignment_3;

public class diagonal_matrix extends square{
    String type="Diagonal matrix";
    String type1 = "Symmetric";
    public diagonal_matrix(int[] diag, int size) {
        super(diag, size);
        this.size=size;
        this.diag=diag;
        typelist.add(type);
    }

}

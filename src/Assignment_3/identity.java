package Assignment_3;

public class identity extends scalar{
    String type = "Identity matrix";
    String type1 = "Symmetric matrix";
    public identity(int[] diag, int size) {
        super(diag, size);
        this.size=size;
        this.diag=diag;
        typelist.add(type);
        typelist.add(type1);
    }
}

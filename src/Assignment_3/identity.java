package Assignment_3;

public class identity extends scalar{
    String type = "Identity";
    String type1 = "Symmetric";
    public identity(int[] diag, int size) {
        super(diag, size);
        this.size=size;
        this.diag=diag;
        typelist.add(type);
        typelist.add(type1);
    }
}

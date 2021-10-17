package Assignment_2;

public class instructor {
    static int count=0;
    private String name;
    private int index;

    public instructor(String name) {
        this.name = name;
        index=count;
        count++;
    }

    public int getIndex() {
        return index;
    }
}

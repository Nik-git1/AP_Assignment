package Assignment_2;

public class students {
    static int count=0;
    private int index;
    private String name;

    public students(String name) {
        this.name = name;
        index=count;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }
}

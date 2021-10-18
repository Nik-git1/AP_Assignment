package Assignment_2;

public class assessment {
    private int type; // 1 for assignment, 2 for quiz
    private String problem;
    private int max_marks;
    private boolean status;

    public assessment(int type) {
        this.type = type;
    }
}

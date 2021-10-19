package Assignment_2;

public class assessment {
    static int count=0;
    private String type;
    private String problem;
    private int max_marks;

    private instructor uploader;
    private int id;
    private boolean submit_status;
    private boolean status;
    private boolean grade_status;
    private String solution;
    private instructor grader;
    private int gained_marks;


    public assessment(String problem,int max_marks,instructor i) {
        this.type = "Assignment";
        this.max_marks=max_marks;
        this.problem=problem;
        submit_status=false;
        status=true;
        uploader=i;
        id=count;
        count++;

    }
    public assessment(int max_marks,instructor i,String problem) {
        this.type = "Assignment";
        this.max_marks=max_marks;
        this.problem=problem;
        submit_status=false;
        status=true;
        uploader=i;

    }
    public assessment(String problem, instructor i ){
        this.problem=problem;
        max_marks=1;
        this.type="Question";
        status=true;
        uploader=i;
        id=count;
        count++;
    }

    public assessment( instructor i,String problem ){
        this.problem=problem;
        max_marks=1;
        this.type="Question";
        status=true;
        uploader=i;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getProblem() {
        return problem;
    }

    public int getMax_marks() {
        return max_marks;
    }

    public String getType() {
        return type;
    }


    public boolean isSubmit_status() {
        return submit_status;
    }

    public instructor getUploader() {
        return uploader;
    }

    public String getSolution() {
        return solution;
    }

    public instructor getGrader() {
        return grader;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public void setSubmit_status(boolean submit_status) {
        this.submit_status = submit_status;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public void setGrader(instructor grader) {
        this.grader = grader;
    }

    public boolean isGrade_status() {
        return grade_status;
    }

    public void setGrade_status(boolean grade_status) {
        this.grade_status = grade_status;
    }

    public void setGained_marks(int gained_marks) {
        this.gained_marks = gained_marks;
    }

    public int getGained_marks() {
        return gained_marks;
    }
}

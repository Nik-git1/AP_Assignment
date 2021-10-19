package Assignment_2;

import java.util.ArrayList;

public class students {
    static int count=0;
    private int index;
    private String name;
    private ArrayList<assessment> assess_list;
    private assessment student_ass;
    private ArrayList<String> c_material;
    private ArrayList<assessment> submit_list;
    private ArrayList<Integer> submitted_array;

    public students(String name,ArrayList<assessment> assess_list,ArrayList<String> c_material) {
        this.name = name;
        this.assess_list=assess_list;
        this.c_material=c_material;
        submit_list= new ArrayList<assessment>();
        submitted_array= new ArrayList<Integer>();
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


    public void ViewLecture() {
        for (int i = 0; i < c_material.size(); i++) {
            System.out.println(c_material.get(i));
        }
    }

    public void ViewAssessment(){
        int pending=0;
        System.out.println("Pending assessements");
         for (int  k = 0; k<assess_list.size();k++){
             assessment a =assess_list.get(k);
             boolean ans=submitted_array.contains(a.getId());
             if (a.isStatus()==true && ans==false){
                 pending=1;
                 if (a.getType().equals("Assignment")) {
                     System.out.println("ID: " + a.getId() + " " + a.getType() + ":" + a.getProblem() + " " + a.getMax_marks());
                 }
                 else
                     System.out.println("ID: " + a.getId() + " " + a.getType() + ":" + a.getProblem());
             }


         }
        if (pending==0){
            System.out.println("No pending assignments");
        }

    }


    public void submit(int id,String solution){
        assessment a;
        assessment original = assess_list.get(id);
        if (original.getType().equals("Assignment")){
            a = new assessment( original.getMax_marks(), original.getUploader(), original.getProblem());
            a.setId(original.getId());
        }else {
            a = new assessment( original.getUploader(),original.getProblem());
            a.setId(original.getId());
        }

        a.setSubmit_status(true);
        a.setSolution(solution);
        submit_list.add(a);
        System.out.println(a.getId());
        submitted_array.add(a.getId());
        System.out.println(submitted_array.get(0));
        System.out.println(submit_list.get(0).getSolution());
    }

    public ArrayList<assessment> getSubmit_list() {
        return submit_list;
    }

    public void ViewGrade(){
        System.out.println("Graded Submission\n");
        for (int i=0;i<submit_list.size();i++){
            assessment a = submit_list.get(i);
            if (a.isGrade_status()==true){
                System.out.println("Submission "+ a.getSolution());
                System.out.println("Marks scored: "+ a.getGained_marks());
                System.out.println("Graded by: " + a.getGrader().getName());
            }
        }
        System.out.println("Ungraded Submission\n");

        for (int i=0;i<submit_list.size();i++){
            assessment a = submit_list.get(i);

            if (a.isGrade_status()==false){
                System.out.println("Submission"+ a.getSolution());
            }
        }

    }
}

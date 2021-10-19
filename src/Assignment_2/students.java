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

    public students(String name,ArrayList<assessment> assess_list,ArrayList<String> c_material) {
        this.name = name;
        this.assess_list=assess_list;
        this.c_material=c_material;
        submit_list= new ArrayList<assessment>();
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
        System.out.println("Pending assessements");
        for (int  k = 0; k<assess_list.size();k++){
            assessment a =assess_list.get(k);
            if (a.isStatus()==true && a.isSubmit_status()==false){
                if (a.getType().equals("Assignment")) {
                    System.out.println("ID: " + a.getId() + " " + a.getType() + ":" + a.getProblem() + " " + a.getMax_marks());
                }
                else
                    System.out.println("ID: " + a.getId() + " " + a.getType() + ":" + a.getProblem());
            }
        }

    }

    public void submit(int id,String solution){
        assessment a;
        assessment original = assess_list.get(id);
        if (original.getType().equals("Assignment")){
            a = new assessment(original.getProblem(), original.getMax_marks(), original.getUploader());


        }else {
            a = new assessment(original.getProblem(), original.getUploader());
        }

        System.out.println(original.getProblem() +" original");
        System.out.println(original.isSubmit_status());
        System.out.println(a.getProblem() + " new");
        a.setSubmit_status(true);
        System.out.println(original.isSubmit_status());
        a.setSolution(solution);
        submit_list.add(a);
        System.out.println(submit_list.get(0).getSolution());
    }


}

package Assignment_2;

import java.util.ArrayList;

public class instructor {
    static int count=0;
    private String name;
    private int index;
    private ArrayList<assessment>  assess_list;
    private ArrayList<String> c_material;

    public instructor(String name,ArrayList<assessment> assess_list,ArrayList<String> c_material) {
        this.name = name;
        this.assess_list=assess_list;
        this.c_material=c_material;
        index=count;
        count++;
    }

    public String getName() {
        return name;
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
        for (int  k = 0; k<assess_list.size();k++){
            assessment a =assess_list.get(k);
            if (a.isStatus()==true){
                if (a.getType().equals("Assignment")) {
                    System.out.println("ID: " + a.getId() + " " + a.getType() + ":" + a.getProblem() + " " + a.getMax_marks());
                }
                else
                    System.out.println("ID: " + a.getId() + " " + a.getType() + ":" + a.getProblem());
            }
        }

    }
}

package Assignment_2;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class instructor implements Person {
    static int count=0;
    private String name;
    private int index;
    private ArrayList<assessment>  assess_list;
    private ArrayList<String> c_material;
    private ArrayList<String> comments;

    public instructor(String name,ArrayList<assessment> assess_list,ArrayList<String> c_material, ArrayList<String> comments) {
        this.name = name;
        this.assess_list=assess_list;
        this.comments=comments;
        this.c_material=c_material;
        index=count;
        count++;
    }

    public String getName() {
        return name;
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

    public void ViewComment(){
        for (int i=0;i<comments.size();i++){
            System.out.println(comments.get(i));
        }
    }

    public void AddComment(String comment){
        String c= ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME);
        comments.add(comment+ " - "+ name);
        comments.add(c+"\n");

    }
}

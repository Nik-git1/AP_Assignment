package Assignment_1;

import javax.swing.*;
import java.util.List;

public class Citizen {
    private String name;
    private int age;
    private long id;
    private String status;
    private Vaccine vac;
    private int no_of_dose;
    private int nextdate;
    private int day;
    //private List<Vaccine> vaclist;


    public Citizen(String name,int age, long id){

        this.status="NOT VACCINATED";
        this.name = name;
        this.age = age;
        this.id = id;
        no_of_dose=0;

    }

    public void vaccinate(Vaccine vac,int day){
      //  this.vaclist= vaclist;
        this.vac=vac;
        this.day= day;

        no_of_dose+=1;

        if(no_of_dose==vac.getNo_of_doses()){
            status="VACCINATED";
        } else
            status="PARTIALLY VACCINATED";

        if (status=="PARTIALY VACCINATED"){
            nextdate=day+vac.getGap_in_doses();
        }

    }

    public String getStatus() {
        return status;
    }
    public void vac_status(){
        System.out.println(status);
        System.out.println("Vaccine Given: "+vac);
        System.out.println("NO of doses given: "+no_of_dose);
        if (status=="PARTIALLY VACCINATED") {
            System.out.println("Next Dose due date: "+nextdate);
        }
    }

    public long getId() {
        return id;
    }

    public Vaccine getVac() {
        return vac;
    }

    public int getNextdate() {
        return nextdate;
    }
}

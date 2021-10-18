package Assignment_1;
/*
import java.util.List;

public class Citizen {
    private String name;
    private int age;
    private long id;
    private String status;
    private String vac;
    private int no_of_dose;
    private int nextdate;
    private int day;
    private List<Vaccine> vaclist;
    private List<Slots> slotlist;


    public Citizen(String name,int age, long id,List<Vaccine> vaclist,List<Slots> slotlist){
        this.status="REGISTERED";
        this.name = name;
        this.age = age;
        this.id = id;
        no_of_dose=0;
        this.vaclist=vaclist;
        this.slotlist=slotlist;
    }

    public void vaccinate(Slots s){
       this.vac=s.getVacName();
       this.day=s.getDay();
       no_of_dose+=1;

        if(no_of_dose==s.getNo_of_doses()){
            status="FULLY VACCINATED";
        } else
            status="PARTIALLY VACCINATED";

        if (status=="PARTIALLY VACCINATED"){
            nextdate=day+s.getGap() ;
        }

    }

    public String getStatus() {
        return status;
    }

    public String getVacName(){
        return vac;
    }

    public void vac_status(){
        if (status=="REGISTERED")
        {
            System.out.println("Citizen REGISTERED");
        }else{
            System.out.println(status);
            System.out.println("Vaccine Given: "+vac);
            System.out.println("NO of doses given: "+no_of_dose);
            if (status=="PARTIALLY VACCINATED") {
            System.out.println("Next Dose due date: "+nextdate);
        }
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNextdate() {
        return nextdate;
    }
}
*/
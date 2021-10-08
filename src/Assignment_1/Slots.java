package Assignment_1;

import java.util.List;

public class Slots {
    private int id;
    private int quantity;
    private int day;
    private Vaccine vaccine;

    public Slots(int id, int day , int quantity , Vaccine vaccine ){
        this.id=id;
        this.quantity=quantity;
        this.day=day;
        this.vaccine= vaccine;

        System.out.println( id +" "+ quantity+ " " + day +" "+ vaccine.getName());
    }



}

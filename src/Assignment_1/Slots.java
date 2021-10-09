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

    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getDay() {
        return day;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setQuantity() {
        quantity-=1;
    }
}

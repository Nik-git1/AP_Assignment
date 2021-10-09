package Assignment_1;

import java.util.Random;

public class Hospital {
    private String name;
    private int pincode;
    private int id;

    public Hospital(String name , int pincode, int id){
        this.id = id;
        this.name=name;
        this.pincode=pincode;
    }

    public int getPincode() {
        return pincode;
    }

    public String getName() {
        return name;
    }
}

package Assignment_1;

import java.util.Random;

public class Hospital {
    private String name;
    private int pincode;
    private int id;

    public Hospital(String name , int pincode){
        Random rnd = new Random();
        id = rnd.nextInt(999999);
        this.name=name;
        this.pincode=pincode;
    }

    public int getPincode() {
        return pincode;
    }

}

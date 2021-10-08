package Assignment_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Vaccine vac= new Vaccine("covin",2,1 );
        Vaccine vac2= new Vaccine("cova",1,0 );
        List<Vaccine> vaclist = new ArrayList<Vaccine>();
        vaclist.add(vac);
        vaclist.add(vac2);
        Citizen nikhil = new Citizen("nikhil",19,123);
        Citizen shiv = new Citizen("shivam",17,23);
        List<Citizen> person = new ArrayList<Citizen>();
        person.add(nikhil);
        person.add(shiv);
        Hospital max = new Hospital("max",1);
        Hospital apollo= new Hospital("apollo",1);
        List<Hospital> hospitalList = new ArrayList<Hospital>();
        hospitalList.add(max);
        hospitalList.add(apollo);
        Slots a = new Slots(123,1,10,vac);










    }
}

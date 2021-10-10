package Assignment_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Vaccine> vaclist = new ArrayList<>();
        List<Hospital> hoslist = new ArrayList<>();
        List<Citizen> citilist = new ArrayList<>();
        List<Slots> slotlist = new ArrayList<>();

  int exit =0;
        while(exit==0) {
            System.out.println("""
                    CoWin Portal initialized....
                    ---------------------------------
                    1. Add Vaccine
                    2. Register Hospital
                    3. Register Citizen
                    4. Add Slot for Vaccination
                    5. Book Slot for Vaccination
                    6. List all slots for a hospital
                    7. Check Vaccination Status
                    8. Exit
                    ---------------------------------
                    """);
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    int newvac=1;
                    int gap=0;
                    System.out.print("Vaccine Name: ");
                    String vac=sc.next();

                    for (int i =0 ; i< vaclist.size();i++) {
                        if (vac.equals(vaclist.get(i).getName()))
                        { System.out.println("Two vaccine can not have a same name");
                            newvac=0;
                            break;
                        }
                    }
                    if (newvac==1) {
                    System.out.println("Number of Doses");
                    int dose=sc.nextInt();
                    if (dose>1) {
                        System.out.println("Gaps beween Doses");
                         gap = sc.nextInt();
                    }


                    Vaccine vax= new Vaccine(vac,dose,gap);
                    vaclist.add(vax);
                    System.out.println("Vaccine Name : "+ vac +", Number of Doses: "+dose +", Gap Between Doses: "+gap);
                    }

                    break;
                case 2:
                    System.out.println("Hospital Name:");
                    String h_name=sc.next();
                    System.out.println("Pincode:");
                    int pin= sc.nextInt();
                    Random rnd = new Random();
                    int number = rnd.nextInt(999999);
                    number= Integer.parseInt(String.format("%06d", number));
                    Hospital hos= new Hospital(h_name,pin,number);
                    hoslist.add(hos);

                    System.out.println("Hospital Name: " + h_name + ", Pincode: "+pin +" Unique id: "+ number );
                    break;
                case 3:
                    int new_citizen=1;
                    System.out.println("Citizen Name:");
                    String name= sc.next();
                    System.out.println("Age");
                    int age = sc .nextInt();
                    System.out.println("Unique ID");
                    long id = sc.nextLong();
                    for (int i=0;i< citilist.size();i++){
                        Citizen c = citilist.get(i);
                        if (c.getId()==id){
                            new_citizen=-1;
                        }
                    }

                    if (new_citizen==1) {
                        int length = String.valueOf(id).length();
                        if (length != 12) {
                            System.out.println("Unique ID should be 12 digits");
                            break;
                        }
                        System.out.println("Citizen Name: " + name + ", Age:" + age + ", Unique ID: " + id);
                        if (age > 17) {
                            Citizen citi = new Citizen(name, age, id, vaclist, slotlist);
                            citilist.add(citi);
                        } else
                            System.out.println("Only above 18 are allowed");
                    }else
                        System.out.println("PROVIDE UNIQUE ID");

                    break;
                case 4:
                    System.out.println("Enter Hospital ID:");
                    int hos_present=-1;
                    int hid=sc.nextInt();
                    for (int i =0; i<hoslist.size();i++){
                        Hospital h = hoslist.get(i);
                        if (h.getId()==hid){
                            hos_present=1;
                        }
                    }
                    if (hos_present==-1){
                        System.out.println("HOSPITAL NOT FOUND");
                        break;
                    }
                    System.out.println("Enter number of Slots to be added:");
                    int no_slots= sc.nextInt();
                    for (int i =0; i<no_slots;i++){
                        System.out.println("Enter Day Number:");
                        int day=sc.nextInt();

                        for (int j =0;i<slotlist.size();i++){
                            Slots s = slotlist.get(j);
                            if (s.getHid()==hid && s.getDay()==day){
                                System.out.println("Can't add different slots for same day in same hospital");
                            }
                        }

                        System.out.println("Enter quantity:");
                        int quantity=sc.nextInt();
                        System.out.println("Select vaccine:");
                        for (int j =0 ;j< vaclist.size();j++){
                            System.out.println( j +" "+ vaclist.get(j).getName());
                        }
                        int vacchoice=sc.nextInt();
                        Slots slot = new Slots(hid,day,quantity, vaclist.get(vacchoice),vaclist,hoslist);
                        slotlist.add(slot);

                        System.out.println("Slot added by Hospital "+ hid +" for Day "+day+" Available Quantity: "+quantity+" of Vaccine "+vaclist.get(vacchoice).getName());
                    }
                    break;
                case 5:
                    System.out.println("Enter patient Unique ID:");
                    long c_id = sc.nextLong();
                    String search_vac=null;
                    int citizen_in_list=-1;
                    for (int i=0;i<citilist.size();i++) {
                        Citizen c = citilist.get(i);
                        if (c.getId() == c_id) {
                            citizen_in_list = i;
                            break;
                        }
                    }
                    if (citizen_in_list==-1){
                        System.out.println("NO ID FOUND");
                        break;
                    }

                    System.out.println("""
                            1. Search by area
                            2. Search by Vaccine
                            3. Exit""");
                    System.out.println("Enter option:");
                    int search=sc.nextInt();
                    if (search==1){
                        System.out.println("Enter pincode:");
                        int user_pin= sc.nextInt();
                        for (int i =0; i<hoslist.size();i++){
                            Hospital h = hoslist.get(i);
                            if (h.getPincode()==user_pin){
                                System.out.println(h.getId()+" "+h.getName());
                            }
                        }
                    }else if (search==2){
                        System.out.println("Enter Vaccine Name:");
                        String u_vac=sc.next();
                        search_vac=u_vac;
                        for (int i =0; i<slotlist.size();i++){
                            Slots s = slotlist.get(i);
                            if (s.getVacName().equals(u_vac)){
                                System.out.println(s.getHid()+" "+s.getHosName());
                            }
                        }
                    }else
                        break;

                    System.out.println("Enter hospital ID:");
                    int user_hid= sc.nextInt();
                    int available=-1;
                    if (citilist.get(citizen_in_list).getStatus().equals("REGISTERED")) {
                        for (int i = 0; i < slotlist.size(); i++) {
                            Slots s = slotlist.get(i);
                            if (s.getHid() == user_hid) {
                                if (s.getQuantity() > 0 &&(search != 2 || search_vac.equals(s.getVacName()))) {
                                    System.out.println(i + " -> Day: " + s.getDay() + " Available Qty: " + s.getQuantity() + " Vaccine: " + s.getVacName());
                                    available=0;
                                }
                            }
                        }
                        if (available==-1){
                            System.out.println("NO SLOT AVAILABLE");
                        }
                    }else if (citilist.get(citizen_in_list).getStatus().equals("PARTIALLY VACCINATED")){
                        for (int i = 0; i < slotlist.size(); i++) {
                            Slots s = slotlist.get(i);
                            if (s.getHid() == user_hid && citilist.get(citizen_in_list).getVacName().equals(s.getVacName()) && citilist.get(citizen_in_list).getNextdate()<=s.getDay()) {
                                if (s.getQuantity() > 0&&(search != 2 || search_vac.equals(s.getVacName()))) {
                                    System.out.println(i + " -> Day: " + s.getDay() + " Available Qty: " + s.getQuantity() + " Vaccine: " + s.getVacName());
                                    available=0;
                                }
                            }
                        }
                        if (available==-1){
                            System.out.println("NO SLOT AVAILABLE");
                        }
                    }else
                        System.out.println("ALREADY VACCINATED");//371574 //650241
                    if (available!=-1) {

                        System.out.println("Choose slot:");
                        int user_slot = sc.nextInt();
                        Slots s = slotlist.get(user_slot);
                        citilist.get(citizen_in_list).vaccinate(s);
                        s.setQuantity();
                        System.out.println(citilist.get(citizen_in_list).getName() + " vaccinated with " + citilist.get(citizen_in_list).getVacName());
                    }


                    break;
                case 6:
                    System.out.println("Enter Hospital ID:");
                    int present=-1;
                    int user_h_id= sc.nextInt();
                    for (int i = 0;i<slotlist.size();i++){
                        Slots u_s = slotlist.get(i);
                        if(u_s.getHid()==user_h_id){
                            System.out.println("Day :"+ u_s.getDay()+" Vaccine:"+u_s.getVacName()+" Available Qty:"+ u_s.getQuantity());
                            present=1;
                        }
                    }
                    if (present==-1){
                        System.out.println("NO SLOTS FOUND");
                    }

                    break;
                case 7:
                    System.out.println("Enter Patient ID:");
                    long user_pid=sc.nextLong();
                    for (int i = 0; i< citilist.size();i++){
                        Citizen c = citilist.get(i);
                        if (c.getId()==user_pid){
                            c.vac_status();
                        }
                    }
                    break;
                case 8:
                    exit=1;
                    break;
            }
        }

        System.out.println("PORTAL CLOSED");



    }
}

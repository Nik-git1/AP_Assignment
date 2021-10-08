package Assignment_1;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       /* Vaccine vac= new Vaccine("covin",2,1 );
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
        Slots a = new Slots(123,1,10,vac); */
        Scanner sc = new Scanner(System.in);
        List<Vaccine> vaclist = new ArrayList<Vaccine>();


        int exit =0;
        while(exit==0) {
            System.out.println("CoWin Portal initialized....\n" +
                            "---------------------------------\n" +
                            "1. Add Vaccine\n" +
                            "2. Register Hospital\n" +
                            "3. Register Citizen\n" +
                            "4. Add Slot for Vaccination\n" +
                            "5. Book Slot for Vaccination\n" +
                            "6. List all slots for a hospital\n" +
                            "7. Check Vaccination Status\n" +
                            "8. Exit\n"+"---------------------------------\n");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Vaccine Name:");
                    String vac=sc.next();
                    System.out.println("Number of Doses");
                    int dose=sc.nextInt();
                    System.out.println("Gaps beween Doses");
                    int gap=sc.nextInt();
                    Vaccine vax= new Vaccine(vac,dose,gap);
                    vaclist.add(vax);

                    break;
                case 2:
                    System.out.println("Hospital Name:");
                    String h_name=sc.next();
                    System.out.println("Pincode:");
                    int pin= sc.nextInt();
                    break;
                case 3:
                    System.out.println("Citizen Name:");
                    String name= sc.next();
                    System.out.println("Age");
                    int age = sc .nextInt();
                    System.out.println("Unique ID");
                    long id = sc.nextLong();

                    break;
                case 4:
                    System.out.println("Enter Hospital ID:");
                    int hid=sc.nextInt();
                    System.out.println("Enter number of Slots to be added:");
                    int no_slots= sc.nextInt();
                    for (int i =0; i<no_slots;i++){
                        System.out.println("Enter Day Number:");
                        int day=sc.nextInt();
                        System.out.println("Enter quantity:");
                        int quantity=sc.nextInt();
                        System.out.println("Select vaccine:");
                        //vaccine list here
                        //make object
                    }
                    break;
                case 5:
                    System.out.println("Enter patient Unique ID:");
                    long pid = sc.nextLong();

                    System.out.println("1. Search by area\n" +
                            "2. Search by Vaccine\n" +
                            "3. Exit");
                    System.out.println("Enter option:");
                    int search=sc.nextInt();
                    if (search==1){
                        System.out.println("Enter pincode:");
                        int user_pin= sc.nextInt();
                        //call hospital list
                        System.out.println("Enter hospital ID:");
                        int user_hid= sc.nextInt();
                        System.out.println("Choose slot:");
                    }
                    break;
                case 6:
                    System.out.println("Enter Hospital ID:");
                    int usr_hid= sc.nextInt();

                    break;
                case 7:
                    System.out.println("Enter Patient ID:");
                    long usr_pid=sc .nextLong();
                    break;
                case 8:
                    exit=1;
                    break;
            }


        }


    }
}

package Assignment_2;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class classroom {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        students s0 = new students("s0");
        students s1 = new students("s1");
        students s2 = new students("s2");
        instructor i0 = new instructor("i0");
        instructor i1 = new instructor("i1");
        ArrayList<students> s_list = new ArrayList<>();
        ArrayList<instructor> i_list= new ArrayList<>();
        ArrayList<String> c_material = new ArrayList<>();
        s_list.add(s0);
        s_list.add(s1);
        s_list.add(s2);
        i_list.add(i0);
        i_list.add(i1);
        System.out.println("Welcome to Backpack\n" +
                "1. Enter as instructor\n" +
                "2. Enter as student\n" +
                "3. Exit");//

        int choice1= sc.nextInt();

        while (choice1!=3){

            if (choice1==1){
                System.out.println("Instructors:\n" +
                                "0 - I1\n" +
                                "1 - I2\n" +
                                "Choose id:");
                int id = sc.nextInt();
                instructor i = i_list.get(id);
                System.out.println("Welcome"+ i.getName());
                System.out.println("INSTRUCTOR MENU\n" +
                        "1. Add class material\n" +
                        "2. Add assessments\n" +
                        "3. View lecture materials\n" +
                        "4. View assessments\n" +
                        "5. Grade assessments\n" +
                        "6. Close assessment\n" +
                        "7. View comments\n" +
                        "8. Add comments\n" +
                        "9. Logout");
                int choice_i= sc.nextInt();
                while (choice_i!=9) {

                    switch (choice_i){
                        case 1:
                            System.out.println("1. Add Lecture Slide\n" +
                                    "2. Add Lecture Video");
                            int material_choice= sc.nextInt();
                            if (material_choice==1){
                                System.out.println("Title:");
                                String title = sc.next();
                                System.out.println("Enter number of slides");
                                int slides = sc.nextInt();
                                c_material.add("Title:"+ title);
                                for (int j =0 ;j<slides;j++){
                                    System.out.println("Enter content of slides");
                                    String content= sc.next();
                                    c_material.add("Slide"+(j+1)+":"+content);
                                }
                                c_material.add("Number of slides:" + slides);
                              //  Date date = new Date();
                                //SimpleDateFormat formatTime = new SimpleDateFormat("HH.mm ss");
                              //  formatTime.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
                                //String time = formatTime.format(Date);
                               // c_material.add(time);
                                c_material.add("Uploaded by "+i.getName());

                                //System.out.println(date);

                            }else {
                                System.out.println("Enter topic of video:");
                                String lect_topic= sc.nextLine();
                                System.out.println("Enter file name of the video");
                                String lect_name=sc.nextLine();
                                if (lect_name.length()>4){
                                String lect_format= lect_name.substring(lect_name.length()-4,lect_name.length());
                                if (lect_format.equals(".mp4")){
                                    System.out.println("done");
                                    c_material.add(lect_topic);
                                    c_material.add(lect_name);
                                }else{
                                    System.out.println("Enter .mp4 format only");
                                }
                                }else
                                    System.out.println("Enter .mp4 format only");

                            }

                            break;
                        case 2:
                            break;
                        case 3:
                            for (int k=0;k< c_material.size();k++){
                                System.out.println(c_material.get(k));
                            }

                            break;
                        case 4:break;
                        case 5:break;
                        case 6:break;
                        case 7: break;
                        case 8: break;
                        case 9: choice_i=9;
                            break;

                    }//end of switch
                    System.out.println("INSTRUCTOR MENU\n" +
                            "1. Add class material\n" +
                            "2. Add assessments\n" +
                            "3. View lecture materials\n" +
                            "4. View assessments\n" +
                            "5. Grade assessments\n" +
                            "6. Close assessment\n" +
                            "7. View comments\n" +
                            "8. Add comments\n" +
                            "9. Logout");
                    choice_i= sc.nextInt();

                }//end of i_menu


            }else if(choice1==2){
                System.out.println("STUDENT MENU\n" +
                        "1. View lecture materials\n" +
                        "2. View assessments\n" +
                        "3. Submit assessment\n" +
                        "4. View grades\n" +
                        "5. View comments\n" +
                        "6. Add comments\n" +
                        "7. Logout");
                int choice_s= sc.nextInt();
                while (choice_s!=7) {


                    switch (choice_s){
                        case 1:  for (int i=0;i< c_material.size();i++){
                                System.out.println(c_material.get(i));
                                 }
                            break;
                        case 2:break;
                        case 3:break;
                        case 4:break;
                        case 5:break;
                        case 6:break;
                        case 7: choice_s=7;
                            break;
                    }//end of switch
                    System.out.println("STUDENT MENU\n" +
                            "1. View lecture materials\n" +
                            "2. View assessments\n" +
                            "3. Submit assessment\n" +
                            "4. View grades\n" +
                            "5. View comments\n" +
                            "6. Add comments\n" +
                            "7. Logout");
                    choice_s= sc.nextInt();

                }//end of s_menu

            }else if(choice1>3){
                System.out.println("ENTER VALUE BETWEEN 1 AND 3");
                choice1= sc.nextInt();
            }

            System.out.println("Welcome to Backpack\n" +
                    "1. Enter as instructor\n" +
                    "2. Enter as student\n" +
                    "3. Exit");
            choice1= sc.nextInt();

        }//end of main menu
        for (int i=0;i< c_material.size();i++){
            System.out.println(c_material.get(i));
        }

    }


}

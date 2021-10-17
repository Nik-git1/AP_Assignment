package Assignment_2;

import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        students s1 = new students("s1");
        students s2 = new students("s2");
        students s3 = new students("s3");
        instructor i1 = new instructor("i1");
        instructor i2 = new instructor("i2");
        ArrayList<students> students_list = new ArrayList<>();
        ArrayList<instructor> instructor_list= new ArrayList<>();
        students_list.add(s1);
        students_list.add(s2);
        students_list.add(s3);
        System.out.println("Welcome to Backpack\n" +
                "1. Enter as instructor\n" +
                "2. Enter as student\n" +
                "3. Exit");

        int choice1= sc.nextInt();

        while (choice1!=3){

            if (choice1==1){

            }else if(choice1==2){
                //System.out.println(students_list.get(0).getName());
                student(students_list, instructor_list);

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


    }
    static void student(ArrayList<students> s_list, ArrayList<instructor> i_list){
        Scanner sc = new Scanner(System.in);
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
                case 1:break;
                case 2:break;
                case 3:break;
                case 4:break;
                case 5:break;
                case 6:break;
                case 7: choice_s=7;
                    break;
            }//end of switch

        }//end of s_menu

    }//FUNC END

}//MAIN END

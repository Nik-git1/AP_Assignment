package Assignment_4_q2;

import java.util.ArrayList;
import java.util.Scanner;

public class Image {


    public static< E extends Number > int printNegative(E val){
        return val.intValue();
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<rgb> rgb_list = new ArrayList<>();
        ArrayList<gray> gray_list = new ArrayList<>();

        int flag=1;
        while (flag==1){
            System.out.println("Enter type of image to perform operations on\n1)Coloured(R,G,B)\n2)Gray \n3)Exit");
            int image_choice= sc.nextInt();
            if (image_choice==1){
                System.out.println("Enter your choice \n1)Input image\n2)Create image\n3)Update image \n4)Display image \n5)Negative of image\n6)Exit");
                int op_choice= sc.nextInt();
                switch (op_choice){
                    case 1:
                        System.out.println("enter image dimension(row and col)");
                        int row=sc.nextInt();
                        int col= sc.nextInt();
                        Double[][][] mat= new Double[row][col][];
                        for (int i =0; i<row;i++) {

                            for (int j = 0; j < col; j++) {
                                System.out.println("Enter R,G,B values");
                                Double r = sc.nextDouble();
                                Double g = sc.nextDouble();
                                Double b = sc.nextDouble();
                                mat[i][j] = new Double[]{r, g, b};
                            }
                        }
                        rgb image = new rgb(row,col,mat);
                        rgb_list.add(image);
                        break;
                    case 2:
                        System.out.println("enter image dimension(row and col)");
                        int row1=sc.nextInt();
                        int col1= sc.nextInt();
                        Double[][][] mat1= new Double[row1][col1][];
                        for (int i =0; i<row1;i++) {

                            for (int j = 0; j < col1; j++) {
                                mat1[i][j] = new Double[]{1.0, 1.0, 1.0};
                            }
                        }
                        rgb image1 = new rgb(row1,col1,mat1);
                        rgb_list.add(image1);break;
                    case 3:
                        System.out.println("Enter id of the image");
                        int id = sc.nextInt();
                        int row2= rgb_list.get(id).getRow();
                        int col2=rgb_list.get(id).getCol();
                        Double[][][] mat2= new Double[row2][col2][];
                        for (int i =0; i<row2;i++) {

                            for (int j = 0; j < col2; j++) {
                                System.out.println("Enter R,G,B values");
                                Double r = sc.nextDouble();
                                Double g = sc.nextDouble();
                                Double b = sc.nextDouble();
                                mat2[i][j] = new Double[]{r, g, b};
                            }
                        }
                        System.out.println("Image Created");
                        rgb_list.get(id).setMatrix(mat2);
                        break;
                    case 4:
                        System.out.println("Enter id of the image");
                        int id1 = sc.nextInt();
                        Double[][][] new_mat= rgb_list.get(id1).getMatrix();

                        for(Double[][] arr: new_mat) {
                            for(Double[] arr1: arr){
                                System.out.print("[");
                                for(Double n: arr1) {
                                    System.out.print(n+" ");
                                }
                                System.out.print("]");
                             }
                            System.out.println();
                        }
                        break;
                    case 5:
                        System.out.println("Enter id of the image");
                        int id2 = sc.nextInt();
                        Double[][][] new_mat1=  rgb_list.get(id2).getMatrix();
                        for(Double[][] arr: new_mat1) {
                            for(Double[] arr1: arr){
                                System.out.print("[");
                                for(Double n: arr1) {
                                    System.out.print(255-printNegative(n)+" ");
                                }
                                System.out.print("]");
                            }
                            System.out.println();
                        }
                        break;
                    case 6:break;

                }
            }else if (image_choice==2){
                System.out.println("Enter your choice \n1)Input image\n2)Create image\n3)Update image \n4)Display image \n5)Negative of image\n6)Exit");
                int op_choice= sc.nextInt();
                switch (op_choice) {
                    case 1:
                        System.out.println("enter image dimension(row and col)");
                        int row = sc.nextInt();
                        int col = sc.nextInt();
                        Integer[][][] mat = new Integer[row][col][];
                        for (int i = 0; i < row; i++) {
                            for (int j = 0; j < col; j++) {
                                System.out.println("Enter value");
                               // Double r = sc.nextDouble();
                               // Double g = sc.nextDouble();
                                Integer b=sc.nextInt();
                                mat[i][j] = new Integer[]{b};
                            }
                        }
                        gray image = new gray(row, col, mat);
                        gray_list.add(image);
                        break;
                    case 2:
                        System.out.println("enter image dimension(row and col)");
                        int row1 = sc.nextInt();
                        int col1 = sc.nextInt();
                        Integer[][][] mat1 = new Integer[row1][col1][];
                        for (int i = 0; i < row1; i++) {
                            for (int j = 0; j < col1; j++) {
                                mat1[i][j] = new Integer[]{1};
                            }
                        }
                        gray image1 = new gray(row1, col1, mat1);
                        gray_list.add(image1);
                        break;
                    case 3:
                        System.out.println("Enter id of the image");
                        int id = sc.nextInt();
                        int row2 = gray_list.get(id).getRow();
                        int col2 = gray_list.get(id).getCol();
                        Integer[][][] mat2 = new Integer[row2][col2][];
                        for (int i = 0; i < row2; i++) {

                            for (int j = 0; j < col2; j++) {
                                System.out.println("Enter value");

                                Integer b = sc.nextInt();
                                mat2[i][j] = new Integer[]{ b};
                            }
                        }
                        System.out.println("Image Created");
                        gray_list.get(id).setMatrix(mat2);
                        break;
                    case 4:
                        System.out.println("Enter id of the image");
                        int id1 = sc.nextInt();
                        Integer[][][] new_mat = gray_list.get(id1).getMatrix();

                        for (Integer[][] arr : new_mat) {
                            for (Integer[] arr1 : arr) {
                                System.out.print("[");
                                for (Integer n : arr1) {
                                    System.out.print(n + " ");
                                }
                                System.out.print("]");
                            }
                            System.out.println();
                        }
                        break;
                    case 5:
                        System.out.println("Enter id of the image");
                        int id2 = sc.nextInt();
                        Integer[][][] new_mat1 = gray_list.get(id2).getMatrix();
                        for (Integer[][] arr : new_mat1) {
                            for (Integer[] arr1 : arr) {
                                System.out.print("[");
                                for (Integer n : arr1) {
                                    System.out.print(255 - printNegative(n));
                                }
                                System.out.print("]");
                            }
                            System.out.println();
                        }
                        break;
                    case 6:
                        break;
                }


                }else if (image_choice==3){
                System.out.println("EXITING...");
                flag=0;
            }
            else {
                System.out.println("Enter either 1 or 2 value");
            }



        }






    }
}

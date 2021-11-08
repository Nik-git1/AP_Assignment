package Assignment_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Mat_opearations {
    public static void main(String[] args) {
        ArrayList<MATRIX> mat_list= new ArrayList<MATRIX>();
        Scanner sc = new Scanner(System.in);

        int flag =1;
        while (flag ==1){
            System.out.println("Enter no of rows");
            int rows= sc.nextInt();
            System.out.println(" enter no of columns");
            int columns = sc.nextInt();
            int[][] matrix = new int[rows][columns];

            for ( int i =0 ;i<rows; i++){
                for (int j =0;j<columns;j++){
                    int ele= sc.nextInt();
                    matrix[i][j]=ele;
                }
            }

            if (rows!=columns){
                if (rows==1 &&columns>rows) {
                    row_matrix mat = new row_matrix(matrix,rows,columns);
                    mat.display();
                    mat_list.add(mat);
                }else if (columns==1 && rows>columns){
                    column_matrix mat = new column_matrix(matrix,rows,columns);
                    mat.display();
                    mat_list.add(mat);
                }else {
                    non_square mat = new non_square(matrix,rows,columns);
                    mat.display();
                    mat_list.add(mat);
                }
            }

            System.out.println("enter flag");
            flag =sc.nextInt();

        }

        for (int i =0;i<mat_list.size();i++){
            mat_list.get(i).display();
        }
    }
}

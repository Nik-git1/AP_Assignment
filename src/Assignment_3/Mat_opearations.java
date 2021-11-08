package Assignment_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Mat_opearations {
    public static void main(String[] args) {
        ArrayList<MATRIX> mat_list= new ArrayList<MATRIX>();
        Scanner sc = new Scanner(System.in);
        int choice=1;
        while(choice!=16){//MENU START
            System.out.println("MAIN MENU\n" +
                    "1. Enter matrices and label them.\n" +
                    "2. Create matrices of requested matrix-types .\n" +
                    "3. Change the elements of a matrix within same label.\n" +
                    "4. Display all the matrix-type labels of a requested matrix.\n" +
                    "5. Perform addition, subtraction, multiplication & division.\n" +
                    "6. Perform element-wise operations.\n" +
                    "7. Transpose matrices.\n" +
                    "8. Inverse matrices.\n" +
                    "9. Compute means: row-wise mean, column-wise mean, mean of all the elements.\n" +
                    "10 Compute determinants.\n" +
                    "11. Use singleton matrices as scalars, if requested.\n" +
                    "12. Compute A+A^T for a matrix A.\n" +
                    "13. Compute Eigen vectors and values.\n" +
                    "14. Solve sets of linear equations using matrices.\n" +
                    "15. Retrieve all the existing matrices of requested type .\n" +
                    "16. EXIT");
            int choice_i= sc.nextInt();
            sc.nextLine();

            switch (choice_i){//SWITCH START
                case 1:
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
                    }//TAKING MATRIX

                    if (rows!=columns){
                        if (rows==1 &&columns>rows) {
                            row_matrix mat = new row_matrix(matrix,rows,columns);
                            mat_list.add(mat);
                        }else if (columns==1 && rows>columns){
                            column_matrix mat = new column_matrix(matrix,rows,columns);
                            mat_list.add(mat);
                        }else {
                            non_square mat = new non_square(matrix,rows,columns);
                            mat_list.add(mat);
                        }
                    }else
                        if (rows==columns){
                            System.out.println("row==col");

                            int size = rows;
                            int flag_0=0;
                            int flag_1=0;

                            for (int i=0;i<size;i++){
                                for (int j=0;j<size;j++){
                                    if (matrix[i][j]!=0){
                                        flag_0=1;
                                        break;
                                    }
                                }
                            }// null check
                            for (int i=0;i<size;i++){
                                for (int j=0;j<size;j++){
                                    if (matrix[i][j]!=1){
                                        flag_1=1;
                                        break;
                                    }
                                }
                            }// ones check
                            if (size==1){
                                System.out.println("in size");
                                singleton mat= new singleton(matrix,size);
                                mat_list.add(mat);
                            }else if (flag_0==0){
                                System.out.println("in 0");
                                Null mat = new Null(matrix,size);
                                mat_list.add(mat);
                            }else if (flag_1==0){
                                System.out.println("in 1");
                                ones mat = new ones(matrix,size);
                                mat_list.add(mat);
                            }else if (diagonality(matrix,size)==1){
                                System.out.println("diagonal it is");
                                diagonal_matrix mat =new diagonal_matrix(matrix,size);
                                mat_list.add(mat);
                            }else if (diagonality(matrix,size)==2){
                                System.out.println("in me");
                                System.out.println("diagonal it si and scalar");
                                scalar mat =new scalar(matrix,size);
                                mat_list.add(mat);
                            }else if(diagonality(matrix,size)==3){
                                System.out.println("in diag3");
                                identity mat =new identity(matrix,size);
                                mat_list.add(mat);
                            } else if (symmetry(matrix,size)==1){
                                System.out.println("in sym1");
                                symmetric_matrix mat = new symmetric_matrix(matrix,size);
                                mat_list.add(mat);
                            }else if (symmetry(matrix,size)==2){
                                System.out.println("in sym2");
                                skew_matrix mat = new skew_matrix(matrix,size);
                                mat_list.add(mat);
                                break;
                            } else if (triangularity(matrix,size)==1){
                                System.out.println("in tri1");
                                upper_matrix mat =new upper_matrix(matrix,size);
                                mat_list.add(mat);
                                break;
                            }else if (triangularity(matrix,size)==2){
                                System.out.println("in tri2");
                                lower_matrix mat = new lower_matrix(matrix,size);
                                mat_list.add(mat);
                                break;
                            }else if (det(matrix,size)==0){
                                System.out.println("in det 0");
                                singular_matrix mat = new singular_matrix(matrix,size);
                                mat_list.add(mat);
                                break;
                            }else if (size>1){
                                System.out.println("in square");
                                square mat = new square(matrix,size);
                                mat_list.add(mat);
                            }

                        }


                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Enter id of the matrix");
                    int choose_id= sc.nextInt();
                    mat_list.get(choose_id).getType();

                    break;
                case 5:

                    System.out.println("Choose operation to perform");
                    System.out.println("1. Perform addition.\n" +
                            "2. Perform subtraction\n" +
                            "3. Transpose multiplication.\n" +
                            "4. Inverse division.");
                    int operation =sc.nextInt();
                    System.out.println("Choose two matrices id");
                    int choose_id_=sc.nextInt();
                    int choose_id_2= sc.nextInt();



                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Enter id of the matrix");
                    int choose_id_t= sc.nextInt();
                    mat_list.get(choose_id_t).transpose();

                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    System.out.println("Enter id of the matrix");
                    int choose_id_3= sc.nextInt();

                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16: choice=16;
                    break;


            }//SWITCH END


        }//MENU END
        System.out.println("EXITING MENU....");






        }//CLASS END

    public static  int symmetry(int[][] mat,int size){
        int status=2;//1 -symmetry, 0 nothing ,2 skew
        int diag_0=1;//1 for  diagonal
        int[][] transpose = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transpose[j][i] = mat[i][j];
            }
        }
        for (int i = 0; i < size; i++) {
           if (mat[i][i]!=0){
               diag_0=0;
               status=1;
               break;
           }
        }

        if (diag_0==1){
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (mat[i][j] != ( transpose[i][j] *-1  )) {
                        status = 0;
                        break;
                    }
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (mat[i][j] != transpose[i][j]) {
                        status = 0;
                        break;
                    }
                }
            }
        }
        return status;
    }

    public static  int triangularity(int[][] mat,int size){
        int status=1;//0 nothing 1 upper 2 lower

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (mat[i][j] != 0) {
                    status=0;
                    break;
                }
            }
        }
        if (status==0){
            status=2;
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                if (mat[i][j] != 0) {
                    status=0;
                    break;
                }
            }
        }
        }

        return status;
    }

    public static  int diagonality(int[][] mat,int size){
        System.out.println("in function");

        int status=1;//0 nothing 1 diagonal 2 scalar 3 identity

        for (int i =0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i != j) && (mat[i][j] != 0)){
                    System.out.println("not true");
                    status=0;
                }
            }
        }
        if (status==1){
            int val = mat[0][0];
            for (int i=0;i<size;i++){
                if (mat[i][i]==val){
                    status=2;
                }else{
                    status=1;
                    break;
                }
            }
            if (status==2){
                if (val==1){
                    status=3;
                }
            }
        }
        System.out.println(status);

        return status;
    }

    static void getCofactor(int mat[][], int temp[][], int p, int q, int n)
    {
        int i = 0, j = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row != p && col != q) {
                    temp[i][j++] = mat[row][col];
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
    static int det(int mat[][], int size)
    {
        int D = 0;
        if (size == 1)
            return mat[0][0];

        int temp[][] = new int[size][size];

        int sign = 1;

        for (int f = 0; f < size; f++) {
            getCofactor(mat, temp, 0, f, size);
            D += sign * mat[0][f] * det(temp, size - 1);
            sign = -sign;
        }

        return D;
    }

    }
//a-loe-u
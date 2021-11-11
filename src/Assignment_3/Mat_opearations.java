package Assignment_3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Mat_opearations {
    public static void main(String[] args) {
        ArrayList<MATRIX> mat_list = new ArrayList<MATRIX>();
        Scanner sc = new Scanner(System.in);
        int choice = 1;
        while (choice != 16) {//MENU START
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
            int choice_i = sc.nextInt();
            sc.nextLine();

            switch (choice_i) {//SWITCH START
                case 1:
                    System.out.println("Enter no of rows");
                    int rows = sc.nextInt();
                    System.out.println(" enter no of columns");
                    int columns = sc.nextInt();
                    int[][] matrix = new int[rows][columns];

                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < columns; j++) {
                            int ele = sc.nextInt();
                            matrix[i][j] = ele;
                        }
                    }//TAKING MATRIX

                    if (rows != columns) {
                        if (rows == 1 && columns > rows) {
                            row_matrix mat = new row_matrix(matrix, rows, columns);
                            mat_list.add(mat);
                        } else if (columns == 1 && rows > columns) {
                            column_matrix mat = new column_matrix(matrix, rows, columns);
                            mat_list.add(mat);
                        } else {
                            non_square mat = new non_square(matrix, rows, columns);
                            mat_list.add(mat);
                        }
                    } else if (rows == columns) {
                        int size = rows;
                        int flag_0 = 0;
                        int flag_1 = 0;

                        for (int i = 0; i < size; i++) {
                            for (int j = 0; j < size; j++) {
                                if (matrix[i][j] != 0) {
                                    flag_0 = 1;
                                    break;
                                }
                            }
                        }// null check
                        for (int i = 0; i < size; i++) {
                            for (int j = 0; j < size; j++) {
                                if (matrix[i][j] != 1) {
                                    flag_1 = 1;
                                    break;
                                }
                            }
                        }// ones check

                        if (size == 1) {
                            singleton mat = new singleton(matrix, size);
                            mat_list.add(mat);
                        } else if (flag_0 == 0) {
                            Null mat = new Null(matrix, size);
                            mat_list.add(mat);
                        } else if (flag_1 == 0) {
                            ones mat = new ones(matrix, size);
                            mat_list.add(mat);
                        } else if (deter(matrix,size)==0){
                            singular_matrix mat= new singular_matrix(matrix,size);
                            mat_list.add(mat);
                            break;
                        } else if (diagonality(matrix, size) == 1) {
                            int[] diag = new int[size];
                            diag = diagconverter(size, matrix);
                            diagonal_matrix mat = new diagonal_matrix(diag, size);
                            mat_list.add(mat);
                        } else if (diagonality(matrix, size) == 2) {
                            int[] diag = new int[size];
                            diag = diagconverter(size, matrix);
                            scalar mat = new scalar(diag, size);
                            mat_list.add(mat);
                        } else if (diagonality(matrix, size) == 3) {
                            int[] diag = new int[size];
                            diag = diagconverter(size, matrix);
                            identity mat = new identity(diag, size);
                            mat_list.add(mat);
                        } else if (symmetry(matrix, size) == 1) {
                            symmetric_matrix mat = new symmetric_matrix(matrix, size);
                            mat_list.add(mat);
                            break;
                        } else if (symmetry(matrix,size) == 2) {
                            skew_matrix mat = new skew_matrix(matrix, size);
                            mat_list.add(mat);
                            break;
                        } else if (triangularity(matrix, size) == 1) {
                            upper_matrix mat = new upper_matrix(matrix, size);
                            mat_list.add(mat);
                            break;
                        } else if (triangularity(matrix, size) == 2) {
                            lower_matrix mat = new lower_matrix(matrix, size);
                            mat_list.add(mat);
                            break;
                        }else if (size>1){
                            square mat = new square(matrix,size);
                            mat_list.add(mat);
                        }


                    }//CONDITIONS CHECK

                    break;
                case 2:
                    System.out.println("ENTER MATRIX TYPE TO CREATE");
                    System.out.println("1. Rectangular Matrix\n" +
                            "2. Row Matrix\n" +
                            "3. Column Matrix\n" +
                            "4. Square Matrix\n" +
                            "5. Symmetric Matrix\n" +
                            "6. Skew-symmetric Matrix\n" +
                            "7. Upper-triangular Matrix\n" +
                            "8. Lower-triangular Matrix\n" +
                            "9. Singular Matrix\n" +
                            "10. Diagonal Matrix\n" +
                            "11. Scalar Matrix\n" +
                            "12. Identity Matrix\n" +
                            "13. Singleton Matrix\n" +
                            "14. Ones Matrix\n" +
                            "15. Null Matrix");
                    int mat_type = sc.nextInt();
                    System.out.println("Enter no of rows[1 to 3], choose 1 for singleton");
                    int row = sc.nextInt();
                    System.out.println("Enter no of column[1 to 3],choose 1 for single ton");
                    int col = sc.nextInt();
                    int[][] created_mat = new int[row][col];
                    switch (mat_type) {

                        case 1, 2, 3:
                            if (row != col) {
                                created_mat = create(row, col);
                                if (row == 1) {
                                    row_matrix mat = new row_matrix(created_mat, row, col);
                                    mat_list.add(mat);
                                    mat.display();
                                } else if (col == 1) {
                                    column_matrix mat = new column_matrix(created_mat, row, col);
                                    mat_list.add(mat);
                                    mat.display();
                                } else {
                                    non_square mat = new non_square(created_mat, row, col);
                                    mat_list.add(mat);
                                    mat.display();
                                }


                            } else System.out.println("wrong dimensions");

                            break;
                        case 4:
                            created_mat = create(row, col);
                            square mat = new square(created_mat, row);
                            mat_list.add(mat);
                            mat.display();
                            break;
                        case 5:
                            created_mat = create2(row, col, 1);
                            symmetric_matrix s_mat = new symmetric_matrix(created_mat, row);
                            mat_list.add(s_mat);
                            s_mat.display();

                            break;
                        case 6:
                            created_mat = create2(row, col, -1);
                            symmetric_matrix ss_mat = new symmetric_matrix(created_mat, row);
                            mat_list.add(ss_mat);
                            ss_mat.display();
                            break;
                        case 7:
                            created_mat = create2(row, col, 2);
                            upper_matrix u_mat = new upper_matrix(created_mat, row);
                            mat_list.add(u_mat);
                            u_mat.display();

                            break;
                        case 8:
                            created_mat = create2(row, col, 3);
                            lower_matrix l_mat = new lower_matrix(created_mat, row);
                            mat_list.add(l_mat);
                            l_mat.display();
                            break;
                        case 9:
                            created_mat = create2(row, col, 4);
                            lower_matrix sin_mat = new lower_matrix(created_mat, row);
                            mat_list.add(sin_mat);
                            sin_mat.display();
                            break;
                        case 10:
                            created_mat = c_diagonal(row, 0);
                            int[] di = new int[row];
                            di = diagconverter(row, created_mat);
                            diagonal_matrix diag1 = new diagonal_matrix(di, row);
                            mat_list.add(diag1);
                            diag1.diag_display();
                            break;
                        case 11:
                            System.out.println("enter scalar value");
                            int val = sc.nextInt();
                            created_mat = c_diagonal(row, val);
                            int[] di1 = new int[row];
                            di1 = diagconverter(row, created_mat);
                            scalar diag2 = new scalar(di1, row);
                            mat_list.add(diag2);
                            diag2.diag_display();
                            break;
                        case 12:
                            created_mat = c_diagonal(row, 1);
                            int[] di2 = new int[row];
                            di2 = diagconverter(row, created_mat);
                            identity diag3 = new identity(di2, row);
                            mat_list.add(diag3);
                            diag3.diag_display();
                            break;
                        case 13:
                            if (row == col && row == 1) {
                                Random rand = new Random();
                                int num = 2 + rand.nextInt(10);
                                created_mat[0][0] = num;
                                singleton single_mat = new singleton(created_mat, row);
                                mat_list.add(single_mat);
                                single_mat.display();
                            } else {
                                System.out.println("Wrong dimension");
                            }
                            break;
                        case 14:
                            for (int i = 0; i < row; i++) {
                                for (int j = 0; j < col; j++) {
                                    created_mat[i][j] = 1;
                                }
                            }
                            ones o_mat = new ones(created_mat, row);
                            mat_list.add(o_mat);
                            o_mat.display();
                            break;

                        case 15:
                            for (int i = 0; i < row; i++) {
                                for (int j = 0; j < col; j++) {
                                    created_mat[i][j] = 0;
                                }
                            }
                            Null i_mat = new Null(created_mat, row);
                            mat_list.add(i_mat);
                            i_mat.display();
                            break;

                    }//CREATE MATRIX

                    break;
                case 3:
                    System.out.println("Choose matrix id to change");
                    int mat_id = sc.nextInt();
                    mat_list.get(mat_id).setMatrix();

                    break;
                case 4:
                    System.out.println("Enter id of the matrix");
                    int choose_id = sc.nextInt();
                    mat_list.get(choose_id).getType();

                    break;

                case 5:
                    int[][] op_mat1;
                    int[][] op_mat2;

                    System.out.println("Choose operation to perform");
                    System.out.println("1. Perform addition.\n" +
                            "2. Perform subtraction\n" +
                            "3. Perform multiplication.\n" +
                            "4. Perform division.");
                    int operation = sc.nextInt();
                    System.out.println("Choose 1st matrices id");
                    int choose_id_1 = sc.nextInt();
                    System.out.println("Choose 2nd matrices id");
                    int choose_id_2 = sc.nextInt();
                    op_mat1 = mat_list.get(choose_id_1).getMatrix();
                    op_mat2 = mat_list.get(choose_id_2).getMatrix();
                    int r1 = op_mat1.length;
                    int r2 = op_mat2.length;
                    int c1 = op_mat1[0].length;
                    int c2 = op_mat2[0].length;


                    switch (operation) {
                        case 1:

                            if (r1 == r2 && c1 == c2) {
                                if (mat_list.get(choose_id_1).typelist.contains("Null matrix")) {
                                    display(op_mat2, 1);
                                } else if (mat_list.get(choose_id_2).typelist.contains("Null matrix")) {
                                    display(op_mat1, 1);
                                } else
                                    add(op_mat1, op_mat2, 1);
                            } else
                                System.out.println("Dimensions do not match");
                            break;
                        case 2:

                            if (r1 == r2 && c1 == c2) {
                                if (mat_list.get(choose_id_1).typelist.contains("Null matrix")) {
                                    display(op_mat2, -1);
                                } else if (mat_list.get(choose_id_2).typelist.contains("Null matrix")) {
                                    display(op_mat1, 1);
                                } else
                                    add(op_mat1, op_mat2, -1);
                            } else
                                System.out.println("Dimensions do not match");
                            break;
                        case 3:
                            if (r2 == c1) {
                                if (mat_list.get(choose_id_1).typelist.contains("Null matrix") || mat_list.get(choose_id_2).typelist.contains("Null")) {
                                    Null_mat(r1, c2);
                                } else if (mat_list.get(choose_id_1).typelist.contains("Identity matrix")) {
                                    display(op_mat2, 1);
                                } else if (mat_list.get(choose_id_2).typelist.contains("Identity matrix")) {
                                    display(op_mat1, 1);
                                } else
                                    multiply(op_mat1, op_mat2);
                            } else
                                System.out.println("Dimensions error");


                            break;
                        case 4:
                            if (r2 == c2 && r2 == c1) {
                                float[][] temp;
                                if (mat_list.get(choose_id_2).typelist.contains("Singular matrix")) {
                                    System.out.println("Error! Singular matrix cant be a divisor");
                                } else {
                                    if (mat_list.get(choose_id_2).typelist.contains("Identity matrix")) {
                                        display(op_mat1, 1);
                                    } else {
                                        temp=mat_list.get(choose_id_2).inverse();
                                        f_multiply(op_mat1,temp);
                                    }
                                }
                            } else {
                                System.out.println(" Dimensions error");
                            }
                            break;
                    }

                    break;
                case 6:
                    int[][] el_mat1;
                    int[][] el_mat2;

                    System.out.println("Choose operation to perform");
                    System.out.println("1. Perform multiplication.\n" +
                            "2. Perform division\n");
                    int el_wise = sc.nextInt();
                    System.out.println("Choose 1st matrices id");
                    int id_1 = sc.nextInt();
                    System.out.println("Choose 2nd matrices id");
                    int id_2 = sc.nextInt();
                    el_mat1 = mat_list.get(id_1).getMatrix();
                    el_mat2 = mat_list.get(id_2).getMatrix();
                    int r_1 = el_mat1.length;
                    int r_2 = el_mat2.length;
                    int c_1 = el_mat1[0].length;
                    int c_2 = el_mat2[0].length;

                    switch (el_wise) {
                        case 1:
                            if ((r_1 == r_2 && c_1 == c_2)) {
                                el_mul(el_mat1, el_mat2, 0);
                            } else System.out.println("Wrong dimension");
                            break;
                        case 2:
                            if ((r_1 == r_2 && c_1 == c_2)) {
                                el_mul(el_mat1, el_mat2, 1);
                            } else System.out.println("Wrong dimension");
                            break;

                    }

                    break;
                case 7:
                    System.out.println("Enter id of the matrix");
                    int choose_id_t = sc.nextInt();
                    mat_list.get(choose_id_t).transpose();

                    break;
                case 8:
                    int[][] inv_mat;
                    System.out.println("Enter id of the matrix");
                    int inv_id = sc.nextInt();
                    inv_mat = mat_list.get(inv_id).getMatrix();

                    if (inv_mat.length == inv_mat[0].length) {
                        float[][] temp;
                        if (mat_list.get(inv_id).typelist.contains("Singular matrix")) {
                            System.out.println("Error! Singular matrix have no inverse");
                        } else {
                            if (mat_list.get(inv_id).typelist.contains("Identity matrix")) {
                                display(inv_mat, 1);
                            } else {
                                temp=mat_list.get(inv_id).inverse();
                                for (int i = 0; i < temp.length; i++) {
                                    for (int j = 0; j < temp[0].length; j++) {
                                        System.out.print(( temp[i][j]) + " ");
                                    }
                                    System.out.println();
                                }
                            }
                        }
                    } else {
                        System.out.println(" Dimensions error");
                    }
                    break;
                case 9:
                    System.out.println("Enter id of the matrix");
                    int mean_id = sc.nextInt();
                    System.out.println("Choose operation to perform");
                    System.out.println("1. Row-wise mean.\n" +
                            "2. Column-wise mean\n" +
                            "3. Overall mean\n");
                    int mean_no = sc.nextInt();
                    mat_list.get(mean_id).mean(mean_no);
                    break;
                case 10: System.out.println("Enter id of the matrix");
                    int det_id = sc.nextInt();
                    System.out.println(mat_list.get(det_id).det());


                    break;
                case 11:
                    System.out.println("Enter id of the singleton matrix");
                    int single_id = sc.nextInt();
                    System.out.println("enter no of rows required");
                    int s_row = sc.nextInt();
                    int val= mat_list.get(single_id).value();
                    int[][] scalar_new;
                    int[][] old;
                    scalar_new=c_diagonal(s_row,val);
                    System.out.println("Enter id of 2nd matrix");
                    int old_id= sc.nextInt();
                    old = mat_list.get(old_id).getMatrix();


                    System.out.println("Choose operation to perform");
                    System.out.println("1. Perform addition.\n" +
                            "2. Perform subtraction\n" +
                            "3. Perform multiplication.\n" +
                            "4. Perform division.");
                    int ope = sc.nextInt();
                    int len = scalar_new.length;
                    int c_old = old[0].length;
                    int r_old = old.length;

                    switch (ope) {
                        case 1:
                            if (len==c_old && len == r_old) {
                                if (mat_list.get(old_id).typelist.contains("Null matrix")) {
                                    display(scalar_new, 1);
                                }  else
                                    add(scalar_new, old, 1);
                            } else
                                System.out.println("Dimensions do not match");
                            break;
                        case 2:
                            if (len==c_old && len == r_old) {
                                if (mat_list.get(old_id).typelist.contains("Null matrix")) {
                                    display(scalar_new, -1);
                                }  else
                                    add(old,scalar_new, -1);
                            } else
                                System.out.println("Dimensions do not match");

                            break;
                        case 3:
                            if (len ==c_old ) {
                                if (mat_list.get(old_id).typelist.contains("Null matrix")) {
                                    Null_mat(r_old, len);
                                } else
                                    multiply(old, scalar_new);
                            } else
                                System.out.println("Dimensions error");


                            break;
                        case 4:
                            if ( len == c_old) {
                                float[][] temp = new float[len][len];
                                for (int i =0; i<len;i++){
                                    for (int j=0 ;j<len;j++){
                                       temp[i][j]=(float)(1/scalar_new[i][j]);
                                    }
                                }
                                f_multiply(old, temp);
                            }
                            else {
                                System.out.println(" Dimensions error");
                            }
                            break;
                    }

                    break;
                case 12:
                    System.out.println("Enter id of the matrix");
                    int choose_id_3 = sc.nextInt();
                    mat_list.get(choose_id_3).addtranspose();

                    break;
                case 13:
                    break;
                case 14:
                    System.out.println("Enter id of the matrix(square)");
                    int solve_id = sc.nextInt();
                    System.out.println("Enter id of 2nd matrix(column)");
                    int solve_id2 =sc.nextInt();
                    int[][] solve1 =mat_list.get(solve_id).getMatrix();
                    int[][] solve2 = mat_list.get(solve_id2).getMatrix();
                    int row1= solve1.length;
                    int row2= solve2.length;

                    if (row1== row2 ){
                        float temp[][]=mat_list.get(solve_id).inverse();
                        for (int i =0 ;i<row1;i++){
                            float sum=0;
                            for (int j=0;j<row1;j++){
                                sum += (float) (temp[i][j] *solve2[j][0]);
                            }
                            System.out.println(sum);
                        }
                    }else
                        System.out.println("Wrong dimension");

                    break;
                case 15:
                    System.out.println("Enter matrix label to search");
                    System.out.println("1. Rectangular Matrix\n" +
                            "2. Row Matrix\n" +
                            "3. Column Matrix\n" +
                            "4. Square Matrix\n" +
                            "5. Symmetric Matrix\n" +
                            "6. Skew-symmetric Matrix\n" +
                            "7. Upper-triangular Matrix\n" +
                            "8. Lower-triangular Matrix\n" +
                            "9. Singular Matrix\n" +
                            "10. Diagonal Matrix\n" +
                            "11. Scalar Matrix\n" +
                            "12. Identity Matrix\n" +
                            "13. Singleton Matrix\n" +
                            "14. Ones Matrix\n" +
                            "15. Null Matrix");
                    int label_type = sc.nextInt();
                    String label = "";
                    switch (label_type) {
                        case 1:
                            label = "Rectangular matrix";
                            break;
                        case 2:
                            label = "Row matrix";
                            break;
                        case 3:
                            label = "Column matrix";
                            break;
                        case 4:
                            label = "Square matrix";
                            break;
                        case 5:
                            label = "Symmetric matrix";
                            break;
                        case 6:
                            label = "Skew Symmetric matrix";
                            break;
                        case 7:
                            label = "Upper matrix";
                            break;
                        case 8:
                            label = "Lower matrix";
                            break;
                        case 9:
                            label = "Singular matrix";
                            break;
                        case 10:
                            label = "Diagonal matrix";
                            break;
                        case 11:
                            label = "Scalar matrix";
                            break;
                        case 12:
                            label = "Identity matrix";
                            break;
                        case 13:
                            label = "Singleton matrix";
                            break;
                        case 14:
                            label = "Ones matrix";
                            break;
                        case 15:
                            label = "Null matrix";
                            break;

                    }

                    for (int i = 0; i < mat_list.size(); i++) {
                        mat_list.get(i).labelfinder(label);
                    }


                    break;
                case 16:
                    choice = 16;
                    break;


            }//SWITCH END


        }//MENU END
        System.out.println("EXITING MENU....");


    }//CLASS END

    public static int symmetry(int[][] mat, int size) {
        int status = 2;//1 -symmetry, 0 nothing ,2 skew
        int diag_0 = 1;//1 for  diagonal
        int[][] transpose = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transpose[j][i] = mat[i][j];
            }
        }
        for (int i = 0; i < size; i++) {
            if (mat[i][i] != 0) {
                diag_0 = 0;
                status = 1;
                break;
            }
        }
        if (diag_0 == 1) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (mat[i][j] != (transpose[i][j] * -1)) {
                        status = 0;
                        break;
                    }
                }
            }
        } else {
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

    public static int triangularity(int[][] mat, int size) {
        int status = 1;//0 nothing 1 upper 2 lower
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (mat[i][j] != 0) {
                    status = 0;
                    break;
                }
            }
        }

        if (status == 0) {
            status = 2;
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (mat[i][j] != 0) {
                        status = 0;
                        break;
                    }
                }
            }
        }
        return status;
    }

    public static int diagonality(int[][] mat, int size) {

        int status = 1;//0 nothing 1 diagonal 2 scalar 3 identity

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i != j) && (mat[i][j] != 0)) {
                    status = 0;
                }
            }
        }
        if (status == 1) {
            int val = mat[0][0];
            for (int i = 0; i < size; i++) {
                if (mat[i][i] == val) {
                    status = 2;
                } else {
                    status = 1;
                    break;
                }
            }
            if (status == 2) {
                if (val == 1) {
                    status = 3;
                }
            }
        }
        System.out.println(status);

        return status;
    }

    static void display(int mat[][], int value) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print((value * mat[i][j]) + " ");
            }
            System.out.println();
        }
    }

    static void Null_mat(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("0" + " ");
            }
            System.out.println();
        }
    }

    static int[][] create(int row, int col) {
        int[][] created = new int[row][col];
        Random rand = new Random();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int r1 = 1 + rand.nextInt(10);
                created[i][j] = r1;
            }
        }
        return created;
    }

    static int[][] create2(int row, int col, int val) {//1 sym -1 skew sym , 2 up , 3  low ,4 singular
        int create[][] = create(row, col);
        if (val < 2) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    create[i][j] = val * create[j][i];
                }
            }
            if (val == -1) {
                for (int i = 0; i < row; i++) {
                    create[i][i] = 0;
                }
            }
        }

        if (val == 2) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i > j) {
                        create[i][j] = 0;
                    }
                }
            }
        }

        if (val == 3) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (j > i) {
                        create[i][j] = 0;
                    }
                }
            }
        }

        if (val == 4) {
            for (int i = 0; i < row; i++) {
                create[0][i] = 0;
            }
        }
        return create;
    }

    static int[][] c_diagonal(int size, int val) {
        int create[][] = new int[size][size];
        for (int i = 0; i < size; i++) {
            int num;
            if (val == 0) {
                Random rand = new Random();
                num = 1 + rand.nextInt(10);
            } else if (val == 1) {
                num = 1;
            } else num = val;
            create[i][i] = num;

        }

        return create;
    }

    static int[] diagconverter(int size, int[][] matrix) {
        int[] diag = new int[size];
        for (int i = 0; i < size; i++) {
            diag[i] = matrix[i][i];
        }
        return diag;
    }

    static void add(int[][] m1, int[][] m2, int val) {

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                m1[i][j] += (val * m2[i][j]);
                System.out.print(m1[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void multiply(int[][] m1, int[][] m2) {
        int[][] temp = new int[m1.length][m2[0].length];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++)
                    temp[i][j] += m1[i][k] * m2[k][j];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void f_multiply(int[][] m1, float[][] m2) {
        float[][] temp = new float[m1.length][m2[0].length];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    temp[i][j] += (float) m1[i][k] * m2[k][j];
                }
            }
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void el_mul(int[][] m1, int[][] m2, int val) {

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                if (val == 1) {
                    System.out.print(m1[i][j] * (1 / m2[i][j]) + " ");
                } else
                    System.out.print(m1[i][j] * m2[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int deter(int[][] matrix,int size){
        int determinant=0;

        if (size==1) {
            System.out.println(matrix[0][0]);
        }else if (size==2){
            determinant=(matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }else if (size==3){
            int x = (matrix[1][1] * matrix[2][2]) - (matrix[2][1] * matrix[1][2]);
            int y = (matrix[1][0] * matrix[2][2]) - (matrix[2][0] * matrix[1][2]);
            int z = (matrix[1][0] * matrix[2][1]) - (matrix[2][0] * matrix[1][1]);

            determinant = (matrix[0][0] * x)- (matrix[0][1] * y) + (matrix[0][2] * z);

        }
        return determinant;
    }


}
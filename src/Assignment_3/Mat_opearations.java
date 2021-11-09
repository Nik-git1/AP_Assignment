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
                        } else if (diagonality(matrix, size) == 1) {
                            int[] diag= new int[size];
                            diag=diagconverter(size,matrix);
                            diagonal_matrix mat = new diagonal_matrix(diag, size);
                            mat_list.add(mat);
                        } else if (diagonality(matrix, size) == 2) {
                            int[] diag= new int[size];
                            diag=diagconverter(size,matrix);
                            scalar mat = new scalar(diag, size);
                            mat_list.add(mat);
                        } else if (diagonality(matrix, size) == 3) {
                            int[] diag= new int[size];
                            diag=diagconverter(size,matrix);
                            identity mat = new identity(diag, size);
                            mat_list.add(mat);
                        } else if (symmetry(matrix, size) == 1) {
                            symmetric_matrix mat = new symmetric_matrix(matrix, size);
                            mat_list.add(mat);
                        } else if (symmetry(matrix, size) == 2) {
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
                        } else if (det(matrix, size) == 0) {
                            System.out.println("in det 0");
                            singular_matrix mat = new singular_matrix(matrix, size);
                            mat_list.add(mat);
                            break;
                        } else if (size > 1) {
                            System.out.println("in square");
                            square mat = new square(matrix, size);
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
                            int[] di= new int[row];
                            di=diagconverter(row,created_mat);
                            diagonal_matrix diag1 = new diagonal_matrix(di, row);
                            mat_list.add(diag1);
                            diag1.diag_display();
                            break;
                        case 11:
                            System.out.println("enter scalar value");
                            int val = sc.nextInt();
                            created_mat = c_diagonal(row, val);
                            int[] di1= new int[row];
                            di1=diagconverter(row,created_mat);
                            scalar diag2 = new scalar(di1, row);
                            mat_list.add(diag2);
                            diag2.diag_display();
                            break;
                        case 12:
                            created_mat = c_diagonal(row, 1);
                            int[] di2= new int[row];
                            di2=diagconverter(row,created_mat);
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

                    }

                    break;
                case 3:
                    System.out.println("Choose matrix id to change");
                    int mat_id=sc.nextInt();
                    mat_list.get(mat_id).setMatrix();

                    break;
                case 4:
                    System.out.println("Enter id of the matrix");
                    int choose_id = sc.nextInt();
                    mat_list.get(choose_id).getType();

                    break;
                case 5:

                    System.out.println("Choose operation to perform");
                    System.out.println("1. Perform addition.\n" +
                            "2. Perform subtraction\n" +
                            "3. Transpose multiplication.\n" +
                            "4. Inverse division.");
                    int operation = sc.nextInt();
                    System.out.println("Choose two matrices id");
                    int choose_id_ = sc.nextInt();
                    int choose_id_2 = sc.nextInt();


                    break;
                case 6:
                    System.out.println("Enter id of the matrix");
                    int choose_id_new = sc.nextInt();
                    int c=mat_list.get(choose_id_new).getColumns();
                    int r=mat_list.get(choose_id_new).getRows();

                    int[][] balh;
                    balh= mat_list.get(choose_id_new).getMatrix();
                    for (int i=0;i<r;i++){
                        for (int j=0;j<c;j++){
                            System.out.println(balh[i][j]);
                        }
                    }
                    break;
                case 7:
                    System.out.println("Enter id of the matrix");
                    int choose_id_t = sc.nextInt();
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
                    int choose_id_3 = sc.nextInt();
                    mat_list.get(choose_id_3).addtranspose();

                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
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

    static void getCofactor(int mat[][], int temp[][], int p, int q, int n) {
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

    static int det(int mat[][], int size) {
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
        for (int i=0;i<size;i++){
            int num;
            if (val==0){
                Random rand = new Random();
                num= 1 + rand.nextInt(10);
            }else if (val==1){
             num=1;
            }else num=val;
            create[i][i]=num;

        }

    return create;
    }


    static int[] diagconverter(int size,int[][] matrix){
    int[] diag=new int[size];
        for (int i=0;i<size;i++){
            diag[i]=matrix[i][i];
        }
       return diag;
    }
}



//a-loe-u
/*for (int i=0;i<row;i++){
        for (int j=0;j<col;j++){
        System.out.print(created_mat[i][j]);
        }
        System.out.println();
        } */
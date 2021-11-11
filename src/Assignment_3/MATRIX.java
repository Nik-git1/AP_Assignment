package Assignment_3;


import java.util.ArrayList;

public class MATRIX {
    protected int rows;
    protected int columns;
    protected int[][] matrix;
    protected int[] diag;
    protected static int count = 0;
    protected int id;
    protected ArrayList<String> typelist;
    protected int size = 0;

    protected  MATRIX(int[][] matrix, int rows, int columns) {
        this.matrix = new int[rows][columns];
        id = count;
        count++;
        this.matrix = matrix;
    }

    protected MATRIX(int[][] matrix, int size) {
        this.matrix = new int[size][size];
        id = count;
        count++;
        this.matrix = matrix;
    }

    protected  MATRIX(int size, int[] matrix) {//for diagonal
        this.diag = new int[size];
        this.size = size;
        id = count;
        count++;

    }

    protected  void setmat() {
        this.matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    this.matrix[i][j] = diag[i];
                } else
                    this.matrix[i][j] = 0;
            }
        }

    }

    protected void display() {
    }

    public int value(){
        return this.matrix[0][0];
    }

    void diag_display() {
    }



    protected  void getType() {
        for (int i = 0; i < typelist.size(); i++) {
            System.out.println(typelist.get(i));
        }
    }

    protected  int[][] getMatrix() {
        if (this.matrix == null) {
            setmat();
        }
        return matrix;
    }

    protected  int getSize() {
        return size;
    }

    protected  void transpose() {
        if (this.matrix == null) {
            setmat();
        }

        if (size != 0) {
            int[][] transpose = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    transpose[j][i] = matrix[i][j];
                }
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.println(transpose[j][i]);
                }
            }
        } else
            System.out.println("cant perform on non square matrix");
    }

    protected  void addtranspose() {

        if (this.matrix == null) {
            setmat();
        }
        if (size != 0) {
            int[][] transpose = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    transpose[j][i] = matrix[i][j];
                }
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.println(transpose[i][j] + matrix[i][j]);
                }
            }

        } else
            System.out.println("cant perform on non square matrix");

    }

    protected  void labelfinder(String label) {
        if (typelist.contains(label)) {
            display();
        }
    }

    protected  void mean(int r_c) {

        if (this.matrix == null) {
            setmat();
        }
        if (size != 0) {
            rows = size;
            columns = size;
        }

        if (r_c == 1) {
            for (int i = 0; i < rows; i++) {
                int sum = 0;
                for (int j = 0; j < columns; j++) {
                    sum += matrix[i][j];
                }
                System.out.println((float) sum / columns);
            }
        } else if (r_c == 2) {
            for (int i = 0; i < rows; i++) {
                int sum = 0;
                for (int j = 0; j < columns; j++) {
                    sum += matrix[j][i];
                }
                System.out.println((float) sum / rows);
            }
        } else {
            int sum = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    sum += matrix[j][i];
                }
            }
            System.out.println((float) (sum / (rows * columns)));
        }
    }

    protected  void setMatrix() {
        if (this.matrix == null) {
            setmat();
        }
        if (size != 0) {
            rows = size;
            columns = size;
        }
        ArrayList<String> forbidden = new ArrayList<String>();
        forbidden.add("Null matrix");
        forbidden.add("Ones matrix");
        forbidden.add("Identity matrix");
        int flag = 1;
        for (int i = 0; i < forbidden.size(); i++) {
            if (typelist.contains(forbidden.get(i))) {
                flag = -1;
                System.out.println("Cant manipulate");
                break;
            } else if (typelist.contains("Diagonal matrix")) {
                flag = 2;
            }
        }

        if (typelist.contains("Singular matrix")) {
            for (int i = 0; i < rows; i++) {
                matrix[0][i] = 0;
            }
        }
        if (flag == 2) {
            for (int i = 0; i < rows; i++) {
                diag[i]++;
            }
        }
        if (flag == 1) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (matrix[i][j] != 0) {
                        matrix[i][j]++;
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println(matrix[i][j]);
            }
        }

    }

    protected  int det() {
        int det = 1;
        if (this.matrix == null) {
            for (int i = 0; i < size; i++) {
                det *= diag[i];
            }
            return det;
        }

        if (size == 1) {
            System.out.println(matrix[0][0]);
        } else if (size == 2) {
            det = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        } else if (size == 3) {
            int x = (matrix[1][1] * matrix[2][2]) - (matrix[2][1] * matrix[1][2]);
            int y = (matrix[1][0] * matrix[2][2]) - (matrix[2][0] * matrix[1][2]);
            int z = (matrix[1][0] * matrix[2][1]) - (matrix[2][0] * matrix[1][1]);

            det = (matrix[0][0] * x) - (matrix[0][1] * y) + (matrix[0][2] * z);

        } else System.out.println("Only square matrices have determinant");
        return det;
    }

    protected  float[][] inverse() {
        if (this.matrix == null) {
            setmat();
        }

        int det = det();
        float mat[][] = new float[size][size];
        float inv_mat[][]= new float[size][size];
        float temp;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mat[i][j] = (float) matrix[i][j];
            }
        }

        if (size == 1) {
            System.out.println(1 / mat[0][0]);
        } else if (size == 2) {
            temp = mat[0][0];
            mat[0][0] = mat[1][1];
            mat[1][1] = temp;
            mat[0][1] = -mat[0][1];
            mat[1][0] = -mat[1][0];

            for (int i = 0; i < size; ++i) {
                for (int j = 0; j < size; ++j)
                    inv_mat[i][j]= (mat[i][j] / det);

            }
        } else if (size == 3) {
            for (int i = 0; i < size; ++i) {
                for (int j = 0; j < size; ++j)
                   inv_mat[i][j]=((  (mat[(j + 1) % 3][(i + 1) % 3] * mat[(j + 2) % 3][(i + 2) % 3]) - (mat[(j + 1) % 3][(i + 2) % 3] * mat[(j + 2) % 3][(i + 1) % 3])) / det);
            }
        }
    else System.out.println("Only square matrices have determinant");

    return inv_mat;
}

}





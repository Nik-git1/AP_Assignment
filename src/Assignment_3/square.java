package Assignment_3;

import java.util.ArrayList;

public class square extends MATRIX {
    private String type = "Square matrix";

    protected  square(int[][] matrix, int size) {
        super( matrix, size);
        typelist = new ArrayList<String>();
        this.size = size;
        this.matrix = matrix;
        typelist.add(type);
    }
    protected  square(int[] matrix, int size) {
        super(size,matrix);
        typelist = new ArrayList<String>();
        this.size = size;
        this.diag = diag;
        typelist.add(type);
    }

    protected void display() {
        System.out.println("id= " + id);
        for (int k = 0; k < typelist.size(); k++) {
            System.out.println(typelist.get(k));
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
    protected void diag_display() {
        System.out.println("id= " + id);
        for (int k = 0; k < typelist.size(); k++) {
            System.out.println(typelist.get(k));
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i==j){
                    System.out.print(diag[i]);
                }else
                    System.out.print("1");
            }
            System.out.println();
        }
    }
}

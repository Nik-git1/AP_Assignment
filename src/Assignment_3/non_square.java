package Assignment_3;



import java.util.ArrayList;

public class non_square extends MATRIX{
    String type="Rectangular matrix";

    public non_square(int[][] matrix, int rows, int columns) {
        super(matrix,rows,columns);
        typelist= new ArrayList<String>();
        this.rows=rows;
        this.columns=columns;
        this.matrix=matrix;
        typelist.add(type);
    }

    void display(){
        System.out.println("id= "+id);
        for (int k=0;k<typelist.size();k++){
            System.out.println(typelist.get(k));
        }
        for ( int i =0 ;i<rows; i++){
            for (int j =0;j<columns;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();
    }





}

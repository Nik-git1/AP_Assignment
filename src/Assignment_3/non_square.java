package Assignment_3;


public class non_square extends MATRIX{



    public non_square(int[][] matrix, int rows, int columns) {
        super(id,matrix,rows,columns);
        this.rows=rows;
        this.columns=columns;
        this.matrix=matrix;
        this.type="Rectangular";
    }

    void display(){
        System.out.println(id+" "+type);
        for ( int i =0 ;i<rows; i++){
            for (int j =0;j<columns;j++){
                System.out.print(matrix[i][j]);
            }
        }
        System.out.println("over" );
    }





}

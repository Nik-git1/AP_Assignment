package Assignment_3;


public class row_matrix extends non_square {

    public row_matrix(int[][] matrix, int rows, int columns) {
        super(matrix,rows,columns);
        this.rows=1;
        this.columns=columns;
        this.matrix=matrix;
        this.type="Row matrix";
    }

    public void display(){
        System.out.println(id+" "+type);
        for ( int i =0 ;i<rows; i++){
            for (int j =0;j<columns;j++){
                System.out.print(matrix[i][j]);
            }
        }
        System.out.println("over" );
    }


}

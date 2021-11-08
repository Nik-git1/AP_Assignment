package Assignment_3;


public class column_matrix extends  non_square{


    public column_matrix(int[][] matrix, int rows,int columns) {
        super(matrix,rows,columns);
        this.columns=1;
        this.matrix=matrix;
        this.type="Column matrix";
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

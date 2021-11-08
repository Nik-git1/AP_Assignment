package Assignment_3;


public class column_matrix extends non_square{
    String type="Column Matrix";

    public column_matrix(int[][] matrix, int rows,int columns) {
        super(matrix,rows,columns);
        this.columns=1;
        this.rows=rows;
        this.matrix=matrix;
        typelist.add(type);
    }

}

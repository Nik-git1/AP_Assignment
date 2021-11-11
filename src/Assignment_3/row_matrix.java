package Assignment_3;


public class row_matrix extends non_square {
    private String type="Row matrix";

    public row_matrix(int[][] matrix, int rows, int columns) {
        super(matrix,rows,columns);
        this.rows=1;
        this.columns=columns;
        this.matrix=matrix;
        typelist.add(type);
    }



}

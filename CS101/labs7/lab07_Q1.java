/**
 * lab07_Q1
 */
public class lab07_Q1 
{
    public static void main(String[] args) 
    {
        //We define intial matrixs
        int [][] matrix1 = {{1,2,3},{2,1,2},{3,2,1}};
        int [][] matrix2 = {{1,2,3},{2,1,2},{4,5,6}};
        int [][] matrix3 = {{1,2},{3,4},{5,6}};

        //We print the matrix by calling the methods
        System.out.println("Initially matrix 1 is: ");
        printMatrix(matrix1);
        System.out.println("Initially matrix 2 is: ");
        printMatrix(matrix2);
        System.out.println("Initially matrix 3 is: ");
        printMatrix(matrix3);

        //We print the transposed matrix by calling the methods
        System.out.println("After transpose matrix 1 is: ");
        transposeMatrix(matrix1);
        System.out.println("After tranpose matrix 2 is: ");
        transposeMatrix(matrix2);
        System.out.println("After transpose matrix 3 is: ");
        transposeMatrix(matrix3);

        //We print if the matrix and transposed one is symmetric by calling the methods
        System.out.println("Is matrix 1 symmetric: " + isSymmetric(matrix1));
        System.out.println("Is matrix 2 symmetric: " + isSymmetric(matrix2));
        System.out.println("Is matrix 3 symmetric: " + isSymmetric(matrix3));

        //We print if the sum of diagonals are equal by calling methods
        System.out.println("Is sum of diagonals of matrix 1 equals: " + isDiagonalSumEqual(matrix1));
        System.out.println("Is sum of diagonals of matrix 2 equals: " + isDiagonalSumEqual(matrix2));
        System.out.println("Is sum of diagonals of matrix 3 equals: " + isDiagonalSumEqual(matrix3));

    }
    /**
     * This method prints the given matrix
     * @param matrix
     */
    public static void printMatrix(int [][] matrix)
    {
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();

        }
    }
    /**
     * This method transpose the given matrix
     * @param matrix
     * @return
     */
    public static int[][] transposeMatrix(int[][] matrix)
    {
        for(int i=0; i<matrix[0].length; i++)
        {
            for(int j=0; j<matrix.length; j++)
            {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
        return matrix;
    }
    /**
     * This method decides whether the matrix is equal to its transposed version
     * @param matrix
     * @return
     */
    public static boolean isSymmetric(int [][] matrix)
    {
        if(matrix.length != matrix[0].length)
        {
            return false;
        }
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                if(matrix[i][j] != matrix[j][i])
                {
                    return false;
                }
            }
        }
        return true;       
    }
    /**
     * This method calculates whether the sum of diagonal and anti digonals are equal
     * @param matrix
     * @return
     */
    public static boolean isDiagonalSumEqual(int [][] matrix)
    {
        int diagonal = 0;
        for(int i=0; i<matrix.length; i++)
        {
            diagonal += matrix[i][i];
        }

        int antiDiagonal = 0;
        int j=matrix[0].length-1;
        for(int i=0; i<matrix.length; i++)
        {   
            antiDiagonal += matrix[i][j];
            j--;        
        }
        return (diagonal==antiDiagonal);
    }
}
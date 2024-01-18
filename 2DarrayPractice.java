public class array2DPractice {


    public static int numberof7s(int array[][]){
        int sum = 0;
        for(int i = 0; i <array.length; i++) {
            for(int j = 0; j <array[0].length; j++) {
                if(array[i][j] == 7) {;
                sum++;
            }
        }
            
        }
        return sum;
    }

    public static int sumOfSecondRow(int nums[][]) {
        int sum = 0;
        int i = 1;
        
            for(int j = 0; j<nums[0].length; j++) {
            sum += nums[i][j];
            }
        
        return sum;
    }

    

    public static void printMatrix(int matrix[][]) {
        System.out.println("The matrix is: " );
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // int array[][] = {{4, 7, 8},
        //                 {8, 8, 7}};
        
        // System.out.println(numberof7s(array));

        // int nums[][] = {{1, 4, 9},
        //                 {11, 4, 3},
        //                 {2, 2, 3}};
        // System.out.println(sumOfSecondRow(nums));

        int matrix[][]= {{2, 3, 7},
                        {5, 6, 7}};
        int row = 2, col = 3;
        //display original matrix
        printMatrix(matrix);

        //transpose the matrix
        int transpose[][] = new int[col][row];
        
        for(int i = 0; i<row; i++) {
            for(int j = 0; j<col; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        printMatrix(transpose);



    }
}

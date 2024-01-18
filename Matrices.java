import java.util.Scanner;

public class Matrices {


    public static boolean search(int matrix[][], int key){
        
    for(int i = 0; i<matrix.length; i++) { //for traversing rows
        for(int j = 0; j<matrix[0].length; j++) { //for traversing coloumns
            if( matrix[i][j] == key) {
                System.out.println("The key found at "+ "("+ i + "," +j+")");
                return true;
            } 
        }
       
    }
    System.out.println("Key NOT found");
    return false;

}

    public static void largest(int matrix[][]) {
        
        
    for(int i = 1; i<matrix.length; i++) { //for traversing rows
        for(int j = 1; j<matrix[0].length; j++) { //for traversing coloumns
             if(matrix[i][j] > matrix[i-1][j-1]) {
                System.out.println("The largest no. is: " + matrix[i][j]);
             }
             if (matrix[i][j] < matrix[i-1][j-1]) {
                System.out.println("The smallest is: " + matrix[i][j]);
             }
        }
        System.out.println();
    }
    }

    public static void printSpiral(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        //condition
        while(startRow <= endRow && startCol <= endCol) {
            //top
            for(int j = startCol; j<=endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }

            // right
            for(int i = startRow+1; i<=endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }

            //bottom
            for(int j = endCol-1; j >= startCol; j--) {
                if(startRow == endRow) {
                    //if nxm is odd then the single last cell
                    //will be printed to avoid that condition 
                    //when startrow = endrow we break the loop;
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }

            //left
            for(int i = endRow-1; i >= startRow+1; i--) {
                if(startCol == endCol) {
                    //if nxm is odd then the single last cell
                    //will be printed to avoid that condition 
                    //when startcol = endcol we break the loop;
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }

    public static int diagonalSum(int matrix[][]) {
        int sum = 0;
        // // for primary diagonal
        // for(int i = 0; i<matrix.length; i++) {
        //     for(int j = 0; j<matrix[0].length; j++) {
        //         if( i == j) {
        //             sum += matrix[i][j];
        //         }
        //         else if (i+j == matrix.length-1) {
        //             sum += matrix[i][j];
        //         }
        //     }
        // }
        // return sum;

        for(int i = 0; i<matrix.length; i++) {
            //primary diagonal
            sum += matrix[i][i];
            //secondary diagonal
            if( i != matrix.length-1-i) //for odd matrix last cell
            sum += matrix[i][matrix.length-1-i];
        }
        return sum;
    }

    public static boolean staircaseSearch(int matrix[][], int key) {
        int row =matrix.length-1;
        int col = 0;

        while( row >= 0 && col <matrix[0].length) {
            if( matrix[row][col] == key) {
                System.out.println("Key found at: "+ "(" + row + "," + col + ")");
                return true;
            }

            else if( key < matrix[row][col]) {
                row--; // here we will move left
            }

            else {
                col++; // here we will move down
            }
        }
        System.out.println("Key not found");
        return false;
    }
    
    
    
    public static void main(String[] args) {
        int matrix[][] = {{10, 20, 30, 40},
                          {15, 25, 35, 45},
                          {27, 29, 37, 48},
                          {32, 33, 39, 50}};
        int key = 33;
       // printSpiral(matrix);
       //System.out.println(diagonalSum(matrix));
       staircaseSearch(matrix, key);
    }
       

    
}

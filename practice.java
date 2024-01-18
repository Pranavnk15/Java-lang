import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.transform.stream.StreamSource;

import java.util.*;

public class practice {

    public static void search(int matrix[][], int key) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == key) {
                    System.out.println("The key found at: " + " (" + i + ", " + j + ")");
                }
            }
        }
    }

    public static void printSpiral(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        while(startRow <= endRow && startCol <= endCol) {
            //top
            for(int i = startCol; i<=endCol; i++) {
                System.out.print(matrix[startRow][i] + " ");
            }
            //right
            for(int i = startRow+1; i<= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            //bottom
            for(int i = endCol-1; i>=startCol; i--) {
                if(startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][i] + " ");
            }
            //left
            for(int i = endRow-1; i>=startRow; i--) {
                if(startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

    }

    public static void diagSum(int matrix[][]) {
       

        int sum = 0;
        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j<matrix[i].length; j++) {
                if(i == j) {
                    sum += matrix[i][j];
                } else if((i+j) == matrix.length-1) {
                    sum += matrix[i][j];
                }
            }
        }
        System.out.println(sum);
    }

    public static boolean stairCaseSearch(int matrix[][], int key) {
        int row = 0;
        int col = matrix[0].length-1;

        while(row <matrix.length && col >=0) {
            if(matrix[row][col] == key) {
                System.out.println("key found at cell: " + "( " + row+", "+col+")");
                return true;
            }

            if(key < matrix[row][col]) {
                col--;
            }
            if(key > matrix[row][col]) {
                row++;
            }
        }
        System.out.println("Key not found");
        return false;
    }

    public static void count(int arr[][], int key) {
        int count = 0;
        for(int i = 0; i<arr.length; i++) {
            for(int j = 0; j<arr[i].length; j++) {
                if(arr[i][j] == key) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static void sum(int arr[][]) {
        int sum = 0;
        for(int i = 0; i<arr.length; i++) {
            for(int j = 0; j<arr[0].length; j++) {
                if(i == 1 ) {
                    sum += arr[i][j];
            }
            }
        }
        System.out.println(sum);
    }
    public static void transpose(int arr[][]) {
        for(int i = 0; i<arr.length; i++) {
            for(int j = 0; j<arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i = 0; i<arr.length; i++) {
            for(int j = 0; j<arr[i].length; j++) {
                arr[j][i] = arr[i][j];
            }
        }
        for(int i = 0; i<arr.length; i++) {
            for(int j = 0; j<arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    public static void print(int arr[][]) {
        for(int i = 0; i<arr.length; i++) {
            for(int j = 0; j<arr[i].length; j++) {
                System.out.print(" "+ arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void replace(int arr[][]) {
        for(int i = 0; i<arr.length; i++) {
            for(int j = 0; j<arr[i].length; j++) {
                if(arr[i][j] == 0) {

                    //row replace
                    for(int k = 0; k<arr[0].length; k++) {
                        arr[i][k] = 0;
                    }
                    // coloumn replcae
                    for(int l = 0; l<arr.length; l++) {
                        arr[l][j] = 0;
                    }
                }
            }
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l1 = new ArrayList<>();
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        while(startRow <= endRow && startCol <=endCol) {
            //top
            for(int i = startCol; i<=endCol; i++) {
                l1.add(matrix[startRow][i]);
            }
            startRow++;
            //right
            for(int i = startRow; i<=endRow; i++) {
                l1.add(matrix[i][endCol]);
            }
            
            endCol--;

            //bottom
            for(int i = endCol; i>=startCol; i--) {
                if(startRow == endRow) {
                    break;
                }
                l1.add(matrix[endRow][i]);
            }
            endRow--;
            //left
            for(int i = endRow; i>=startRow; i--) {
                // if(startCol == endCol) {
                //     break;
                // }
                 l1.add(matrix[i][startCol]);
            }
            startCol++;
           
            
            
           
        }
        return l1;
    }
    // while(startRow <= endRow && startCol <= endCol) {
    //     //top
    //     for(int i = startCol; i<=endCol; i++) {
    //         System.out.print(matrix[startRow][i] + " ");
    //     }
    //     //right
    //     for(int i = startRow+1; i<= endRow; i++) {
    //         System.out.print(matrix[i][endCol] + " ");
    //     }
    //     //bottom
    //     for(int i = endCol-1; i>=startCol; i--) {
    //         if(startRow == endRow) {
    //             break;
    //         }
    //         System.out.print(matrix[endRow][i] + " ");
    //     }
    //     //left
    //     for(int i = endRow-1; i>=startRow; i--) {
    //         if(startCol == endCol) {
    //             break;
    //         }
    //         System.out.print(matrix[i][startCol] + " ");
    //     }

    public static String removeReverse(String S) 
    { 
        // code here
        StringBuilder ans = new StringBuilder();
        StringBuilder str1 = new StringBuilder();
        str1.append(S);
        for(int i = 0; i<str1.length(); i++) {
            for(int j = i+1; j<str1.length(); j++) {
                if(str1.charAt(i) == str1.charAt(j)) {
                    // System.out.println(S.charAt(i));
                    // System.out.println(S.charAt(j));
                    String str = str1.substring(i+1, str1.length()-1);
                    System.out.println(str);
                    str1.replace(0, str1.length()-1, str);
                    System.out.println(str1.toString());
                    str1.reverse();
                    ans.append(str1);
                }
            }
        }
        return ans.toString();
    }
    public static long solve(int N, int [] arr){
        //Write your Code here
        Arrays.sort(arr);
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int maxVar = 0;
        for(int i = 0; i<arr.length; i++) {
            if(smallest > arr[i]) {
                smallest = arr[i];
            }
            if(largest < arr[i]) {
                largest = arr[i];
            }
        }
        System.out.println("largest"+largest);
        System.out.println("smallest"+smallest);
        int prefixSum[] = new int[arr.length];
        prefixSum[0] = arr[0];
        for(int i = 1; i<arr.length; i++) {
            prefixSum[i] = arr[i] + prefixSum[i-1];
        }
        if(prefixSum[prefixSum.length-1] > arr[arr.length-1]) {
            arr[arr.length-1] = prefixSum[prefixSum.length-1];
        }
        if(largest < arr[arr.length-1]) {
            largest = arr[arr.length-1];
        }
        maxVar = largest - smallest;
        return maxVar;

    }
    public static void rotate(int[][] matrix) {
        for(int i = matrix.length-1; i>= 0; i--) {
            for(int j = matrix[i].length-1; j>= 0; j--) {
                
            }
        }
    }
    public static void main(String[] args) {
        int N = 5;
        int arr[] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(solve(N, arr));

       
    }

}

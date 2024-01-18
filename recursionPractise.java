import java.util.*;

import org.w3c.dom.css.Counter;

public class recursionPractise {

    public static void printDecOrder(int n) {
        //base case
        if( n == 1) {
            System.out.print(n);
            return;
        }
        
        System.out.print(n + " ");
        printDecOrder(n-1);
    }
    public static void printIncOrder(int n) {
        if( n == 1) {
            System.out.print(n + " ");
            return ;
        }
        printIncOrder(n-1);
        System.out.print(n + " ");
    }
    
    public static int factorial(int n) {
        
        //base case
        if(n == 1) {
            return 1;
        }
        int fact = n * factorial(n-1);
        return fact;
    }

    public static int sum(int n) {
        //base case 
        if(n == 1) {
            return 1;
        }
        int sum = n + sum(n-1);
        return sum;
    }

    public static int fibonacii(int n) {
        //base case
        if(n == 0 || n == 1) {
            return n;
        }
        int fib = fibonacii(n-1)+fibonacii(n-2);
        return fib;
    }

    public static boolean isSorted(int arr[], int si) {
        //base case
        if(arr[si] <= arr.length-1) {
            return true;
        }
        if(arr[si] > arr[si+1]) {
            return false;
        } 
        return isSorted(arr, si+1);
    }

    public static int firstOccurence(int arr[],int tar,int i) {
        //base case
        if(i == arr.length) {
            return -1;
        }
        if( arr[i] == tar) {
            return i;
        }
        return firstOccurence(arr, tar, i+1);
    }

    public static int lastOccurence(int arr[], int key, int i) {
        //base case
        if(i == arr.length) {
            return -1;
        }
        if(arr[i] == key) {
            return i;
        }
        return lastOccurence(arr, key, i-1);
    }

    public static int power(int x, int n) {
        //base case
        if( n == 0) {
            return 1;
        }
        int result = x*power(x, n-1);
        return result;



    } 

    public static void occurences(int arr[], int key, int i) {
        //base case
        if(i == arr.length) {
            return ;
        }
        //recursion
        if(arr[i] == key) {
            System.out.print(i + " ");
        }
        occurences(arr, key, i+1);



    }
    static String digits[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static void printDigits(int numbers) {
        //base case
        if(numbers == 0) {
            return ;
        }
        int lastDigit = numbers%10;
        printDigits(numbers/10);
        System.out.print(digits[lastDigit] + " ");
    }

    public static int lengthOfString(String str) {
        //base case
        if(str.length() == 0) {
            return 0;
        }
        //recursion
        return lengthOfString(str.substring(1))+1;
    }
    
    public static int countSubsttr(String str, int i, int j, int n) {
        if(n == 1) {
            return 1;
        }
        if(n <= 0) {
            return 0;
        }

        int res = countSubsttr(str, i+1, j, n-1) + countSubsttr(str, i, j-1, n-1) - countSubsttr(str, i+1, j-1, n-2);
        if(str.charAt(i) == str.charAt(j)) {
            res++;
        }
        return res;
    }

    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        if(n == 1) {
            System.out.println("transer disk " + n + " from " + src + " to " + dest);
            return;
        }
        //transfer top n-1 from src to helper using dest as 'helper'
        towerOfHanoi(n-1, src, dest, helper);
        //transfer nth from src to dest
        System.out.println("tranfer disk " + n + " from " + src + " to " + helper);
        //trnafer n-1 from helper to dest using as 'helper'
        towerOfHanoi(n-1, helper, src, dest);
    }
       public static void main(String[] args) {
        //int n = 10;
       // printDecOrder(n);
        //printIncOrder(n);
        //System.out.println(factorial(5));
        //System.out.println(sum(5));
        //System.out.println(fibonacii(3));
        //int arr[] = {1, 2, 3, 4,  2, 5};
        //System.out.println(isSorted(arr, 0));
       // System.out.println(firstOccurence(arr, 5, 0));
       //System.out.println(lastOccurence(arr, 2, arr.length-1));
       //System.out.println(power(2, 10));

    //    int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2 };
    //    int key = 2;

    //    occurences(arr, 2, 0);
    //    System.out.println();

       
        //printDigits(1947);


        // String str = "acbde";
        // System.out.println(lengthOfString(str));

        // String str = "abcab";
        // int n = str.length();
        // System.out.println(countSubsttr(str, 0, n-1, n) );

        int n  = 3;
        towerOfHanoi(n, "A", "B", "C");

    }
}

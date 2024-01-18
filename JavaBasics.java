
import java.util.*;

import javax.sql.rowset.spi.SyncResolver;
import javax.xml.parsers.FactoryConfigurationError;
public class JavaBasics {
    

    public static  void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a is : " + a);
        System.out.println("b is : " + b);
        
    }

    public static int product(int a , int b ) {
        int result = a * b;
        
        return result;
    }

    public static int factorial(int n) {
        int f = 1;
        for(int i =1; i <=n ; i++) {
            f = f * i;
        }
        return f;
    }

    public static int binomialCoefficient(int n, int r) {

       int fact_n = factorial(n);
       int fact_r = factorial(r);
       int fact_nmr = factorial(n-r);

       int result = fact_n/(fact_r* fact_nmr);
       return result;

    }

    public static int sum(int a , int b) {
        return a + b;
    }

    public static float sum(float a, float b) {
        return a + b ;
    }

    // public static boolean isPrime(int n) {
    //     // corner cases for n = 2
    //     if ( n == 2) {
    //         return true;
    //     }
        
    //     for (int i = 2; i<= n-1; i++) {
    //         if(n % i == 0) {
                
    //             return false;
    //         }
            
    //     }
    //     return true;

    // }

    public static boolean isPrime(int n ) {
        for( int i =2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void primesInRange(int n ) {
        for( int i = 2; i <= n; i++) {
            if(isPrime(i)) {
                System.out.println(i+" ");
            }
        }
        System.out.println();
    }

    public static void binToDec(int binNum) {
        int myNum = binNum;
        int pow = 0;
        int dec = 0;

        while(binNum > 0){
            int lastDigit = binNum % 10;
            dec = dec + (lastDigit * (int)Math.pow(2, pow));
            pow++;
            binNum = binNum / 10;
        }
        System.out.println("decimal of " + myNum + "=" + dec);
    }   

    public static void decToBin(int n) {
        int myNum = n;
        int pow = 0;
        int binNum = 0;

        while ( n> 0) {
            int rem = n % 2;
            binNum = binNum + (rem * (int)Math.pow(10, pow));

            pow++;
            n = n/2;
        }
        System.out.println("binary form of " + myNum + " = " + binNum);
    }

    public static int avg(int a, int b , int c) {
        return a+b+c/3;
    }

    public static void isEven(int n) {
        if(n % 2 == 0) {
            System.out.println("Is even");

        } else {
            System.out.println("Is Odd");
        }
    }

    public static void ispalindrome(int n) {
        int rev = 0;
        int rem = 0;
        while( n !=0) {
            rem = n % 10;
            rev = rev * 10 + rem;
            n = n/10;
        }
        if ( n == rev) {
            System.out.println("Is palindromee");
        }else {
            System.out.println("Not a palindrome");
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        
        ispalindrome(121);
        
    }
}
//boilerplate code

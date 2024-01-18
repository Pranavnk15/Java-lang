import java.util.concurrent.RunnableFuture;
import java.util.random.RandomGenerator.LeapableGenerator;

public class RecursionBasics {

    public static void printDec(int n) {

        //base case
        if( n == 1) {
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        printDec(n-1);
    }

    public static void printInc(int n) {
        //base case
        if(n == 1) {
            System.out.print(n + " ");
            return;
        }
        printInc(n-1);
        System.out.print(n + " ");
    }

    public static int factorial(int n) {
        int fact;
        //base case
        if(n == 0) {
            return n = 1;
            
        }
        fact = n*factorial(n-1);
        return fact;

    }

    public static int sumOfn(int n) {
        int sum;
        //base case
        if( n == 0) {
            return 0;
        }
        sum = n + sumOfn(n-1);
        return sum;
    }

    public static int fib(int n) {
        int fib;
        //base case
        if(n==0 || n == 1) {
            return n;
        }
        fib = fib(n-1)+fib(n-2);
        return fib;
    }

    public static boolean isSorted(int arr[], int i) {
        if( i == arr.length-1) {
            return true;
        }
        if(arr[i] > arr[i+1]) {
            return false;
        }
        return isSorted(arr, i+1);
    }

    public static int firstOccurence(int arr[], int key, int i) {
          //base case
        if( i == arr.length) {
            return -1;
        }
      
        if(arr[i] == key) {
            return i;
        }

        return firstOccurence(arr, key, i+1);
    }

    public static int lastOccurence(int arr[], int key, int i) {
        //base case
        if( arr[i] == arr.length) {
            return -1;
        }
        int isFound = lastOccurence(arr, key, i+1);
        if(isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;

    }

    public static int power(int x, int n) {
        if(n == 0) {
            return 1;
        }
        //int xnm1 = power(x, n-1);
        //int xn = x*xnm1;
        //return xn;

        return x * power(x, n-1);
    }

    public static int optimizedPower(int a, int n) {
        if(n == 0) {
            return 1;
        }
        int halfPowerSq = optimizedPower(a, n/2) * optimizedPower(a, n/2);

        //n is odd
        if( n % 2 != 0) {
            halfPowerSq = a*halfPowerSq;
        }
        return halfPowerSq;
    }

    public static int tilingProblem(int n) {
        //base case
        if(n == 0 || n == 1) {
            return 1;
        }
        //vertical choice
        int fnm1 = tilingProblem(n-1);
        //horizontal choice
        int fnm2 = tilingProblem(n-2);

        int totWays = fnm1 + fnm2;
        return totWays;
    }

    public static void removeDuplicate(String str, int idx, StringBuilder newStr, boolean map[]) {
        if(idx == str.length()) {
            System.out.println(newStr);
            return ;
        }
        char currChar = str.charAt(idx);
        if(map[currChar-'a'] == true) {
            //dupplicate
            removeDuplicate(str, idx+1, newStr, map);
        } else {
            map[currChar-'a'] = true;
            removeDuplicate(str, idx+1, newStr.append(currChar), map);
        }
    }

    public static int friendsPairing(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        //choice
        //single
        int fnm1 = friendsPairing(n-1);
        //pair
        int fnm2 = friendsPairing(n-2);
        int pairWays = (n-1)* fnm2;
        //totWays
        int totWays = fnm1 + pairWays;
        return totWays;
    }

    public static void printBinString(int n, int lastPlace, String str) {
        //base case
        if(n == 0) {
            System.out.println(str);
            return ;
        }
        printBinString(n-1, 0, str+ "0");
        if(lastPlace == 0) {
            printBinString(n-1, 1, str+ "1");
        }
    }
    public static void main(String[] args) {
        int n = 10;
        //printDec(n);
        //printInc(n);
       // System.out.println(factorial(5));
       //System.out.println(sumOfn(5));
        //System.out.println(fib(3));
        // int arr1[] = {1,2,3,4,5};
        // int arr2[] = {5,4,3,2,1};
        // System.out.println(isSorted(arr1, 0));
        // System.out.println(isSorted(arr2, 0));
         int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 6};
        // System.out.println(firstOccurence(arr, 5, 0));
        //System.out.println(lastOccurence(arr, 5, 0));
       // System.out.println(power(2, 10));
        //System.out.println(optimizedPower(2, 5));
        //System.out.println(tilingProblem(3));
        // String str = "appnnacollege";
        // removeDuplicate(str, 0, new StringBuilder(""), new boolean[26]);
        //System.out.println(friendsPairing(3));
        printBinString(3, 0, "");
    }
}

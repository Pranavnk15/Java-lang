import java.util.Scanner;

public class practice {

    public static boolean prime(int n) {
        for(int i = 2; i <=Math.sqrt(n); i++) {
            if(n % 2 == 0 ) {
                return false;
            }
        }
        return true;
    }

   
    public static void main(String[] args) {
        int rows = 5;
        for(int i = 1; i<= rows; i++) {
            for(int j = 1; j<=i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        boolean result = prime(4);
        if(result == true) {
            System.out.println("The no. is prime");
        } else {
            System.out.println("The no. is not prime");
        }
        
    }
}

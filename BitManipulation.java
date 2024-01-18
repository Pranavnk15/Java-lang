import java.util.*;

public class BitManipulation {
    public static void oddEven(int n) {
        int bitMask = 1;
        if((n & bitMask) == 0) {
            //even number
            System.out.println("Even Number");
        } else {
            //odd number
            System.out.println("Odd number");
        }
    }

    public static int getIthBit(int n, int i) {
        int bitMask = 1<<i;
        if((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        int bitMask = 1<<i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1<<i);
        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        // if(newBit == 0) {
        //     return clearIthBit(n, i);
        // } else {
        //     return setIthBit(n, i);
        // }

        n = clearIthBit(n, i);
        int bitMask = newBit<<i;
        return n | bitMask;
    }

    public static int clearIBits(int n, int i) {
        int bitMask = (~0)<<i;
        return n & bitMask;
    }

    public static int clearBitsinRange(int n, int i, int j) {
        int a = ((~0) << (j+1));
        int b = (1<<i)-1;
        int bitMask = a | b;
        return n & bitMask;
    }

    public static boolean isPowerofTwo(int n) {
        return (n & (n-1)) == 0;
    }

    public static int countSetBits(int n) {
        int count = 0;
        while( n > 0) {
            if((n & 1) != 0) {
                //check out LSB
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    public static int fastExpo(int a, int n) {
        int ans = 1;

        while(n>0) {
            if((n&1) != 0) {
                //check LSb
                ans = ans * a;
            }
            a = a*a;
            n = n>>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        //System.out.println(5 & 6); //Binary AND
       // System.out.println(5 | 6); //Binary OR
        //System.out.println(5 ^ 6); //Binary XOR
        //System.out.println(~5); //Binary One's Complement
        //System.out.println(~0);
       // System.out.println(5<<2); // Binary Left Shift.
       //System.out.println(6>>1); // Binary Righ Shift.
    //    oddEven(3);
    //    oddEven(11);
    //    oddEven(14);
        //System.out.println(getIthBit(5, 2));
        //System.out.println(setIthBit(10, 2));
        //System.out.println(clearIthBit(10, 1));
        //System.out.println(updateIthBit(10, 2, 1));
        //System.out.println(clearIBits(15, 2));
        //System.out.println(clearBitsinRange(10, 2, 4));
        //System.out.println(isPowerofTwo(15));
        //System.out.println(countSetBits(10));
        System.out.println(fastExpo(3, 5));


        
    }
}

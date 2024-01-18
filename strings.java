import java.util.Scanner;

import javax.sql.rowset.spi.SyncResolver;
import javax.swing.plaf.synth.SynthSpinnerUI;

public class strings {

    public static void printChars(String str) {
        for(int i = 0; i<str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }


    public static boolean palindrome(String str) {
        int n = str.length();
        for(int i = 0; i<n/2; i++) {
            if(str.charAt(i) == str.charAt(n-1-i)) {
                return true;
            }
        }
        return false;
    }

    public static float getShortestPath(String path) {
        int x=0, y=0;
        for(int i = 0; i<path.length(); i++) {
            char dir = path.charAt(i);
            //NORTH
            if(dir == 'N') {
                y++;
            }
            //SOUTH
            else if(dir == 'S') {
                y--;
            }
            //EAST 
            else if(dir == 'E') {
                x++;
            }
            //WEST
            else {
                x--;
            }
        }
        int X2 = x*x;
        int Y2 = y*y;
        return (float)Math.sqrt(X2 + Y2);
    }

    public static String substring(String str, int si, int ei) {
        String substring = "";
        for(int i = si; i<ei; i++) {
            substring += str.charAt(i);
        }
        return substring;
    }

    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i = 1; i<str.length(); i++) {
            if(str.charAt(i) == ' ' && i<str.length()-1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String compress(String str) {
        String newStr = "";
        for(int i = 0; i<str.length(); i++) {
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            newStr += str.charAt(i);
            if(count > 1) {
                newStr += count.toString();
            }
        }
        return newStr;
    }

    public static String compress(String str) {
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i<str.length(); i++) {
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count > 1) {
                sb.append(count.toString());

            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
         // char arr[] {'a','b','c','d'};
    // String str = "abcd";
    // String str2 = new String("xyz@1234");

    // // STRINGS ARE IMMUTABLE

    // //INPUT/OUPUT
    // Scanner sc = new Scanner(System.in);
    // String name;
    // name = sc.nextline();
    // System.out.println(name);

    // String fulname = "Tony Stark";
    // int n = fulname.length();
    // System.out.println(n);

//     String fname = "Pranav";
//     String lname = "Khandagale";
//     String fullname = fname +" " + lname;
//    // System.out.println(fullname.charAt(0));
//     printChars(fullname);

    //     String str = "racecar";
    //    System.out.println(palindrome(str));
    //    ;
        
    // String path = "WNEENESENNNN";
    // System.out.println(getShortestPath(path));

    // String s1 = "tony";
    // String s2 = new String("tony");
    // if(s1.equals(s2)) {
    //     System.out.println("Strings are equal");
    // } else {
    //     System.out.println("Strings are not equal");
    // }

    // String str = "HelloWorld";
    // System.out.println(str.substring(0, 5));
    // //System.out.println(substring(str, 0, 5));

    // String fruits[] = {"apple", "mango", "banana"};
    // String largest = fruits[0];
    // for(int i =1; i<fruits.length; i++) {
    //     if(largest.compareTo(fruits[i]) < 0) {
    //         largest = fruits[i];
    //     }

    // }
    // System.out.println(largest);

    // StringBuilder sb = new StringBuilder("");
    // for(char ch='a'; ch<='z'; ch++) {
    //     sb.append(ch); //adds the element to the last of string
    // }
    // System.out.println(sb);

    // String str = "hi, i am pranav";
    // System.out.println(toUpperCase(str));

    String str = "aaabbcccdd";
    System.out.println(compress(str));
    }


















    
   
}

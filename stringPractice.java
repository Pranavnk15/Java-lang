import java.util.Scanner;
import java.util.Arrays;

public class stringPractice {

    public static void main(String[] args) {
        // String str = "ShradhaDidi";
        // String str1 = "ApnaCollege";
        // String str2 = "ShradhaDidi";
        // System.out.println(str.equals(str1) + " " + str.equals(str2));

        // String str = "ApnaCollege".replace("1", "");
        // System.out.println(str);

        // String str = new Scanner(System.in).nextLine();
        // int count = 0;

        // for(int i = 0; i<str.length(); i++) {
        //     char ch = str.charAt(i);
        //     if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
        //         count++;
        //     }
        // }
        // System.out.println("count of vowels is: " + count);

        String str1 = "earth";
        String str2 = "hearth";

        //convert Strings to lowercase. Why ? so that we have to not check
        //separetely for lower & uppercase.
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        //first check-if the lengths are equal or not
        if(str1.length() == str2.length()) {
        //convert strings into char array 
        char[] str1charArray = str1.toCharArray();
        char[] str2charArray = str2.toCharArray();
        //if the sorted char arrays are same or identical then they are anagram

        boolean result = Arrays.equals(str1charArray, str2charArray);
        if(result) {
            System.out.println(str1 + "and" + str2 +"are anagrams of each other.");
        } else {
            System.out.println(str1 + "and" + str2 + "are not anagrams of each other.");
            }
        }
        else {
            //case when lengths are not equal
            System.out.println(str1 + "and" + str2 + "are not anagrams of each other.");
        }
    }
}

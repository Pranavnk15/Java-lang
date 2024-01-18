import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import javax.management.monitor.MonitorSettingException;

public class arrayListPractice {

    public static boolean isMonotonic(ArrayList<Integer> list ) {
        boolean inc = true;
        boolean dec = true;
        for(int i = 0; i<list.size()-1; i++) {
            if(list.get(i) >= list.get(i+1)) {
                return false;
                
            }
            if(list.get(i) <= list.get(i+1)) {
                return false;
                
            }
            
        }
        return inc || dec;
    }

    public static ArrayList<Integer> findLonely(ArrayList<Integer> nums) {
        Collections.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i<nums.size()-1; i++) {
            if(nums.get(i-1) + 1 < nums.get(i) && nums.get(i) + 1 < nums.get(i+1)) {
                list.add(nums.get(i));
            }
        }
        if(nums.size() == 1) {
            list.add(nums.get(0));
        }
        if(nums.size() > 1) {
            if(nums.get(0) + 1 < nums.get(1)) {
                list.add(nums.get(0));
            }
            if(nums.get(nums.size()-2) +1 < nums.get(nums.size()-1)) {
                list.add(nums.get(nums.size()-1));
            }
        }
        return list;
    }

    public static int mostFrequent(ArrayList<Integer> nums, int key) {
        int[] result = new int[1000];

        for(int i = 0; i<nums.size()-1; i++) {
            if(nums.get(i) == key) {
                result[nums.get(i+1)-1]++;
            }
        }
        int max = Integer.MIN_VALUE;
        int ans = 0;

        for(int i = 0; i<1000; i++) {
            if(result[i] > max) {
                max = result[i];
                ans = i+1;
            }
        }
        return ans;
    }

    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);

        for(int i = 2; i<=n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(Integer e:ans) {
                if(2*e<=n)temp.add(e*2);

            }

            for(Integer e:ans) {
                if(2*e-1<=n)temp.add(e*2-1);
            }
            ans = temp;
        }
        return ans;
       
    }
    public static void main(String[] args) {
    //     ArrayList<Integer> list = new ArrayList<>();
    //     list.add(6);
    //     list.add(5);
    //     list.add(4);
    //     list.add(4);
    //    // list.add(3);
    //     System.out.println(isMonotonic(list));
    // ArrayList<Integer> nums = new ArrayList<>();
    // // nums.add(10);
    // // nums.add(6);
    // // nums.add(5);
    // // nums.add(8);
    // nums.add(1);
    // nums.add(3);
    // nums.add(5);
    // nums.add(3);
    // System.out.println(findLonely(nums));

    // ArrayList<Integer> nums = new ArrayList<>();
    // nums.add(1);
    // nums.add(100);
    // nums.add(200);
    // nums.add(1);
    // nums.add(100);
    // int key = 1;

    // System.out.println(mostFrequent(nums, key));

    int n = 4;
    System.out.println(beautifulArray(n));

        
    }
}

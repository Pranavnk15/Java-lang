
import java.util.ArrayList;
import java.util.Collections;

public class arrayList {

    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    // public static int storeWater(ArrayList<Integer> height) {
    //     int maxWater = 0;
    //     //Brute Force time-complexity== O(n^2)
    //     for(int i = 0; i<height.size(); i++) {
    //         for(int j = i+1; j<height.size(); j++) {
    //             int ht = Math.min(height.get(i), height.get(j));
    //             int width = j-i;
    //             int currWater = ht*width;
    //             maxWater = Math.max(maxWater, currWater);

    //         }
    //     }
    //     return maxWater;
    // }

    //2 pointer approach
    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;
        int lp = 0;
        int rp = height.size()-1;
        while(lp < rp) {
            //currwater
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currWater = ht*width;
            maxWater = Math.max(maxWater, currWater);

            //update pointer
            if(lp < rp) {
                lp++;
            } else {
                rp--;
            }

        }
        return maxWater;
    }

    // public static boolean pairSum1(ArrayList<Integer> list, int target) {
    //     for(int i = 0; i<list.size(); i++) {
    //         for(int j = i+1; j<list.size(); j++) {
    //             if(list.get(i)+list.get(j) == target) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;

    // }

    //2 pointer approach
    public static boolean pairsum1(ArrayList<Integer> list, int target) {
        int lp = 0;
        int rp = list.size()-1;
        //case1
        while(lp < rp) {
            if(list.get(lp) + list.get(rp) == target) {
                return true;
            }
            //case2
            if(list.get(lp) + list.get(rp) < target) {
                lp++;
            }
            //case3
            if(list.get(lp) + list.get(rp) > target) {
                rp--;
            }

        }
        return false;
    }

    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int bp = -1;
        int n = list.size();
        for(int i = 0; i<list.size(); i++) {
            if(list.get(i) > list.get(i+1)) {
                bp = i;
                break;
            }

        }
        int lp = bp+1; //smallest
        int rp = bp; //largest
        
        while(lp != rp) {
            //case1
            if(list.get(lp) + list.get(rp) == target) {
                return true;
            }
            //case2
            if(list.get(lp) + list.get(rp) < target) {
                lp = (lp+1) % n;
            }
            //case3
            if(list.get(lp) + list.get(rp) > target) {
                rp = (n+rp-1) % n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //defing arraylist
       // ArrayList<Integer> list = new ArrayList<>();
    //    // ArrayList<String> list2 = new ArrayList<>();
    //     ArrayList<Boolean> list3 = new ArrayList<>();

        // //OPERATIONS ON ARRAYLIST
        //ADD ELEMENT
        // list.add(1);
        //  list.add(2);
        //  list.add(3);
        //  list.add(4);
        //  list.add(5);
         //list.add(1, 9);
        // System.out.println(list);

        // //GET OPERATION
        // int element = list.get(2);
        // System.out.println(element);

        // //DELETE
        // list.remove(2);
        // System.out.println(list);

        // //SET ELEMENT AT INDEX
        // list.set(2, 10);
        // System.out.println(list);

        // //CONTAINS ELEMENT
        // System.out.println(list.contains(1));
        // System.out.println(list.contains(11));

        //SIZE OF AN ARRAYLIST
        // System.out.println(list.size());
        // for(int i = 0; i<list.size(); i++) {
        //     System.out.print(list.get(i) + " ");
        // }
        // System.out.println();

        //REVERSE OF ARRAYLIST
        // for(int i = list.size()-1; i>=0; i--) {
        //     System.out.print(list.get(i) + " ");
        // }
        // System.out.println();

        //FIND MAXIMUM ELEMENT
        // int max = Integer.MIN_VALUE;
        // for(int i = 0; i<list.size(); i++) {
        //     // if(max < list.get(i)) {
        //     //     max = list.get(i);
        //     // }
        //     max = Math.max(max, list.get(i));
        // }
        // System.out.println("max element = " + max);

        //swap 2 numbers
        // int idx1 = 1, idx2 = 2;
        // System.out.println(list);
        // swap(list, idx1, idx2);
        // System.out.println(list);

        //sorting arraylist
        // Collections.sort(list);
        // System.out.println(list); //ascending

        // //descending
        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);

        //multi-dimensional arrayList
        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // ArrayList<Integer> list1 = new ArrayList<>();
        // list1.add(1); list1.add(2);
        // mainList.add(list1);

        // ArrayList<Integer> list2 = new ArrayList<>();
        // list2.add(3); list2.add(4);
        // mainList.add(list2);

        // for(int i = 0; i<mainList.size(); i++) {
        //     ArrayList<Integer> currList = mainList.get(i);
        //     for(int j = 0; j<currList.size(); j++) {
        //         System.out.println(currList.get(j) + " ");
        //     }
            
        // }
        // System.out.println(mainList);

            // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
            // ArrayList<Integer> list1 = new ArrayList<>();
            // ArrayList<Integer> list2 = new ArrayList<>();
            // ArrayList<Integer> list3 = new ArrayList<>();

            // for(int i = 1; i<=5; i++) {
            //     list1.add(i*1); //1 2 3 4 5
            //     list2.add(i*2); //2 4 6 8 10
            //     list3.add(i*3); // 3 6 9 12 15
            // }

            // mainList.add(list1);
            // mainList.add(list2);
            // mainList.add(list3);
            // System.out.println(mainList);

            // for(int i = 0; i<mainList.size(); i++) {
            //     ArrayList<Integer> currList = mainList.get(i);
            //     for(int j = 0; j<currList.size(); j++) {
            //         System.out.print(currList.get(j) + " ");
            //     }
            //     System.out.println();
            //}

        // ArrayList<Integer> height = new ArrayList<>();
        // //1, 8, 6, 2, 5, 4, 8, 3, 7
        // height.add(1);
        // height.add(8);
        // height.add(6);
        // height.add(2);
        // height.add(5);
        // height.add(4);
        // height.add(8);
        // height.add(3);
        // height.add(7);

        // //System.out.println(storeWater(height));
        // System.out.println(storeWater(height));
        

        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);
        // list.add(6);
        // int target = 5;
        // //System.out.println(pairSum1(list, target));
        // System.out.println(pairsum1(list, target));

        ArrayList<Integer> list = new ArrayList<>();
        //11, 15, 6, 8, 9, 10 - Sorted & Rotated
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 100;
        System.out.println(pairSum2(list, target));

        

        





    }
}

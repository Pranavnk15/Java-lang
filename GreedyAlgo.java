
import java.util.*;
public class GreedyAlgo {

    static class Job {
        int deadLine;
        int profit;
        int id;

        public Job(int i, int d, int p) {
            id = i;
            deadLine = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        // int start[] = {1, 3, 0, 5, 8, 5};
        // int end[] = {2, 4, 6, 7, 9, 9};

        // //sorting
        // int activities[][] = new int[start.length][3];
        // for(int i = 0; i<start.length; i++) {
        //     activities[i][0] = i;
        //     activities[i][1] = start[i];
        //     activities[i][2] = end[i];
        // }

        // //lambda function -> shortform of big function
        // Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // //end time basis sorted
        // int maxAct = 0;
        // ArrayList<Integer> ans = new ArrayList<>();

        // //1st Activity
        // maxAct = 1;
        // ans.add(activities[0][0]);
        // int lastEnd = activities[0][2];
        // for(int i = 0; i<end.length; i++) {
        //     if(activities[i][1] >= lastEnd) {
        //         //activity select
        //         maxAct++;
        //         ans.add(activities[i][0]);
        //         lastEnd = activities[i][2];
        //     }
        // }

        // System.out.println("Max Activites = " + maxAct);
        // for(int i = 0; i<ans.size(); i++) {
        //     System.out.print("A" + ans.get(i)+ " ");
        // }
        // System.out.println();


        //KNAPSACK PROBLEM
        // int val[] = {60, 100, 120};
        // int weight[] = {10, 20, 30};
        // int w  = 50;
        // double ratio[][] = new double[val.length][2];
        // // 0th col => idx: 1st col => ratio

        // for(int i = 0; i<val.length; i++) {
        //     ratio[i][0] = i;
        //     ratio[i][1] = val[i]/(double)weight[i];
        // }

        // //ascending order
        // Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        // int capacity = w;
        // int finalVal = 0;
        // for(int i = ratio.length-1; i>=0;i--) {
        //     int idx = (int)ratio[i][0];
        //     if(capacity >= weight[idx]) {
        //         //include full item
        //         finalVal += val[idx];
        //         capacity -= weight[idx];
        //     } else {
        //         //include fractional item
        //         finalVal += (ratio[i][1]*capacity);
        //         capacity = 0;
        //         break;
        //     }
        // }
        // System.out.println("Final Value = " + finalVal);


        //MIN ABSOLUTE DIFFERENCE PAIR
        // int A[] = {4, 1, 8, 7};
        // int B[] = {2, 3, 6, 5};

        // Arrays.sort(A);
        // Arrays.sort(B);

        // int minDiff = 0;
        // for(int i = 0; i<A.length; i++){
        //     minDiff += Math.abs(A[i]-B[i]);
        // }
        // System.out.println("min Absolute diff of pairs = " + minDiff);


        //MAXIMUM LENGTH CHAIN OF PAIRS
        // int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};
        // Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        // int chainLen = 1;
        // int chainEnd = pairs[0][1]; //Last selected pair end //chain end

        // for(int i = 1; i<pairs.length; i++) {
        //     if(pairs[i][0] > chainEnd) {
        //         chainLen++;
        //         chainEnd = pairs[i][1];
        //     }
        // }
        // System.out.println("Max length of chain = " + chainLen);
            

        //INDIAN COINS PROBLEM
        // Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        // Arrays.sort(coins, Comparator.reverseOrder());

        // int countOfCoins = 0;
        // int amout = 590;
        // ArrayList<Integer> ans = new ArrayList<>();

        // for(int i = 0; i<coins.length; i++) {
        //     if(coins[i] <= amout) {
        //         while(coins[i] <= amout) {
        //             countOfCoins++;
        //             ans.add(coins[i]);
        //             amout -= coins[i];
        //         }
        //     }
        // }
        // System.out.println("Total (min) coins used = " + countOfCoins);
        // for(int i = 0; i<ans.size(); i++) {
        //     System.out.print(ans.get(i) + " ");
        // }
        // System.out.println(); 


        //JOB SEQUENCING PROBLEM
        // int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        // ArrayList<Job> jobs = new ArrayList<>();
        // for(int i = 0; i<jobsInfo.length; i++) {
        //     jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        // }

        // Collections.sort(jobs, (obj1, obj2) -> obj2.profit-obj1.profit);
        // //descind order of profit

        // ArrayList<Integer> seq = new ArrayList<>();
        // int time = 0;
        // for(int i = 0; i<jobs.size(); i++) {
        //     Job curr = jobs.get(i);
        //     if(curr.deadLine > time) {
        //         seq.add(curr.id);
        //         time++;
        //     }
        // }

        // //print seq
        // System.out.println("Max Jobs = " + seq.size());
        // for(int i = 0; i<seq.size(); i++) {
        //     System.out.print(seq.get(i) + " ");
        // }
        // System.out.println();
        

        //CHOCOLA PROBLEM
        int n = 4, m = 6;
        Integer costVer[] = {2, 1, 3, 1, 4}; //m-1
        Integer costHor[] = {4, 1, 2}; //n-1

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0; //pointer for cost traversing
        int hp = 1, vp = 1; //pointer for no. of pieces
        int cost = 0;

        while(h < costHor.length && v < costVer.length) {
            if(costVer[v] <= costHor[h]) {
                //horizontal cut
                cost += (costHor[h]* vp);
                hp++;
                h++;
            } else {
                //vertical cut
                cost += (costVer[v]*hp);
                vp++;
                v++;
            }
        }

        while(h < costHor.length) {
            cost += (costHor[h]* vp);
            hp++;
            h++;
        }
        while(v < costVer.length) {
            cost += (costVer[v]*hp);
            vp++;
            v++;
        }
        System.out.println("Min cost of cuts is: " + cost);
        
    }
}

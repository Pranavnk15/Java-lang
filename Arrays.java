
import java.util.*;

public class Arrays {

    public static int trapppedRainWater(int height[]) { // O(n)
        int n = height.length;
        //calculate left max boundary in array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i = 1; i<n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        // calculate right max boundary in array
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];

        for(int i = n-2; i >= 0; i-- ) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int trappeddWater = 0;

        //loop
        
        for(int i = 0; i<n; i++) {

             //find minimum of (leftmax, rightmax) which will give waterlevel
            int waterLevel = Math.min(leftMax[i], rightMax[i]);

             //trapped water = waterlevel - height
            trappeddWater += waterLevel-height[i];
            

        }
        return trappeddWater;
       

       

    }

    public static int buyAndSellStocks(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i<prices.length; i++){
            if(buyPrice < prices[i]) {
                //profit
                int profit = prices[i] - buyPrice; // todays profit
                maxProfit = Math.max(maxProfit, profit); // overall max profit
            } else {
                buyPrice = prices[i];
            }

        }  
        return maxProfit;  
   
    }    

    public static boolean compare(int nums[]) {
        
        for(int i = 0; i<nums.length-1; i++) {
            for(int j = i+1; j<nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                } 
                
            }
            
        }
        
        return false;
    }

    public static int maxProfit(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i<prices.length; i++) {
            if(buyPrice < prices[i]) {
                // profit
                int profit = prices[i] - buyPrice; 
                maxProfit = Math.max(maxProfit, profit);

            } else {
                buyPrice = prices[i];

            }
        
        }
        return maxProfit;
    }

    public static int waterTrapped(int height[]) {
        //left max boundary
        int n = height.length;
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for(int i = 1; i<n; i++) {
            leftMax[i] = Math.max(leftMax[i], height[i-1]);
        }
        // right max boundary
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for( int i = n-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i], height[i+1]);
        }
        //loop
        int trappeddWater = 0;
        for( int i = 0; i< n; i++) {
            //waterlevel = min(leftmax and rightmax)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            //watertrapped = waterlevel - bar height
            trappeddWater = waterLevel - height[i];

        }
        
        return trappeddWater;
    }

    public int search(int nums[], int target) {
        // min will have index of minimum element of nums
        int min = minSearch(nums);
        //find in sorted left
        if(nums[min] <= target && target <= nums[nums.length-1]) {
            return search(nums, min, nums.length-1, target);
        } else{
            //find in sorted right
            return search(nums, 0, min, target);
        }
    }

    public int search(int[] nums, int left, int right, int target) {
        //binary search to find target in left to right boundary
        int l = left;
        int r = right;
        //system.out.println(left+" "+right);
        while(l <= r) {
            int mid = l + (r-1)/2;
            if(nums[mid] == target) {
                return mid;
            } 
            
            else if(nums[mid > target]) {
                r = mid-1;
            } else {
                l = mid+1;
            }
            
        }
        return -1;
    }

    public int minSearch(int nums[]) {
        int left = 0;
        int right = nums.lenght-1;
        while(left < right) {
            int mid = left + (right-left)/2;
            if(mid > 0 && nums[mid-1 >nums[mid]]) {
                return mid;
            }
            else if(nums[left] <= nums[mid] && nums[mid] > nums[right]) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
      int nums[] = {4, 5, 6, 7, 0, 1, 2};
      int target = 0;

      System.out.println(search(nums[], target));
      
        

    }

    
}

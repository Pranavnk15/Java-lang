import java.util.*;

public class DistinctElements {

    public static int[] prefixDistinct(int n, int arr[]) {
        int[] ans = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        int countOfDist = 1;
        ans[0] = arr[0];
        map.put(arr[0], 1);
        for(int i = 1; i<n; i++) {
            if(map.containsKey(arr[i])) {
                ans[i] = countOfDist;
            } else {
                countOfDist++;
                ans[i] = countOfDist;
                map.put(arr[i], 1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 2};
        int n = 4;

        int ans[] = prefixDistinct(n, arr);
        for(int i = 0; i<n; i++) {
            System.out.print(ans[i]+ " ");
        }
    }
}
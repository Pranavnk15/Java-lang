import java.util.Arrays;

public class Dp5 {
    
    /////////////////////////////////////////////////////
    ///// Wildcard Matching

    public static boolean isMatch(String s, String p)  {
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n+1][m+1];

        //initalize
        dp[0][0] = true;
        //pattern = " "
        for(int i = 1; i<n+1; i++) {
            dp[i][0] = false;
        }
        // s = " "
        for(int j=1; j<m+1; j++) {
            if(p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            }
        }

        //bottom up
        for(int i = 1; i<n+1; i++) {
            for(int j = 1; j<m+1; j++) {
                // case -> ith char == jth char || jth char == '?'
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
    // public static void main(String[] args) {
    //     String s = "abc";
    //     String p = "**d"; //true
    //     System.out.println(isMatch(s, p));
    // }

    ////////////////////////////////////////////////////////////
    //// Catalan's Number

    // recursion method
    public static int catalanRec(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for(int i = 0; i<n; i++) {
            ans += catalanRec(i) * catalanRec(n-i-1);
        }

        return ans;
    }
    // memoization code
    public static int catalanMem(int n, int dp[]) {
        if(n == 0 || n == 1) {
            return 1;
        }

        if(dp[n] != -1) {
            return dp[n];
        }
        int ans = 0;
        for(int i = 0; i<n; i++) {
            ans += catalanMem(i, dp) * catalanMem(n-i-1, dp);
        }
        return dp[n] = ans;
    }
    // Tabulation code
    public static int catalanTab(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i<=n; i++) {
            for(int j = 0; j<i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];

    }
    // public static void main(String[] args) {
    //     int n = 4;
    //    // System.out.println(catalanRec(n));

    //     // int dp[] = new int[n+1];
    //     // Arrays.fill(dp, -1);
    //     // System.out.println(catalanMem(n, dp));
    //     System.out.println(catalanTab(n));
    // }
    //////////////////////////////////////////////////////
    // Counting BST

    public static int countBST(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i<=n; i++) {
            for(int j = 0; j<i; j++) {
                //ci = cj*ci-j-1
                int left = dp[j];
                int right = dp[i-j-1];
                dp[i] += left * right;
            }
        }
        return dp[n];

    }
    // public static void main(String[] args) {
    //     int n = 4;
    //     System.out.println(countBST(n));
    // }
    /////////////////////////////////////////////
    //// Mountain Ranges


    public static int mountainRanges(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i<=n; i++) {
            for(int j = 0; j<i; j++) {
                int inside = dp[j];
                int outside = dp[i-j-1];
                dp[i] += inside*outside;
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(mountainRanges(n));
    }
}

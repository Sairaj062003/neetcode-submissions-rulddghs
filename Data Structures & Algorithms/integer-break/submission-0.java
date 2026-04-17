public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int num = 2; num <= n; num++) {
            dp[num] = (num == n) ? 0 : num;
            for (int i = 1; i < num; i++) {
                int p=0;
                if( dp[i] > dp[num - i] ){
                    break;
                }else{
                   p=dp[i] * dp[num - i];  
                }

                 dp[num] = Math.max(dp[num],p);
                

            }
        }

        return dp[n];
    }
}
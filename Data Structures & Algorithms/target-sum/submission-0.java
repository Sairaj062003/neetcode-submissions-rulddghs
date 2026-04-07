class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int arraysum = Arrays.stream(nums).sum();


          if (Math.abs(target) > arraysum || (target + arraysum) % 2 != 0) {
            return 0;
        }

        int sum = (target + arraysum)/2;


        return countsubdiff(nums,sum);
    }

    private int countsubdiff(int[] nums , int sum){

        int[][] dp = new int[nums.length+1][sum+1];

        for(int i =1 ; i<=sum;i++) dp[0][i]=0;
        for(int j =0 ; j<=nums.length;j++) dp[j][0]=1;

        for(int i =1 ; i<=nums.length ;i++){
            for(int j =0 ; j<=sum;j++){

                if(nums[i-1] <= j){
                    dp[i][j]=dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]; 
                }
            }
        }
     return dp[nums.length][sum];


    }
}
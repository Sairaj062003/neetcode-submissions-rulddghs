class Solution {
    public boolean canPartition(int[] nums) {
       int sum = Arrays.stream(nums).sum();

       if(sum %2 != 0) return false;

       return subsetsum(nums,sum/2); 
    }

    private boolean subsetsum(int[] nums , int sum){
        boolean[][] mat = new boolean[nums.length+1][sum+1];

        for (int i = 0; i <= nums.length; i++) mat[i][0] = true;
        for (int j = 1; j <= sum; j++) mat[0][j] = false;

        
        for(int i =1 ; i<= nums.length ; i++ ){
            for(int j = 1 ; j<=sum; j++){

                if(nums[i-1]<=j){
                    mat[i][j]=mat[i-1][j-nums[i-1]] || mat[i-1][j];
                }

                else {
                    mat[i][j]=mat[i-1][j];
                }

    }
    
}
return mat[nums.length][sum];
    }
}
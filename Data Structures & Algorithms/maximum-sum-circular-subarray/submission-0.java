class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = Integer.MIN_VALUE ;
        int n = nums.length;

        for(int i =0 ; i < n; i++){
            int sum =0;

            for(int  j =i ; j< i+n ; j++){
                sum+=nums[j %n];
                max = Math.max(max , sum);
            }
            
        }
        return max;
    }
}
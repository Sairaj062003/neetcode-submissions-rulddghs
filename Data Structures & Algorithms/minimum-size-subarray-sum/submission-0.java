class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l =0 ; int res = Integer.MAX_VALUE;
        int total =0;

        for(int i = 0 ; i<nums.length ; i++){

            total += nums[i];

            while(total >=target){
                res = Math.min(i-l+1 , res);

                total -=nums[l];
                l++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 :res;
    }
}
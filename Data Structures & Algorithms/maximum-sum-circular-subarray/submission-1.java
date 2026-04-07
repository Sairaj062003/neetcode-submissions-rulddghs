class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        int minsum = kadeneMin(nums,n);
        
        int maxsum = kadeneMax(nums,n);

        int circular_sum = sum-minsum;


        return maxsum >0 ? Math.max(maxsum,circular_sum): maxsum;
    }

    int kadeneMax(int[] nums,int n){
        int sum = nums[0];
        int maxsum = nums[0];

        for(int i =1 ; i<n ;i++){
            sum=Math.max(sum+nums[i],nums[i]);
            maxsum= Math.max(maxsum,sum);
        }
        return maxsum;
    }

     int kadeneMin(int[] nums,int n){
        int sum = nums[0];
        int minsum = nums[0];

        for(int i =1 ; i<n ;i++){
            sum=Math.min(sum+nums[i],nums[i]);
            minsum= Math.min(minsum,sum);
        }
        return minsum;
    }
}
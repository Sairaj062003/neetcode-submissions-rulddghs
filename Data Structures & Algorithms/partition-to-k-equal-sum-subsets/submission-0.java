class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        
        if (sum % k != 0) return false;
        
        int target = sum / k;
        int n = nums.length;
        
        // dp[mask] = remaining sum needed to complete current subset
        // -1 means this state is impossible/not yet visited
        int[] dp = new int[1 << n];  // 2^n possible states
        Arrays.fill(dp, -1);
        dp[0] = 0;  // base: no elements used, current sum = 0
        
        // Try all possible states (subsets)
        for (int mask = 0; mask < (1 << n); mask++) {
            if (dp[mask] == -1) continue;  // skip invalid states
            
            // Try adding each unused element
            for (int i = 0; i < n; i++) {
                // Skip if element i is already used in this mask
                if ((mask & (1 << i)) != 0) continue;
                
                // Create new mask with element i included
                int newMask = mask | (1 << i);
                
                int currentSum = dp[mask];  // sum so far in current subset
                
                // Can we add nums[i] without exceeding target?
                if (currentSum + nums[i] <= target) {
                    // Use modulo to reset to 0 when we complete a subset
                    int newSum = (currentSum + nums[i]) % target;
                    
                    // Update only if not visited yet
                    if (dp[newMask] == -1) {
                        dp[newMask] = newSum;
                    }
                }
            }
        }
        
        // Check if we used all elements and completed all subsets
        return dp[(1 << n) - 1] == 0;
    }
}

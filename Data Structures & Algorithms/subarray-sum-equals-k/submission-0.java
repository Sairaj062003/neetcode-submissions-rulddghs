class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0 , cursum =0;
        map.put(0,1);
        for(int num : nums){
            cursum+=num;
            int diff = cursum - k;
            res+=map.getOrDefault(diff,0);
            map.put(cursum,map.getOrDefault(cursum,0)+1);
        }
   return res;
    }
}
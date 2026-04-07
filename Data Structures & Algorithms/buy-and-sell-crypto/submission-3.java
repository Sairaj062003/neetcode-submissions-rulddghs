class Solution {
    public int maxProfit(int[] prices) {
        
            int val = Integer.MAX_VALUE;
            int t = 0;
            int profit = 0;
         for(int sell : prices){
            profit=Math.max(profit, sell-val);
            val=Math.min(val,sell);
         }      
      return profit ;      
    }


}

class Solution {
    public int maxProfit(int[] prices) {
        
            int val = Integer.MAX_VALUE;
            int t = 0;
            int profit = 0;
            for(int i = 0 ; i < prices.length ; i++){
               
                    val=prices[i];
                    t=i;
                
             
                for(int j = t+1 ; j<prices.length ;j++ ){
                    
                         profit = Math.max(profit , prices[j]-val)  ;
                    }

                    
                }

           return profit ;      
            
    }


}

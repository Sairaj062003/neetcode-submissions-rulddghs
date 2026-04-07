class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min_weight = Maxelement(weights);
        int max_weight = SumOfArray(weights);

        int ans = max_weight;
         
         while(min_weight<=max_weight){
           int mid_weight = min_weight+(max_weight-min_weight)/2;

           if(canShip(weights,days,mid_weight)){
               ans=Math.min(ans,mid_weight);
               max_weight=mid_weight-1;
           }
           else{
                min_weight=mid_weight+1;
           }
        }
        return ans ;
    }
    private int Maxelement(int[] weights){
        int l = 0;
        for(int i = 0 ; i<weights.length ; i++){
            if(l<weights[i]){
                l=weights[i];
            }
        }
        return l;
    }
    
     private int SumOfArray(int[] weights){
        int sum = 0;
        for(int i = 0 ; i<weights.length ; i++){
           sum+=weights[i];
        }
        return sum;
    }

   private boolean canShip(int[] weights,int days,int mid_weight){

    int ship=1  , current_cap=mid_weight;

    for(int w : weights){
        
       if(current_cap-w<0){
        ship++;
        if(ship>days){
            return false;
        }

       current_cap=mid_weight;
       }
       current_cap-=w;
    }

    return true;

   }

}
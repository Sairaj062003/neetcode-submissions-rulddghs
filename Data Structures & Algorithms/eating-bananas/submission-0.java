class Solution {
    static boolean func(int mid,int h,int[] piles){
    
       long totaltime =0;
       for(int i = 0 ; i<piles.length ; i++){
            totaltime += Math.ceil((double) piles[i]/mid);
            if(totaltime>h) return false;
       }
       
        return true;
      
    

    }

    public int minEatingSpeed(int[] piles, int h) {
         int start = 1;
         int maxend = 0;

         for(int pile : piles) if(pile>maxend) maxend=pile;



   while(start<=maxend){
       int mid = start +(maxend-start)/2;
       boolean bananarate = func(mid,h,piles);

       
       if(bananarate) maxend = mid-1;
        else{ start=mid+1;}

   }

   return start;
    }

    
}

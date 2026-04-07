class Solution {
    public boolean lemonadeChange(int[] bills) {
       int fivecoin = 0 , tencoin=0;

       for(int i = 0 ; i<bills.length ; i++ ){
          if(bills[i] == 5) fivecoin++;
          else if(bills[i] == 10){
            tencoin++; 
            if(fivecoin>0){
               fivecoin--;
            }
            else{
                return false;
            }
          }
          else{
            if(fivecoin>0 && tencoin>0){
               fivecoin--;
               tencoin--;
            }
            else if (fivecoin >= 3){
                fivecoin -=3;
            }
            else{

                return false;
            }

          }
       } 
       return true ;
    }
}
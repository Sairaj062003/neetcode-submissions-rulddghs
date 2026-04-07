class Solution {
    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);

        for(int l = 0 , r =matchsticks.length-1 ; l<r ; l++ ,r-- ){
            int temp = matchsticks[l];
           matchsticks[l] = matchsticks[r];
           matchsticks[r] = temp;
        }

        int[] side = new int[4];
        int sum = Arrays.stream(matchsticks).sum() ;
        if(sum %4 != 0) return false;
        int target = sum /4; 
          
        return isSquareside(matchsticks ,target,0,side)  ;
     }
    
    private boolean isSquareside(int[] matchsticks , int target, int i, int[] side){

        if(i == matchsticks.length && target== side[0]  && 
        target== side[1]&& target== side[2] && target== side[3]){
            return true;
        }

           for (int j = 0; j < 4; j++) {
        if (side[j] + matchsticks[i] <= target) {
            side[j] += matchsticks[i];
            if (isSquareside(matchsticks, target, i + 1, side)) return true;
            side[j] -= matchsticks[i];
        }
    }
    return false;    
    }
    
}



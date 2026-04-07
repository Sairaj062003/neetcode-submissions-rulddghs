class Solution {
    public int findJudge(int n, int[][] trust) {
      
       int[] trustcount = new int[n+1];
       int[] trustby=new int[n+1];

       for(int[] t :trust){
        trustcount[t[0]]++;
        trustby[t[1]]++;
       }

     for(int i = 1; i <= n; i++) {
            if(trustcount[i] == 0 && trustby[i] == n - 1) {
                return i;  // found the judge
        }
     }
      return -1; 
    }
}
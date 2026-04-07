class Solution {
    public int[][] merge(int[][] intervals) {
         int[][] result = new int[intervals.length][2];
         Arrays.sort(intervals , Comparator.comparing(i ->i[0]));
        
        int j =0;
       int[] current = intervals[0];
       
       for(int i  =1 ; i<intervals.length ; i++){
        if(intervals[i][0] <= current[1]){
              current[0]= Math.min(current[0],intervals[i][0]);
              current[1]=Math.max(current[1],intervals[i][1]);
        }
        else{
            result[j++]= current;
            current = intervals[i];
            
        }
       }
        result[j++]= current;


          
return Arrays.copyOf(result, j);

     
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals ,  Comparator.comparing(i ->i[0]));
        Stack<int[]> stack = new Stack<>();
        int[] current = intervals[0];
        for(int  i =1 ; i<intervals.length ; i++){
           if(intervals[i][0] < current[1]){
               
                   if(intervals[i][1] > current[1]){
                      stack.push(intervals[i]);
                   }
                   else{
                       stack.push(current);
                       current=intervals[i];
                   }
               }
               else{
                    current=intervals[i];
               }
           }
           
        
        return stack.size();
    }
}
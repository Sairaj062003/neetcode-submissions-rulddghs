class Solution {
    public int[] getOrder(int[][] tasks) {
        List<Integer>result = new ArrayList<>();
     int n = tasks.length;
       for(int i = 0 ; i < tasks.length ; i++){
          tasks[i] = new int[] {tasks[i][0] , tasks[i][1] ,i};
      }

       Arrays.sort(tasks , (a,b) -> Integer.compare(a[0],b[0]));
      PriorityQueue<int[]> minHeap = new PriorityQueue<>(
    (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
);


        long currentTime = 0;
        int idx=0;

        while(idx < tasks.length || !minHeap.isEmpty() ){
           
             if (minHeap.isEmpty() && tasks[idx][0] > currentTime ) {
                currentTime = tasks[idx][0];
            }

            while (idx < n && tasks[idx][0] <= currentTime) {
                minHeap.offer(new int[]{tasks[idx][1], tasks[idx][2]}); // processingTime, originalIndex
                idx++;
            }

            int[] pair = minHeap.poll();
            currentTime += pair[0];
            result.add(pair[1]);
        
    } 

    int[] ans = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            ans[i] = result.get(i);
        }
        return ans;
    
   
    }
    
}
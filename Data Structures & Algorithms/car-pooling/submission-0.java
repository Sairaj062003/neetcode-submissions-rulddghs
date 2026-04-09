class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        Arrays.sort(trips ,(a,b) ->Integer.compare(a[1],b[1]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->Integer.compare(a[0],b[0]));
         int currentcap =0 ;
        for(int[] trip : trips){
            

              int cap=trip[0] , start=trip[1] ,end=trip[2] ; 

while (!pq.isEmpty() && start >= pq.peek()[0]) {
    currentcap -= pq.poll()[1];
}


              currentcap+=cap;

              if(currentcap > capacity) return false;



              pq.offer( new int[] {end,cap});
        }

       return true ;

    }
}
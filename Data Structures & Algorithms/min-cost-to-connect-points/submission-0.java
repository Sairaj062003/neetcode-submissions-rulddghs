class Pair {
    int node;
    int distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<Pair>> list = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
             list.add(new ArrayList<>());
          }

        for(int i = 0 ; i<points.length ; i++){

            for(int j = i+1 ; j<points.length ;j++){
                int dist = Math.abs(points[i][0] - points[j][0]) 
                         + Math.abs(points[i][1] - points[j][1]);
                list.get(i).add(new Pair(j,dist));
                list.get(j).add(new Pair(i,dist));
            }
        }
       int mincost = 0;
       boolean[] visited = new boolean[points.length];
      PriorityQueue<Pair> pq = new PriorityQueue<>(
    (a, b) -> Integer.compare(a.distance, b.distance)
          );

        pq.offer(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int dist = curr.distance;

            if(!visited[node] ){
               visited[node]=true;
               mincost+=dist;

               for(Pair abj : list.get(node)){
                       int n = abj.node;
                       int d = abj.distance;
                      if(!visited[n]){
                        pq.offer(new Pair(n,d) );
                      }
               }
            }
            
        }
      return mincost;
    }
}

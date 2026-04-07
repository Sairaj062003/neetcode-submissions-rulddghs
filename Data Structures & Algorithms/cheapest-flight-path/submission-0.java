class Pairs{
    int second , first ; 

    Pairs(  int first, int second ){
        this.first=first;
        this.second =  second;
    }
}

class Tuples{
    int stop , node ,dist ; 

     Tuples(  int stop , int node , int dist ){
        this.stop=stop;
        this.node =  node;
        this.dist =  dist;

    }
}



class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pairs>> adj = new ArrayList<>();

        for(int i = 0 ; i<n ;i++){
            adj.add( new ArrayList<>());
        }
        
          for(int i = 0 ; i < flights.length ; i++){
           adj.get(flights[i][0]).add(new Pairs(flights[i][1], flights[i][2]));
         }

        int[] min_dist = new int[n];
        Arrays.fill(min_dist,Integer.MAX_VALUE);

        Queue<Tuples> q = new LinkedList<>();
        
        q.offer(new Tuples(0,src,0));

        while(!q.isEmpty()){
            Tuples t = q.poll();

            int st = t.stop;
            int no = t.node;
            int d = t.dist;

            for(Pairs neighbor : adj.get(no)){
                 int nod = neighbor.first;
                 int di = neighbor.second;

                 if(d+di < min_dist[nod] && st<=k){
                   min_dist[nod] = d+di;
                    q.offer(new Tuples(st+1 , nod , d+di));
                 }
            }
        }

        return min_dist[dst]==Integer.MAX_VALUE? -1 : min_dist[dst];
          
    }
}

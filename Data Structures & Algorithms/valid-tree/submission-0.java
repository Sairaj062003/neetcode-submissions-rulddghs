class Solution {
    public boolean validTree(int n, int[][] edges) {
        int m = edges.length;

        if(m != n-1) return false;

        boolean[] vis = new boolean[n];

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i< n ;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i< m ;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
             adj.get(edges[i][1]).add(edges[i][0]);

        }

        int cnt = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
         vis[0]=true;
        while(!q.isEmpty()){
            int node = q.poll();
           

             for(int neighbor : adj.get(node)){
                 if(!vis[neighbor]){
                    vis[neighbor]=true;
                    cnt++;
                    q.offer(neighbor);
                 }
             }
        }


        return cnt==n ? true:false;



    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
         List<List<Integer>> list = new ArrayList<>();
         boolean[] visit = new boolean[n];

         for(int i = 0 ; i<n ; i++){
            list.add(new ArrayList<>());
         }  

          for(int i = 0 ; i<edges.length ; i++){
              int f = edges[i][0];
              int s = edges[i][1]; 
             list.get(f).add(s);
             list.get(s).add(f);
         } 

        int res = 0;
        for (int node = 0; node < n; node++) {
            if (!visit[node]) {
                dfs(list, visit, node);
                res++;
            }
        }


         return res;

            
          
    }

    private void dfs(  List<List<Integer>> list,  boolean[] visit,  int node ){
        visit[node] = true;

        for (int nei : list.get(node)) {
            if (!visit[nei]) {
                dfs(list, visit , nei);
               
            }
        } 

      
    }
}

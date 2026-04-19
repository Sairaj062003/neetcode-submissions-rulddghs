class DisjointSet {
    private int[] parent;
    private int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x1, int x2) {
        int p1 = find(x1);
        int p2 = find(x2);
        if (p1 == p2) {
            return false;
        }
        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}



class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
       int n = accounts.size();
        DisjointSet ds = new  DisjointSet(n);
        Map<String , Integer> map = new HashMap<>();

        for(int i =  0 ; i< n ; i++){
            for(int j =  1 ; j< accounts.get(i).size() ; j++)
            
            if(map.containsKey(accounts.get(i).get(j) ) == false)map.put(accounts.get(i).get(j), i);
            else {
                ds.union(i , map.get(accounts.get(i).get(j)));
            }

        }


        ArrayList<String>[] mergeMail = new ArrayList[n];

        for(int i = 0 ; i< n ; i++){
            mergeMail[i]= new ArrayList<String>();
        }

        for(Map.Entry<String , Integer> it : map.entrySet()){
            String mail = it.getKey();
            int node = ds.find( it.getValue() );
            mergeMail[node].add(mail);
        }
         
         List<List<String>> ans = new ArrayList<>();

         for(int i = 0 ; i< n ; i++){
            if(mergeMail[i].size() == 0) continue;
            List<String> temp = new ArrayList<>();
            Collections.sort(mergeMail[i]);
            temp.add(accounts.get(i).get(0));
            for(String it : mergeMail[i]){
                temp.add(it);
            }
            ans.add(temp);
         }
        
      return ans;

    }
}
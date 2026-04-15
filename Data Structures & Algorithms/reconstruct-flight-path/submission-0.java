class Solution {
    List<String> res = new ArrayList<>();
     Map<String ,List<String> > adj = new HashMap<>();
     int n;

    public List<String> findItinerary(List<List<String>> tickets) {

        n = tickets.size();

        for (List<String> tic : tickets) {
            adj.putIfAbsent(tic.get(0), new ArrayList<>());
            adj.get(tic.get(0)).add(tic.get(1));
        }

        for (String key : adj.keySet()) {
            Collections.sort(adj.get(key));
        } 

         List<String> path = new ArrayList<>();

       DFS("JFK" ,path );
        return res;
         
    }

    private boolean  DFS(String fromcity , List<String> path ){
       path.add(fromcity);

       if(path.size()==n+1) {
        res = new ArrayList<>(path);
        return true;
       }
      
      List<String> temp = adj.get(fromcity);

       for(int  i = 0 ; i<temp.size() ; i++){
           String tocity = temp.get(i);
           temp.remove(i);

           if(DFS(tocity , path)){
            return true;
           }
           temp.add(i,tocity);
       }
       path.remove(path.size() - 1);
       return false;
    }
}

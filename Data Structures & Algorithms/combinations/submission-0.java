class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultlist = new ArrayList<>();
        backtrack(1 ,n, k ,resultlist , new ArrayList<>());

        return resultlist;
    }

    private void backtrack(int start ,int n, int k ,List<List<Integer>> resultlist ,List<Integer> temp){
       

        if(k==0){
            resultlist.add(new ArrayList<>(temp));
            return;
        }

        if(start>n){
            return ;
        }
        
        temp.add(start);
        backtrack(start+1 ,n, k-1 ,resultlist , temp);
        temp.remove(temp.size()-1);
        backtrack(start+1 ,n, k ,resultlist ,temp);
    }
}
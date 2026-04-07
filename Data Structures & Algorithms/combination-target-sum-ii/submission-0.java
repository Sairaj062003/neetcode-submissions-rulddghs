class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         
        List<List<Integer>> outer = new ArrayList<>();
        Arrays.sort(candidates);
        findcombination2(0,candidates,target,outer, new ArrayList<>());
        return outer;
        
    }
   private void findcombination2(int index, int[] candidates, int target,List<List<Integer>> outer, List<Integer> ds){

    if(target == 0){
        outer.add(new ArrayList<>(ds));
        return ;
    }

    for(int i = index ; i< candidates.length ; i++){
        if( i>index && candidates[i]==candidates[i-1]) continue;

        if(candidates[i]>target) break;

        ds.add(candidates[i]);
        findcombination2(i+1,candidates,target-candidates[i],outer, ds);
        ds.remove(ds.size() -1);


    }
   }
    
}

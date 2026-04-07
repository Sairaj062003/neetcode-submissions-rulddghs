class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
         Arrays.sort(nums);
        backtrack(outer , new ArrayList<>() , nums , new boolean[nums.length]);

        return outer;
    }

    private void backtrack(List<List<Integer>> outer,List<Integer> temp , int[] nums , boolean[] used) { 
      
      if(temp.size() == nums.length && !outer.contains(temp)){
        outer.add(new ArrayList<>(temp));
        return ;
      }



      for(int i =0 ; i<nums.length ; i++){
        if(used[i]) continue;

       used[i]=true;
        temp.add(nums[i]);
         backtrack(outer , temp , nums,used);
         temp.remove(temp.size()-1);
        used[i]=false;
      }
     
      }
}
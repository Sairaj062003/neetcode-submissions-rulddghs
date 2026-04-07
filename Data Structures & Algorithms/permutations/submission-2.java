class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
         
        backtrack(outer , new ArrayList<>() , nums);

        return outer;
    }

    private void backtrack(List<List<Integer>> outer,List<Integer> temp , int[] nums) { 
      
      if(temp.size() == nums.length){
        outer.add(new ArrayList<>(temp));
        return ;
      }



      for(int num : nums){
        if(temp.contains(num)) continue;

       
        temp.add(num);
         backtrack(outer , temp , nums);
         temp.remove(temp.size()-1);

      }
     
      }
   
}

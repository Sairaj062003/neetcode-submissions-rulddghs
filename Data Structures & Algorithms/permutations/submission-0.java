class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for(int num : nums){
          List<List<Integer>> internal = new ArrayList<>();
          
        
        for(List<Integer> p: outer){
          for(int i =0 ; i<= p.size() ; i++){
            List<Integer> list = new ArrayList<>(p);
            list.add(i,num);
            internal.add(list);
          }
          
            
        }
        outer=internal;
        }

      return outer ;   
    }
   
}

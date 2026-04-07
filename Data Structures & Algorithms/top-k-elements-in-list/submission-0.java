class Solution {
    public int[] topKFrequent(int[] nums, int k) {
     List<Integer>[] bucket = new List[nums.length +1];

     Map<Integer,Integer> map = new HashMap<>();

     for(int n : nums){
        map.put(n,map.getOrDefault(n,0)+1);
     }

     for(int key : map.keySet()){
          int frequency = map.get(key);
          if(bucket[frequency] == null){
            bucket[frequency] = new ArrayList<>();
          }
          bucket[frequency].add(key);
     }

     int[] ans = new int[k];
     int counter = 0;

     for(int pos = bucket.length -1 ; pos>=0 && counter<k ; pos--){
        if(bucket[pos] != null){
            for(Integer t : bucket[pos]){
                ans[counter]=t;
                counter++;
            }
        }
     }

     return ans ;

    }
}

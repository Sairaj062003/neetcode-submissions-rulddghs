class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i , map.getOrDefault(i,0)+1);
        }
        int n = (nums.length)/3;
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > n){
                list.add(entry.getKey());
            }
        }
        return list;
    }
}
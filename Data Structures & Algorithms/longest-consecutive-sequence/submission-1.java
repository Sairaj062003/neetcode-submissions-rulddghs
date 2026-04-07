class Solution {
    public int longestConsecutive(int[] nums) {
        
        int longestsequence =0 ;
        Map<Integer , Boolean> map = new HashMap<>();

        for(int num : nums){
            map.put(num , Boolean.FALSE);
        }

        for(int num : nums){
            int currentlength = 1;

            int nextnum = num+1;

            while(map.containsKey(nextnum) && map.get(nextnum)==false){
               currentlength++;
               map.put(nextnum , Boolean.TRUE);
               nextnum++;
            }

            int prevnum = num-1;

            while(map.containsKey(prevnum) && map.get(prevnum)==false){
               currentlength++;
               map.put(prevnum , Boolean.TRUE);
               prevnum--;
            }

           longestsequence=Math.max(longestsequence,currentlength) ;
        }

        return longestsequence;
    }
}

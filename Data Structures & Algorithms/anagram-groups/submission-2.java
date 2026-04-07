class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

      Map<String,List<String>> map = new HashMap<>();

        for(String i : strs ){
         char[] saaray = i.toCharArray();
            Arrays.sort(saaray);
            String sortedkey = new String(saaray);

            map.computeIfAbsent(sortedkey, k->new ArrayList<>()).add(i); 
          
    }
     return new ArrayList<>(map.values());  
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> outer = new ArrayList<>();
        int[] mark = new int[strs.length];

        for(int i =0 ; i<strs.length ;i++ ){
            if(mark[i]==1) continue;
            List<String> internal  = new ArrayList<>();
            
            
            char[] saaray = strs[i].toCharArray();
            Arrays.sort(saaray);
                
           internal.add(strs[i]);
            mark[i]=1;

            for(int j = i+1 ; j<strs.length ;j++){
             
             if(mark[j] ==1) continue;
                char[] paaray = strs[j].toCharArray();
                 Arrays.sort(paaray);

                if( Arrays.equals(saaray ,paaray)){
                    
                    mark[j]=1;
                  internal.add(strs[j]);
                }
              
            } 

            outer.add(internal);
        }

        return outer;
    }
}

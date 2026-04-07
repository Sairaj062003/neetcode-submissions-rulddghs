class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left =0 ;
       
         int rigth = 0 ;

         int[] freqS1 = new int[26];
         int[] freqS2 = new int[26];
         for(char c : s1.toCharArray()){
              freqS1[c - 'a']++;
         }

        while( rigth<s2.length() ){ 

            freqS2[s2.charAt(rigth)-'a']++;
            
          
          if(rigth-left+1 >s1.length()){
            freqS2[s2.charAt(left)-'a']--;
             left++;
              }

              if(Arrays.equals(freqS1,freqS2)){
                return true;
              }
              rigth++;

        }

        return false;
    }
}

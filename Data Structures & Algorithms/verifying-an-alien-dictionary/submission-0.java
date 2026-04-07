class Solution {
   static int[] orderMap = new int[26];

    
    public static void buildOrderMap(String order) {
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }
    }

    public boolean isAlienSorted(String[] words, String order) {
      
        buildOrderMap(order);
    int n = words.length;

       for(int i =0 ; i<n-1 ; i++){
        for(int j = 0; j<n-i-1 ; j++){
            if(comparestring(words[j] , words[j+1])>0){
                return false;
            }
        }
        
       }

       return true;
    }

    private int comparestring(String s1 , String s2){
      int n = Math.min(s1.length(),s2.length());
        for(int i =0 ; i<n ;i++){
            if(s1.charAt(i) != s2.charAt(i)){
                return orderMap[s1.charAt(i)-'a'] - orderMap[s2.charAt(i)-'a'];
            }
        }
        return s1.length() - s2.length();
    }
}